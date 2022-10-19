package net.Pandarix.bushierflowers.util;

import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
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
                Level level = source.getLevel();
                BlockPos blockPos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                Block block = level.getBlockState(blockPos).getBlock();

                //behaviour for when it bonemeals a vanilla flower---------------------------------------------------------------------------------
                if (ModBlocks.validFlowers.contains(block) && !level.isClientSide) {
                    this.setSuccess(true);
                    //getting the corresponding grown flower for the targeted vanilla one
                    Block bushyflowers$correspondingFlower = ModBlocks.grownFlowers.get().get(ModBlocks.validFlowers.indexOf(block));
                    //replacing the block
                    level.setBlock(blockPos, bushyflowers$correspondingFlower.defaultBlockState(), 3);
                    //sounds
                    level.playSound(null, (double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    //consuming one bonemeal
                    stack.shrink(1);
                }
                //behaviour for when it bonemeals a modded flower----------------------------------------------------------------------------------
                else if (ModBlocks.grownFlowers.get().contains(level.getBlockState(blockPos).getBlock()) && !level.isClientSide) {
                    this.setSuccess(true);
                    //getting the corresponding vanilla flower for the targeted modded one
                    Block bushyflowers$correspondingFlower = ModBlocks.validFlowers.get(ModBlocks.grownFlowers.get().indexOf(block));

                    //spawning the item
                    Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                    EntityType<?> entitytype = EntityType.ITEM;
                    ItemStack item = bushyflowers$correspondingFlower.asItem().getDefaultInstance();
                    try {
                        entitytype.spawn(level.getServer().overworld(), item, (Player) null, source.getPos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
                    } catch (Exception exception) {
                        LOGGER.error("Error while dispensing flower from dispenser at {}", source.getPos(), exception);
                        return ItemStack.EMPTY;
                    }

                    stack.shrink(1);
                    source.getLevel().gameEvent((Entity) null, GameEvent.ENTITY_PLACE, source.getPos());

                    //sounds
                    level.playSound(null, (double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    //consuming one bonemeal
                    stack.shrink(1);
                }

                //standard Vanilla behaviour-------------------------------------------------------------------------------------------------------
                if (!BoneMealItem.growCrop(stack, level, blockPos) && !BoneMealItem.growWaterPlant(stack, level, blockPos, (Direction) null)) {
                    this.setSuccess(false);
                } else if (!level.isClientSide) {
                    level.levelEvent(1505, blockPos, 0);
                    this.setSuccess(true);
                }

                //added particles------------------------------------------------------------------------------------------------------------------
                if (this.isSuccess() && level.isClientSide()) {
                    BoneMealItem.addGrowthParticles(level, blockPos, 15);
                }

                return stack;
            }
        });
    }
}
