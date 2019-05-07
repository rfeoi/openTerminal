package de.rfeoi.openterminal.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StorageType {

    /**
     * Checks if system is able to connect to router block
     * @param pos of possible router block
     * @param worldIn of possible router block
     * @return if there is any connection to the system
     */
    public boolean isBlockCapableToHandleSystem(BlockPos pos, World worldIn){
        return false;
    }

    /**
     * Checks if there are any other (security issues like Security Terminal) for placing block
     * Only if isBlockCapableToHandleSystem is true
     *
     * @param pos of possible router block
     * @param worldIn of possible router block
     * @param player who tries to place the block
     * @return Not able to place message. IMPORTANT: If there is no Error return null (not empty string) only then it is possible to place router block
     */
    public String playerCanNotPlaceSystemHere(BlockPos pos, World worldIn, EntityPlayer player) {
        return "Block not fully configured yet. Please contact Mod author.";
    }

    /**
     * Checks if the required Mods are installed to load the storageHandler
     * @return if it can be used
     */
    public boolean canBeLoaded() {
        return false;
    }

    /**
     * Return new IPluginStorage for block
     * @param tileEntity of router block
     * @return new IPluginStorage
     */
    public IPluginStorage getStorage(TileEntity tileEntity) {
        return null;
    }
}
