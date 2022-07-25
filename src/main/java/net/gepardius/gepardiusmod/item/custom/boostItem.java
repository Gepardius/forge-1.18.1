package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class boostItem extends Item {
    public boostItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if (!pLevel.isClientSide()){
            pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 5));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 5));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 5));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10000, 5));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP, 1000, 10));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1000, 5));
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
