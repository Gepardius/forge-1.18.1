package net.gepardius.gepardiusmod.item;

import net.gepardius.gepardiusmod.GepardiusMod;
import net.gepardius.gepardiusmod.item.custom.gepardie;
import net.gepardius.gepardiusmod.item.custom.deleteItem;
import net.gepardius.gepardiusmod.item.custom.stoneItem;
import net.gepardius.gepardiusmod.item.custom.waterItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GepardiusMod.MOD_ID);

    public static final RegistryObject<Item> GEPARDIE = ITEMS.register("gepardie",
            () -> new gepardie(new gepardie.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> DELETEITEM = ITEMS.register("deleteitem",
            () -> new deleteItem(new deleteItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> WATERITEM = ITEMS.register("wateritem",
            () -> new waterItem(new waterItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> STONEITEM = ITEMS.register("stoneitem",
            () -> new stoneItem(new stoneItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
