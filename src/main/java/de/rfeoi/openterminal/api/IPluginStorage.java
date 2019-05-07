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


}
