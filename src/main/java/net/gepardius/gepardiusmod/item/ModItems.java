package net.gepardius.gepardiusmod.item;

import net.gepardius.gepardiusmod.GepardiusMod;
import net.gepardius.gepardiusmod.item.custom.*;
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

    public static final RegistryObject<Item> ICEITEM = ITEMS.register("iceitem",
            () -> new iceItem(new iceItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> LAVAITEM = ITEMS.register("lavaitem",
            () -> new lavaItem(new lavaItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> FIREITEM = ITEMS.register("fireitem",
            () -> new fireItem(new fireItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> TELEPORTITEM = ITEMS.register("teleportitem",
            () -> new teleportItem(new teleportItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static final RegistryObject<Item> BOOSTITEM = ITEMS.register("boostitem",
            () -> new boostItem(new boostItem.Properties().tab(ModCreativeModeTab.GEP_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
