package de.rfeoi.openterminal.api.storageHandler;

import de.rfeoi.openterminal.api.CraftingTask;
import de.rfeoi.openterminal.api.IPluginStorage;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class DebugStorage implements IPluginStorage {
    @Override
    public ItemStack[] getItems() {
        ArrayList<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(10)) {
                case 0:
                    items.add(new ItemStack(Items.CAKE, new Random().nextInt(2500)));
                    break;
                case 1:
                    items.add(new ItemStack(Items.APPLE, new Random().nextInt(2500)));
                    break;
                case 2:
                    items.add(new ItemStack(Items.BANNER, new Random().nextInt(2500)));
                    break;
                case 3:
                    items.add(new ItemStack(Items.IRON_INGOT, new Random().nextInt(2500)));
                    break;
                case 4:
                    items.add(new ItemStack(Items.BOWL, new Random().nextInt(2500)));
                    break;
                case 5:
                    items.add(new ItemStack(Items.BOW, new Random().nextInt(2500)));
                    break;
                case 6:
                    items.add(new ItemStack(Items.MELON, new Random().nextInt(2500)));
                    break;
                case 7:
                    items.add(new ItemStack(Items.SUGAR, new Random().nextInt(2500)));
                    break;
                case 8:
                    items.add(new ItemStack(Items.POTATO, new Random().nextInt(2500)));
                    break;
                case 9:
                    items.add(new ItemStack(Items.IRON_SWORD, new Random().nextInt(2500)));
                    break;
            }
        }
        return (ItemStack[]) items.toArray();
    }

    @Override
    public ItemStack[] getAutocraftable() {
        return new ItemStack[]{new ItemStack(Items.COAL)};
    }

    @Override
    public CraftingTask[] getCraftingTasks() {
        return new CraftingTask[]{new CraftingTask(new ItemStack(Items.COAL, 22))};
    }

    @Override
    public boolean craft(ItemStack itemStack) {
        return false;
    }
}