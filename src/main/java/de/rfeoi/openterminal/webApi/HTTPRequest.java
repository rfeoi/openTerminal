package de.rfeoi.openterminal.webApi;

import java.util.Arrays;
import java.util.HashMap;

public class HTTPRequest {
    private String path, method;
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

    public String getMethod() {
        return method;
    }

    void setMethod(String method) {
        this.method = method;
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

    public int getQueryOptionsCount() {
        return query.size();
    }

    public String[] getSpecifiedQueryOptions() {
        Object[] options = query.keySet().toArray();
        return Arrays.copyOf(options, options.length, String[].class);
    }

    public String getQuery(String query) {
        return this.query.get(query);
    }
}

