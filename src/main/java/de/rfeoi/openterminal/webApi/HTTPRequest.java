package de.rfeoi.openterminal.webApi;

import java.util.HashMap;

public class HTTPRequest {
    private String path, type;
    private HashMap<String, String> header, query;

    public HTTPRequest() {
        header = new HashMap<>();
        query = new HashMap<>();
    }

    public String getPath() {
        return path;
    }

    void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    void addQueryParameter(String name, String value) {
        query.put(name, value);
    }

    void addHeader(String name, String value) {
        header.put(name, value);
    }

    public boolean hasHeader(String headerName) {
        return header.containsKey(headerName);
    }

    public String getHeader(String headerName) {
        return header.get(headerName);
    }
}
