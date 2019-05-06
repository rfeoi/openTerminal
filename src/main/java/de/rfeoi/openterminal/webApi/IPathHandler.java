package de.rfeoi.openterminal.webApi;

import de.rfeoi.openterminal.api.IPluginStorage;

import java.util.Dictionary;

public interface IPathHandler {
    String getPath();
    String getMethod();
    String[] getNeededQueryParams();
    String handle(HTTPRequest query, IPluginStorage storage);
}
