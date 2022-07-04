package net.gepardius.gepardiusmod.item;

import net.gepardius.gepardiusmod.GepardiusMod;
import net.gepardius.gepardiusmod.item.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GepardiusMod.MOD_ID);

    public static final RegistryObject<Item> GEPARDIE = ITEMS.register("gepardie",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
