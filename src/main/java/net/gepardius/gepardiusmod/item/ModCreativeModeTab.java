package net.gepardius.gepardiusmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab GEP_TAB = new CreativeModeTab("geptab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GEPARDIE.get());
        }
    };
}
