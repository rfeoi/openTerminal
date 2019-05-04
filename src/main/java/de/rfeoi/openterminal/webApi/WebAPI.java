package de.rfeoi.openterminal.webApi;

import de.rfeoi.openterminal.webApi.handler.CraftingTaskHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static de.rfeoi.openterminal.api.API.API;

public class WebAPI implements Runnable{

    private ServerSocket server;
    private static final String HEADER_STATION = "stationNumber";
    private static final IPathHandler[] PATH_HANDLERS = new IPathHandler[]{new CraftingTaskHandler()};

    public WebAPI(int port) throws IOException {
        server = new ServerSocket(port);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(!server.isClosed()) {
            try {
                incomingConnections(server.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void incomingConnections(Socket client) throws IOException {
        HTTPRequest httpRequest = new HTTPRequest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //Reading incoming
        {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                if (line.contains(": ")) {
                    // Header
                    httpRequest.addHeader(line.split(": ")[0], line.split(": ")[1]);
                } else {
                    // First line (e.g. POST /terminal/items?test=1 HTTP/1.1)
                    if (line.contains(" ") && line.split(" ").length == 3){
                        httpRequest.setType(line.split(" ")[0]);
                        String wholePath = line.split(" ")[1];
                        // Check if it has get arguments
                        if (wholePath.contains("?")) {
                            httpRequest.setPath(wholePath.split("\\?")[0]);
                            String query = wholePath.split("\\?")[1];
                            //Check if there is more than one argument
                            if (query.contains("&")) {
                                for (String argument : query.split("&")) {
                                    if (argument.contains("=")) {
                                        httpRequest.addQueryParameter(argument.split("=")[0], argument.split("=")[1]);
                                    } else {
                                        httpRequest.addQueryParameter(argument, null);
                                    }
                                }
                            } else {
                                if (query.contains("=")) {
                                    httpRequest.addQueryParameter(query.split("=")[0], query.split("=")[1]);
                                } else {
                                    httpRequest.addQueryParameter(query, null);
                                }
                            }
                        } else {
                            httpRequest.setPath(wholePath);
                        }
                    }
                }
            }
        }
        // Sending response
        {
            IPathHandler handler = getHandler(httpRequest.getPath());
            String response, statusCode;
            // Content creation
            if (handler == null) {
                // Not found
                response = "{\"status\": 404, \"error\": \"No matching route handler found\"}";
                statusCode = "404";
            }
            else if (!httpRequest.hasHeader(HEADER_STATION) || !API.hasStation(httpRequest.getHeader(HEADER_STATION))) {
                response = "{\"status\": 403, \"error\": \"Station ID not present or wrong\"}";
                statusCode = "403";
            }
            else {
                // Everything should process correctly
                response =  handler.handle(httpRequest, API.getStorage(httpRequest.getHeader(HEADER_STATION)));
                statusCode = "200";
            }
            writer.write("HTTP/1.1 " + statusCode + " \r\n");
            writer.write("Content-Type: application/json\r\n");
            writer.write("Connection: close\r\n");
            writer.write("\r\n");
            writer.write(response);
            writer.flush();
        }
        client.close();
    }

    private IPathHandler getHandler(String path) {
        for (IPathHandler handler : PATH_HANDLERS) {
            if (handler.getPath().equals(path)) {
                return handler;
            }
        }
        return null;
    }
}
