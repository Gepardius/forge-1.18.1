package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;

import static net.minecraftforge.client.gui.ForgeIngameGui.rayTraceDistance;


public class stoneItem extends Item {
    public stoneItem(Properties pProperties) {

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

        int nOfBlocksUp = 5;
        int nOfBlocksAhead = 2;
        int nOfBlocksSide =5;

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
            level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocksSide; side++){
                for(int up = 0; up < nOfBlocksUp; up++){
                    for(int ahead = 0; ahead < nOfBlocksAhead; ahead++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

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
            level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocksSide; side++){
                for(int up = 0; up < nOfBlocksUp; up++){
                    for(int ahead = 0; ahead < nOfBlocksAhead; ahead++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

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

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {

        // entity.pick(rayTraceDistance, 0.0F, false);
        Entity entity = Minecraft.getInstance().getCameraEntity();
        HitResult viewedBlock = entity.pick(rayTraceDistance, 0.0F, false);
        Double x = viewedBlock.getLocation().x;
        Double y = viewedBlock.getLocation().y;
        Double z = viewedBlock.getLocation().z;

        // y += 1;

        Direction playerDirection = player.getDirection();
        //System.out.println(playerDirection);

        int dirX = playerDirection.getStepX();
        int dirZ = playerDirection.getStepZ();

        int nOfBlocksUp = 3;
        int nOfBlocksAhead = 3;
        int nOfBlocksSide = 3;

        if (dirX == 0 && dirZ == -1) { // NORTH
            x += (nOfBlocksSide / 2);
        } else if (dirX == 0 && dirZ == 1) { // SOUTH
            x -= (nOfBlocksSide / 2);
        } else if (dirX == 1 && dirZ == 0) { // WEST
            z -= (nOfBlocksSide / 2);
        } else if (dirX == -1 && dirZ == 0) { // EAST
            z += (nOfBlocksSide / 2);
        }

        if (!level.isClientSide) {

            BlockPos blockToRemove = new BlockPos(x, y, z);
            level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocksSide; side++) {
                for (int up = 0; up < nOfBlocksUp; up++) {
                    for (int ahead = 0; ahead < nOfBlocksAhead; ahead++) {
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

                        if (dirX == 0 && dirZ == -1) { // NORTH
                            z -= 1;
                        } else if (dirX == 0 && dirZ == 1) { // SOUTH
                            z += 1;
                        } else if (dirX == 1 && dirZ == 0) { // WEST
                            x += 1;
                        } else if (dirX == -1 && dirZ == 0) { // EAST
                            x -= 1;
                        }
                    }
                    if (dirX == 0) {
                        z = viewedBlock.getLocation().z;
                    } else {
                        x = viewedBlock.getLocation().x;
                    }
                    y += 1;
                }
                y = viewedBlock.getLocation().y;
                // y += 1;

                if (dirX == 0 && dirZ == -1) { // NORTH
                    x -= 1;
                } else if (dirX == 0 && dirZ == 1) { // SOUTH
                    x += 1;
                } else if (dirX == 1 && dirZ == 0) { // WEST
                    z += 1;
                } else if (dirX == -1 && dirZ == 0) { // EAST
                    z -= 1;
                }

            }
            return super.use(level, player, pUsedHand);
        } else {

            BlockPos blockToRemove = new BlockPos(x, y, z);
            level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

            for (int side = 0; side < nOfBlocksSide; side++) {
                for (int up = 0; up < nOfBlocksUp; up++) {
                    for (int ahead = 0; ahead < nOfBlocksAhead; ahead++) {
                        blockToRemove = new BlockPos(x, y, z);
                        level.setBlock(blockToRemove, Blocks.STONE.defaultBlockState(), 1);

                        if (dirX == 0 && dirZ == -1) { // NORTH
                            z -= 1;
                        } else if (dirX == 0 && dirZ == 1) { // SOUTH
                            z += 1;
                        } else if (dirX == 1 && dirZ == 0) { // WEST
                            x += 1;
                        } else if (dirX == -1 && dirZ == 0) { // EAST
                            x -= 1;
                        }
                    }
                    if (dirX == 0) {
                        z = viewedBlock.getLocation().z;
                    } else {
                        x = viewedBlock.getLocation().x;
                    }
                    y += 1;
                }
                y = viewedBlock.getLocation().y;
                // y += 1;

                if (dirX == 0 && dirZ == -1) { // NORTH
                    x -= 1;
                } else if (dirX == 0 && dirZ == 1) { // SOUTH
                    x += 1;
                } else if (dirX == 1 && dirZ == 0) { // WEST
                    z += 1;
                } else if (dirX == -1 && dirZ == 0) { // EAST
                    z -= 1;
                }

            }
            return super.use(level, player, pUsedHand);
        }
    }
}
