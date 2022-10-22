package net.Pandarix.bushierflowers.mixin;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public abstract class ModFlowerGrowHelper {
    
    //injecting this method into the Bonemeal Blockinteraction
    @Inject(method = "useOn", at = @At("HEAD"))
    protected void injectWriteMethod(@NotNull UseOnContext context, CallbackInfoReturnable info) {
        Level bushyflowers$level = context.getLevel();
        BlockPos bushyflowers$blockPos = context.getClickedPos();
        Block bushyflowers$testedBlock = bushyflowers$level.getBlockState(bushyflowers$blockPos).getBlock();
        //testing if the clicked Block is a Block our mod will want to replace
        if (ModBlocks.validFlowers.contains(bushyflowers$testedBlock)) {
            BushierFlowers.LOGGER.info("Mixin loaded");
            //only execute if we are on Server Level to prevent syncing issues
            if (!bushyflowers$level.isClientSide()) {
                //getting the grown flower block that corresponds to the flower in question
                Block bushyflowers$correspondingFlower = ModBlocks.grownFlowers.get().get(ModBlocks.validFlowers.indexOf(bushyflowers$testedBlock));
                //replacing the Vanilla flower with our custom Mod variant
                bushyflowers$level.setBlock(bushyflowers$blockPos, bushyflowers$correspondingFlower.defaultBlockState(), 3);
                //additional Sounds and Particles
                bushyflowers$level.playSound(null, (double) bushyflowers$blockPos.getX() + 0.5, (double) bushyflowers$blockPos.getY() + 0.5, (double) bushyflowers$blockPos.getZ() + 0.5, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                context.getItemInHand().shrink(1);
            }
            //particles
            BoneMealItem.addGrowthParticles(bushyflowers$level, bushyflowers$blockPos, 15);
        }

        //testing if the clicked Block is a Block of our mod
        if (ModBlocks.grownFlowers.get().contains(bushyflowers$testedBlock)) {
            BushierFlowers.LOGGER.info("Mixin loaded");
            //only execute if we are on Server Level to prevent syncing issues
            if (!bushyflowers$level.isClientSide()) {
                //getting the vanilla flower block that corresponds to the grown flower in question
                Block bushyflowers$correspondingFlower = ModBlocks.validFlowers.get(ModBlocks.grownFlowers.get().indexOf(bushyflowers$testedBlock));

                //spawning the item
                Block.popResource(bushyflowers$level, bushyflowers$blockPos, new ItemStack(bushyflowers$correspondingFlower));

                //additional Sounds and Particles
                bushyflowers$level.playSound(null, (double) bushyflowers$blockPos.getX() + 0.5, (double) bushyflowers$blockPos.getY() + 0.5, (double) bushyflowers$blockPos.getZ() + 0.5, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                context.getItemInHand().shrink(1);
            }
            //particles
            BoneMealItem.addGrowthParticles(bushyflowers$level, bushyflowers$blockPos,15);
        }

        BushierFlowers.LOGGER.info("Mixin loaded");

    }
}
