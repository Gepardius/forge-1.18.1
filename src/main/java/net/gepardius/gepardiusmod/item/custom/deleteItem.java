package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeConfig;

import java.util.List;

import static java.lang.Math.abs;
import static net.gepardius.gepardiusmod.item.custom.ability.abilityFarUse;
import static net.gepardius.gepardiusmod.item.custom.ability.abilityUse;
import static net.minecraftforge.client.gui.ForgeIngameGui.rayTraceDistance;


public class deleteItem extends Item {
    public deleteItem(Properties pProperties) {

        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        abilityUse(pContext, 50, 50, 50, 100.0F, DamageSource.FLY_INTO_WALL, Blocks.AIR.defaultBlockState());

        return super.useOn(pContext);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {

        if (player instanceof ServerPlayer serverPlayer) {
            abilityFarUse(level, player, pUsedHand, 3, 3, 3, 50.0F, DamageSource.FLY_INTO_WALL, Blocks.AIR.defaultBlockState());
        } else {
            abilityFarUse(level, player, pUsedHand, 3, 3, 3, 50.0F, DamageSource.FLY_INTO_WALL, Blocks.AIR.defaultBlockState());
        }

        return super.use(level, player, pUsedHand);
    }
}
