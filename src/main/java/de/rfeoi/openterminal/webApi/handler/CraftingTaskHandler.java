package de.rfeoi.openterminal.webApi.handler;

import de.rfeoi.openterminal.api.CraftingTask;
import de.rfeoi.openterminal.api.IPluginStorage;
import de.rfeoi.openterminal.utils.JSONUtil;
import de.rfeoi.openterminal.webApi.HTTPRequest;
import de.rfeoi.openterminal.webApi.IPathHandler;

public class CraftingTaskHandler implements IPathHandler {
    @Override
    public String getPath() {
        return "/tasks";
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public String[] getNeededQueryParams() {
        return new String[0];
    }

    @Override
    public String handle(HTTPRequest query, IPluginStorage storage) {
        StringBuilder export = new StringBuilder("[");
        for (CraftingTask craftingTask : storage.getCraftingTasks()) {
            export.append(JSONUtil.getCraftingTaskJSON(craftingTask)).append(",");
        }
        export.deleteCharAt(export.length() - 1);
        export.append("]");
        return export.toString();
    }
}
