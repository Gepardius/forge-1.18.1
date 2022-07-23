package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;


public class waterItem extends Item {
    public waterItem(Properties pProperties) {

        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        Direction playerDirection = pContext.getPlayer().getDirection();
        System.out.println(playerDirection);

        int dirX = playerDirection.getStepX();
        int dirZ = playerDirection.getStepZ();
        whichDirection(dirX, dirZ);

        int nOfBlocks = 15;

        if (!level.isClientSide){
            BlockPos positionClicked = pContext.getClickedPos();

            double x_pos = positionClicked.getX();
            double y_pos = positionClicked.getY();
            double z_pos = positionClicked.getZ();

            double x = positionClicked.getX();
            double y = positionClicked.getY();
            double z = positionClicked.getZ();

            BlockPos blockToRemove = new BlockPos(x, y, z);
            for(int i = 0; i < nOfBlocks; i++) {
                for(int ii = 0; ii < nOfBlocks; ii++){
                    for(int iii = 0; iii < nOfBlocks; iii++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.WATER.defaultBlockState(), 1);
                        // level.removeBlock(blockToRemove, true);
                        z += 1;
                        }
                    z = z_pos;
                    y += 1;
                    }
                y = y_pos;
                x += 1;
            }
            return super.useOn(pContext);

        } else {

            BlockPos positionClicked = pContext.getClickedPos();

            double x_pos = positionClicked.getX();
            double y_pos = positionClicked.getY();
            double z_pos = positionClicked.getZ();

            double x = positionClicked.getX();
            double y = positionClicked.getY();
            double z = positionClicked.getZ();

            BlockPos blockToRemove = new BlockPos(x, y, z);
            for(int i = 0; i < nOfBlocks; i++) {
                for(int ii = 0; ii < nOfBlocks; ii++){
                    for(int iii = 0; iii < nOfBlocks; iii++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.WATER.defaultBlockState(), 1);
                        // level.removeBlock(blockToRemove, true);
                        z += 1;
                    }
                    z = z_pos;
                    x += 1;
                }
                x = x_pos;
                y += 1;
            }
            return super.useOn(pContext);
        }
    }
    public void whichDirection(int directionX, int directionZ){
        if (directionX == 0 && directionZ == -1){
            System.out.println("NORTH");
        } else if (directionX == 0 && directionZ == 1) {
            System.out.println("SOUTH");
        } else if (directionX == 1 && directionZ == 0) {
            System.out.println("EAST");
        } else if (directionX == -1 && directionZ == 0) {
            System.out.println("WEST");
        }
    }
}
