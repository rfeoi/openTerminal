package de.rfeoi.openterminal.api;

import de.rfeoi.openterminal.api.storageHandler.AEStorage;
import net.minecraft.util.IStringSerializable;

public enum StorageTypes implements IStringSerializable {
    APPLIED_ENERGISTICS(new AEStorage.AEStorageType());

    StorageType  storageType;

    StorageTypes(StorageType storageType) {
        this.storageType = storageType;
    }

    @Override
    public String getName() {
        return "OT_Storage_Types";
    }

    public StorageType getStorageType() {
        return storageType;
    }
}
