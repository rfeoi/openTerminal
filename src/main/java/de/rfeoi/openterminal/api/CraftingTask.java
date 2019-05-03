package de.rfeoi.openterminal.api;

import de.rfeoi.openterminal.OpenTerminal;
import net.minecraft.item.ItemStack;

public class CraftingTask {

    private ItemStack output;

    /**
     * Crafting Task
     * @param itemStack which the task produces
     */
    public CraftingTask(ItemStack itemStack) {
        output = itemStack;
    }

    /**
     * Output of the Task
     * @return output as ItemStack
     */
    public ItemStack getOutput() {
        return output;
    }

    /**
     * Returns JSON of Class
     * @return String json formatted
     */
    public String getJSON() {
        return OpenTerminal.GSON.toJson(this);
    }
}
