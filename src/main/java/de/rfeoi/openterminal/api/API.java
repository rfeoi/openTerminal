package de.rfeoi.openterminal.api;

import de.rfeoi.openterminal.api.storageHandler.DebugStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class API {

    public static final API API = new API();
    private HashMap<String, IPluginStorage> stationConnector;

    public API() {
        stationConnector = new HashMap<>();
        //TODO add Config option to disable
        stationConnector.put("DEBUG", new DebugStorage());
    }

    public IPluginStorage getStorage(String id){
        return stationConnector.get(id);
    }

    public boolean hasStation(String stationID) {
        return stationConnector.containsKey(stationID);
    }

    public String addStorage(IPluginStorage storage) {
        String station = new Random().nextInt(999999) + "";
        stationConnector.put(station, storage);
        return station;
    }
}
