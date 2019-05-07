package de.rfeoi.openterminal.api;

import de.rfeoi.openterminal.api.storageHandler.DebugStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class API {

    public static final API API = new API();
    private ArrayList<StorageType> storageTypes;
    private HashMap<String, IPluginStorage> stationConnector;

    public API() {
        storageTypes = new ArrayList<>();
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

    public void registerStorageType(StorageType storageType) {
        storageTypes.add(storageType);
    }

    public StorageType[] getStorageTypes() {
        Object[] array = storageTypes.toArray();
        return Arrays.copyOf(array, array.length, StorageType[].class);
    }
}
