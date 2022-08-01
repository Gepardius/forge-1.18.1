package net.gepardius.gepardiusmod.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import static net.minecraftforge.client.gui.ForgeIngameGui.rayTraceDistance;


public class teleportItem extends Item {
    public teleportItem(Properties pProperties) {
        super(pProperties);
    }


    /*@Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {

        // rayTraceDistance = 500.D;

        Double distance = 500.D;

        HitResult viewedBlock = player.pick(distance, 0.0F, false);
        Double x = viewedBlock.getLocation().x;
        Double y = viewedBlock.getLocation().y;
        Double z = viewedBlock.getLocation().z;
        y += 1;

        if (player instanceof ServerPlayer){
            System.out.println("nothing happens");
            // player.teleportToWithTicket(x, y, z);
        }

        if (!level.isClientSide) {

            System.out.println("nothing happens");
            ((ServerPlayer) player).connection.teleport(x, y, z, 1, 1);
            // player.teleportToWithTicket(x, y, z);

        }

        // rayTraceDistance = 20.0D;
        return super.use(level, player, pUsedHand);
    }*/

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        Double distance = 500.0D;

        if (player instanceof ServerPlayer serverPlayer) {

            HitResult viewedBlock = player.pick(distance, 0.0F, false);
            Double x = viewedBlock.getLocation().x;
            Double y = viewedBlock.getLocation().y;
            Double z = viewedBlock.getLocation().z;
            y += 1;

            System.out.println("Server happens");
            player.teleportToWithTicket(x, y, z);
            // serverPlayer.connection.teleport(x, y, z, 0.0F, 0.0F);
        }
        if (!level.isClientSide) {
            System.out.println("Client happens");
        }
        return super.use(level, player, hand);
    }
}
