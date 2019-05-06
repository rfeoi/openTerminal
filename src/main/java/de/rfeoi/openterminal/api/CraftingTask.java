package de.rfeoi.openterminal.api;

import com.google.gson.annotations.SerializedName;
import de.rfeoi.openterminal.OpenTerminal;
import net.minecraft.item.ItemStack;

public class CraftingTask {

    private transient ItemStack output;
    @SerializedName("calculated_needed_time")
    private String calcTime;

    /**
     * Crafting Task
     * @param itemStack which the task produces
     */
    public CraftingTask(ItemStack itemStack, String calcTime) {
        output = itemStack;
        this.calcTime = calcTime;
    }

    /**
     * Output of the Task
     * @return output as ItemStack
     */
    public ItemStack getOutput() {
        return output;
    }


}
