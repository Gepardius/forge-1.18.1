package net.gepardius.gepardiusmod.keybinds;

import net.gepardius.gepardiusmod.GepardiusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.client.gui.ForgeIngameGui.rayTraceDistance;

/*@Mod.EventBusSubscriber(modid = GepardiusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class KeyBindAbilities {

    private KeyBindAbilities(){

    }

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event){

        if (Keybinds.exampleKeyMapping.consumeClick()) {
            Minecraft.getInstance().player.displayClientMessage(new TextComponent("LOL"), false);
        }
    }


}*/
