package de.rfeoi.openterminal.api;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IPluginStorage {

    /**
     * Tick method, will be called by tick of tileEntity of Router
     */
    default void tick() {}

    /**
     * Get Items stored in Storage
     * @return Items stored in Storage
     */
    ItemStack[] getItems();

    /**
     * Get Items which can be autocrafted
     * @return Items which are possible able to craft
     */
    ItemStack[] getAutocraftable();

    /**
     * Get running Crafting tasks
     * @return running crafting task
     */
    CraftingTask[] getCraftingTasks();

    /**
     * Craft an item
     * (Please keep in Mind that the count matters)
     *
     * @param itemStack Item Stack which should be crafted
     * @return if the system is able to craft this
     */
    boolean craft(ItemStack itemStack);

    /**
     * Checks if system is able to connect to router block
     * @param pos of possible router block
     * @param worldIn of possible router block
     * @return if there is any connection to the system
     */
    static boolean isBlockCapableToHandleSystem(BlockPos pos, World worldIn){
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
    static String playerCanNotPlaceSystemHere(BlockPos pos, World worldIn, EntityPlayer player) {
        return "Block not fully configured yet. Please contact Mod author.";
    }

}
