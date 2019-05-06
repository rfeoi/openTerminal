package de.rfeoi.openterminal.webApi.handler;

import de.rfeoi.openterminal.api.IPluginStorage;
import de.rfeoi.openterminal.utils.JSONUtil;
import de.rfeoi.openterminal.webApi.HTTPRequest;
import de.rfeoi.openterminal.webApi.IPathHandler;

public class ItemsHandler implements IPathHandler {
    @Override
    public String getPath() {
        return "/items";
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public String[] getNeededQueryParams() {
        return new String[]{"type"};
    }

    @Override
    public String handle(HTTPRequest query, IPluginStorage storage) {
        switch (query.getQuery("type")) {
            case "all":
                return "{\"stored\": " + JSONUtil.getItemStackArrayJSON(storage.getItems()) + ", \"craftable\": " + JSONUtil.getItemStackArrayJSON(storage.getAutocraftable()) + "}";
            case "stored":
                return "{\"stored\": " + JSONUtil.getItemStackArrayJSON(storage.getItems()) + "}";
            case "craftable":
                return "{\"craftable\": " + JSONUtil.getItemStackArrayJSON(storage.getAutocraftable()) + "}";
            default:
                return "{\"status\": 404, \"error\": \"Operation type not found\"}";
        }
    }
}
