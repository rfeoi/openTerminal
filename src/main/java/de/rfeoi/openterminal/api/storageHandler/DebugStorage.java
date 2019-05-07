package de.rfeoi.openterminal.api.storageHandler;

import de.rfeoi.openterminal.api.CraftingTask;
import de.rfeoi.openterminal.api.IPluginStorage;
import de.rfeoi.openterminal.api.StorageType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DebugStorage implements IPluginStorage {
    @Override
    public ItemStack[] getItems() {
        ArrayList<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(10)) {
                case 0:
                    items.add(new ItemStack(Items.CAKE, new Random().nextInt(54564564)));
                    break;
                case 1:
                    items.add(new ItemStack(Items.APPLE, new Random().nextInt(Integer.MAX_VALUE)));
                    break;
                case 2:
                    items.add(new ItemStack(Items.BANNER, new Random().nextInt(452404)));
                    break;
                case 3:
                    items.add(new ItemStack(Items.IRON_INGOT, new Random().nextInt(422222485)));
                    break;
                case 4:
                    items.add(new ItemStack(Items.BOWL, new Random().nextInt(6497)));
                    break;
                case 5:
                    items.add(new ItemStack(Items.BOW, new Random().nextInt(Integer.MAX_VALUE)));
                    break;
                case 6:
                    items.add(new ItemStack(Items.MELON, new Random().nextInt(5424)));
                    break;
                case 7:
                    items.add(new ItemStack(Items.SUGAR, new Random().nextInt(Integer.MAX_VALUE)));
                    break;
                case 8:
                    items.add(new ItemStack(Items.POTATO, new Random().nextInt(25313100)));
                    break;
                case 9:
                    items.add(new ItemStack(Items.IRON_SWORD, new Random().nextInt(57976)));
                    break;
            }
        }
        return Arrays.copyOf(items.toArray(), items.toArray().length, ItemStack[].class);
    }

    @Override
    public ItemStack[] getAutocraftable() {
        return new ItemStack[]{new ItemStack(Items.COAL)};
    }

    @Override
    public CraftingTask[] getCraftingTasks() {
        return new CraftingTask[]{new CraftingTask(new ItemStack(Items.COAL, 22), "22:00:00")};
    }

    @Override
    public boolean craft(ItemStack itemStack) {
        return false;
    }


    public static class DebugStorageType extends StorageType {
        /**
         * Checks if system is able to connect to router block
         *
         * @param pos     of possible router block
         * @param worldIn of possible router block
         * @return if there is any connection to the system
         */
        @Override
        public boolean isBlockCapableToHandleSystem(BlockPos pos, World worldIn) {
            return false;
        }

        /**
         * Checks if there are any other (security issues like Security Terminal) for placing block
         * Only if isBlockCapableToHandleSystem is true
         *
         * @param pos     of possible router block
         * @param worldIn of possible router block
         * @param player  who tries to place the block
         * @return Not able to place message. IMPORTANT: If there is no Error return null (not empty string) only then it is possible to place router block
         */
        @Override
        public String playerCanNotPlaceSystemHere(BlockPos pos, World worldIn, EntityPlayer player) {
            return null;
        }

        /**
         * Checks if the required Mods are installed to load the storageHandler
         *
         * @return if it can be used
         */
        @Override
        public boolean canBeLoaded() {
            return true;
        }

        /**
         * Return new IPluginStorage for block
         *
         * @param tileEntity of router block
         * @return new IPluginStorage
         */
        @Override
        public IPluginStorage getStorage(TileEntity tileEntity) {
            return new DebugStorage();
        }
    }
}
