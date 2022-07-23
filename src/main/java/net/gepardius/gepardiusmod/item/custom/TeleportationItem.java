package net.gepardius.gepardiusmod.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class TeleportationItem extends Item {
    public TeleportationItem(Properties pProperties) {

        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        int nOfBlocks = 5;
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
                        level.removeBlock(blockToRemove, true);
                        z += 1;
                        }
                    z = z_pos;
                    y += 1;
                    }
                y = y_pos;
                x += 1;
            }

            x = positionClicked.getX();
            y = positionClicked.getY();
            z = positionClicked.getZ();

            blockToRemove = new BlockPos(x, y, z);
            for(int i = 0; i < nOfBlocks; i++) {
                for(int ii = 0; ii < nOfBlocks; ii++){
                    for(int iii = 0; iii < nOfBlocks; iii++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.removeBlock(blockToRemove, true);
                        z -= 1;
                    }
                    z = z_pos;
                    x -= 1;
                }
                x = x_pos;
                y += 1;
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
                        level.removeBlock(blockToRemove, true);
                        z += 1;
                    }
                    z = z_pos;
                    x += 1;
                }
                x = x_pos;
                y += 1;
            }

            x = positionClicked.getX();
            y = positionClicked.getY();
            z = positionClicked.getZ();

            blockToRemove = new BlockPos(x, y, z);
            for(int i = 0; i < nOfBlocks; i++) {
                for(int ii = 0; ii < nOfBlocks; ii++){
                    for(int iii = 0; iii < nOfBlocks; iii++){
                        blockToRemove = new BlockPos(x, y, z);
                        level.removeBlock(blockToRemove, true);
                        z -= 1;
                        }
                    z = z_pos;
                    x -= 1;
                    }
                x = x_pos;
                y += 1;
            }
            return super.useOn(pContext);
        }
    }
}
