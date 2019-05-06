package de.rfeoi.openterminal.utils;

import com.google.gson.annotations.SerializedName;
import de.rfeoi.openterminal.api.CraftingTask;
import net.minecraft.item.ItemStack;


import static de.rfeoi.openterminal.OpenTerminal.GSON;

public class JSONUtil {

    public static String getItemStackJSON(ItemStack itemStack) {
        return GSON.toJson(new SimpleItemStack(itemStack));
    }

    public static String getItemStackArrayJSON(ItemStack[] itemStacks) {
        SimpleItemStack[] sItems = new SimpleItemStack[itemStacks.length];
        for (int i = 0; i < itemStacks.length; i++) {
            sItems[i] = new SimpleItemStack(itemStacks[i]);
        }
        return GSON.toJson(sItems);
    }

    public static String getCraftingTaskJSON(CraftingTask task) {
        StringBuilder craftingTask = new StringBuilder();
        craftingTask.append(GSON.toJson(task));
        craftingTask.deleteCharAt(craftingTask.length() - 1);
        craftingTask.append(",\"output\": ").append(getItemStackJSON(task.getOutput())).append("}");
        return craftingTask.toString();
    }

}

class SimpleItemStack {
    @SerializedName("item_count")
    private int count;
    @SerializedName("item_name")
    private String name;

    SimpleItemStack(ItemStack itemStack) {
        name = itemStack.getDisplayName();
        count = itemStack.getCount();
    }
}
