package net.Pandarix.bushierflowers.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WitherRoseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GrowableWitherRose extends WitherRoseBlock {
    //---------------------------Block Shape stuff---------------------------
    //The blocks outline shape
    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 10, 13);

    public GrowableWitherRose(BlockBehaviour.Properties settings) {
        super(MobEffects.WITHER, settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}