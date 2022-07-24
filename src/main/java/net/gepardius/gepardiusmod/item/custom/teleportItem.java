package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TargetBlock;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.ProjectileImpactEvent;


public class teleportItem extends Item {
    public teleportItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();

        BlockPos positionClicked = pContext.getClickedPos();
        double x = positionClicked.getX();
        double y = positionClicked.getY();
        double z = positionClicked.getZ();

        y += 1;

        if (!level.isClientSide){
            player.teleportTo(x, y, z);
        }
        return super.useOn(pContext);
    }
}
