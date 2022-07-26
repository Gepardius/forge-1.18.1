package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TargetBlock;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

import static net.minecraftforge.client.gui.ForgeIngameGui.rayTraceDistance;


public class teleportItem extends Item {
    public teleportItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        // entity.pick(rayTraceDistance, 0.0F, false);
        // Entity entity = Minecraft.getInstance().getCameraEntity();

        rayTraceDistance = 500.0D;

        HitResult viewedBlock = pPlayer.pick(rayTraceDistance, 0.0F, false);
        Double x = viewedBlock.getLocation().x;
        Double y = viewedBlock.getLocation().y;
        Double z = viewedBlock.getLocation().z;

        y += 1;

        if (!pLevel.isClientSide){
            pPlayer.teleportTo(x, y, z);
        }

        pPlayer.fallDistance = 0.0f;
        rayTraceDistance = 20.0D;

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
