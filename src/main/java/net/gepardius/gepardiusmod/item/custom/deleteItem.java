package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;


public class deleteItem extends Item {
    public deleteItem(Properties pProperties) {

        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        Direction playerDirection = pContext.getPlayer().getDirection();
        System.out.println(playerDirection);

        int dirX = playerDirection.getStepX();
        int dirZ = playerDirection.getStepZ();
        // whichDirection(dirX, dirZ);

        int nOfBlocks = 15;

        BlockPos positionClicked = pContext.getClickedPos();
        double x = positionClicked.getX();
        double y = positionClicked.getY();
        double z = positionClicked.getZ();
        y += 1;

        if (!level.isClientSide){

            BlockPos blockToRemove = new BlockPos(x, y, z);
            level.setBlock(blockToRemove, Blocks.AIR.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocks; side++){
                for(int ahead = 0; ahead < nOfBlocks; ahead++){
                    for(int up = 0; up < nOfBlocks; up++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.AIR.defaultBlockState(), 1);

                        if(dirX == 0 && dirZ == -1){ // NORTH
                            z -= 1;
                        } else if (dirX == 0 && dirZ == 1) { // SOUTH
                            z += 1;
                        } else if (dirX == 1 && dirZ == 0) { // WEST
                            x += 1;
                        } else if (dirX == -1 && dirZ == 0) { // EAST
                            x -= 1;
                        }
                    }
                    if(dirX == 0){
                        z = positionClicked.getZ();
                    } else {
                        x = positionClicked.getX();
                    }
                    y += 1;
                }
            }
            return super.useOn(pContext);
        } else {

            BlockPos blockToRemove = new BlockPos(x, y, z);
            level.setBlock(blockToRemove, Blocks.AIR.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocks; side++){
                for(int ahead = 0; ahead < nOfBlocks; ahead++){
                    for(int up = 0; up < nOfBlocks; up++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.AIR.defaultBlockState(), 1);

                        if(dirX == 0 && dirZ == -1){ // NORTH
                            z -= 1;
                        } else if (dirX == 0 && dirZ == 1) { // SOUTH
                            z += 1;
                        } else if (dirX == 1 && dirZ == 0) { // WEST
                            x += 1;
                        } else if (dirX == -1 && dirZ == 0) { // EAST
                            x -= 1;
                        }
                    }
                    if(dirX == 0){
                        z = positionClicked.getZ();
                    } else {
                        x = positionClicked.getX();
                    }
                    y += 1;
                }
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
