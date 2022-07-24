package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;


public class lavaItem extends Item {
    public lavaItem(Properties pProperties) {

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

        int nOfBlocksUp = 3;
        int nOfBlocksAhead = 3;
        int nOfBlocksSide = 3;

        BlockPos positionClicked = pContext.getClickedPos();
        double x = positionClicked.getX();
        double y = positionClicked.getY();
        double z = positionClicked.getZ();
        y += 1;

        if(dirX == 0 && dirZ == -1){ // NORTH
            x += (nOfBlocksSide/2);
        } else if (dirX == 0 && dirZ == 1) { // SOUTH
            x -= (nOfBlocksSide/2);
        } else if (dirX == 1 && dirZ == 0) { // WEST
            z -= (nOfBlocksSide/2);
        } else if (dirX == -1 && dirZ == 0) { // EAST
            z += (nOfBlocksSide/2);
        }

        if (!level.isClientSide){

            BlockPos blockToRemove = new BlockPos(x, y, z);
            level.setBlock(blockToRemove, Blocks.LAVA.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocksSide; side++){
                for(int up = 0; up < nOfBlocksUp; up++){
                    for(int ahead = 0; ahead < nOfBlocksAhead; ahead++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.LAVA.defaultBlockState(), 1);

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
                y = positionClicked.getY();
                y += 1;

                if(dirX == 0 && dirZ == -1){ // NORTH
                    x -= 1;
                } else if (dirX == 0 && dirZ == 1) { // SOUTH
                    x += 1;
                } else if (dirX == 1 && dirZ == 0) { // WEST
                    z += 1;
                } else if (dirX == -1 && dirZ == 0) { // EAST
                    z -= 1;
                }

            }
            return super.useOn(pContext);
        } else {

            BlockPos blockToRemove = new BlockPos(x, y, z);
            level.setBlock(blockToRemove, Blocks.LAVA.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocksSide; side++){
                for(int up = 0; up < nOfBlocksUp; up++){
                    for(int ahead = 0; ahead < nOfBlocksAhead; ahead++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.LAVA.defaultBlockState(), 1);

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
                y = positionClicked.getY();
                y += 1;

                if(dirX == 0 && dirZ == -1){ // NORTH
                    x -= 1;
                } else if (dirX == 0 && dirZ == 1) { // SOUTH
                    x += 1;
                } else if (dirX == 1 && dirZ == 0) { // WEST
                    z += 1;
                } else if (dirX == -1 && dirZ == 0) { // EAST
                    z -= 1;
                }

            }
            return super.useOn(pContext);
        }
    }
}
