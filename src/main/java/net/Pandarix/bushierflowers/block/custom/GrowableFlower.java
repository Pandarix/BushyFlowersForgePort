package net.Pandarix.bushierflowers.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GrowableFlower extends FlowerBlock {
    /*
    This is the base class of all Growable Flowers in this Mod. This ensures that the Block behaves correctly.
     */

    public GrowableFlower(MobEffect suspiciousStewEffect, int effectDuration, Properties properties) {
        super(suspiciousStewEffect, effectDuration, properties);
    }

    //---------------------------Block Shape stuff---------------------------

    //The blocks outline shape
    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 10, 13);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
