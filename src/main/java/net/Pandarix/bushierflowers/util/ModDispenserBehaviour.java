package net.Pandarix.bushierflowers.util;

import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModDispenserBehaviour {
    public static void registerDispenserBehaviour() {
        DispenserBlock.registerBehavior(Items.BONE_MEAL, new OptionalDispenseItemBehavior() {
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                //help variables
                this.setSuccess(true);
                Level bushyflowers$level = source.getLevel();
                BlockPos bushyflowers$blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                Block bushyflowers$block = bushyflowers$level.getBlockState(bushyflowers$blockpos).getBlock();

                //behaviour for when it bonemeals a vanilla flower---------------------------------------------------------------------------------
                if (ModBlocks.validFlowers.contains(bushyflowers$block) && !bushyflowers$level.isClientSide) {
                    this.setSuccess(true);
                    //getting the corresponding grown flower for the targeted vanilla one
                    Block bushyflowers$correspondingFlower = ModBlocks.grownFlowers.get().get(ModBlocks.validFlowers.indexOf(bushyflowers$block));
                    //replacing the bushyflowers$block
                    bushyflowers$level.setBlock(bushyflowers$blockpos, bushyflowers$correspondingFlower.defaultBlockState(), 3);
                    //sounds
                    bushyflowers$level.playSound(null, (double) bushyflowers$blockpos.getX() + 0.5, (double) bushyflowers$blockpos.getY() + 0.5, (double) bushyflowers$blockpos.getZ() + 0.5, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    //consuming one bonemeal
                    stack.shrink(1);
                }
                //behaviour for when it bonemeals a modded flower----------------------------------------------------------------------------------
                else if (ModBlocks.grownFlowers.get().contains(bushyflowers$level.getBlockState(bushyflowers$blockpos).getBlock()) && !bushyflowers$level.isClientSide) {
                    this.setSuccess(true);
                    //getting the corresponding vanilla flower for the targeted modded one
                    Block bushyflowers$correspondingFlower = ModBlocks.validFlowers.get(ModBlocks.grownFlowers.get().indexOf(bushyflowers$block));
                    
                    //spawning the item
                    Block.popResource(bushyflowers$level, bushyflowers$blockpos, new ItemStack(bushyflowers$correspondingFlower));


                    stack.shrink(1);
                    source.getLevel().gameEvent((Entity) null, GameEvent.ENTITY_PLACE, source.getPos());

                    //sounds
                    bushyflowers$level.playSound(null, (double) bushyflowers$blockpos.getX() + 0.5, (double) bushyflowers$blockpos.getY() + 0.5, (double) bushyflowers$blockpos.getZ() + 0.5, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    //consuming one bonemeal
                    stack.shrink(1);
                }

                //standard Vanilla behaviour-------------------------------------------------------------------------------------------------------
                if (!BoneMealItem.growCrop(stack, bushyflowers$level, bushyflowers$blockpos) && !BoneMealItem.growWaterPlant(stack, bushyflowers$level, bushyflowers$blockpos, (Direction) null)) {
                    this.setSuccess(false);
                } else if (!bushyflowers$level.isClientSide) {
                    bushyflowers$level.levelEvent(1505, bushyflowers$blockpos, 0);
                    this.setSuccess(true);
                }

                //added particles------------------------------------------------------------------------------------------------------------------
                if (this.isSuccess() && bushyflowers$level.isClientSide()) {
                    BoneMealItem.addGrowthParticles(bushyflowers$level, bushyflowers$blockpos, 15);
                }

                return stack;
            }
        });
    }
}
