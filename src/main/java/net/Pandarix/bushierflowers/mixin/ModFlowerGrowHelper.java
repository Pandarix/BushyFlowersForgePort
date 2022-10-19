package net.Pandarix.bushierflowers.mixin;

import com.google.common.base.Suppliers;
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
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Mixin(BoneMealItem.class)
public abstract class ModFlowerGrowHelper {

    private static final Supplier<List<Block>> grownFlowers = Suppliers.memoize(() -> List.of(ModBlocks.GROWN_POPPY.get(), ModBlocks.GROWN_RED_TULIP.get(), ModBlocks.GROWN_ORANGE_TULIP.get(), ModBlocks.GROWN_PINK_TULIP.get(), ModBlocks.GROWN_WHITE_TULIP.get(), ModBlocks.GROWN_AZURE_BLUET.get(), ModBlocks.GROWN_OXEYE_DAISY.get(), ModBlocks.GROWN_BLUE_ORCHID.get(), ModBlocks.GROWN_CORNFLOWER.get(), ModBlocks.GROWN_DANDELION.get(), ModBlocks.GROWN_ALLIUM.get(), ModBlocks.GROWN_WITHER_ROSE.get(), ModBlocks.GROWN_LILY.get()));
    private final List<Block> validFlowers = Arrays.asList(Blocks.POPPY, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.PINK_TULIP, Blocks.WHITE_TULIP, Blocks.AZURE_BLUET, Blocks.OXEYE_DAISY, Blocks.BLUE_ORCHID, Blocks.CORNFLOWER, Blocks.DANDELION, Blocks.ALLIUM, Blocks.WITHER_ROSE, Blocks.LILY_OF_THE_VALLEY);

    //injecting this method into the Bonemeal Blockinteraction
    @Inject(method = "useOn", at = @At("HEAD"))
    protected void injectWriteMethod(UseOnContext context, CallbackInfoReturnable info) {
        Level bushyflowers$level = context.getLevel();
        BlockPos bushyflowers$blockPos = context.getClickedPos();
        Block bushyflowers$testedBlock = bushyflowers$level.getBlockState(bushyflowers$blockPos).getBlock();
        //testing if the clicked Block is a Block our mod will want to replace
        if (validFlowers.contains(bushyflowers$testedBlock)) {
            BushierFlowers.LOGGER.info("Mixin loaded");
            //only execute if we are on Server Level to prevent syncing issues
            if (!bushyflowers$level.isClientSide()) {
                //getting the grown flower block that corresponds to the flower in question
                Block bushyflowers$correspondingFlower = grownFlowers.get().get(validFlowers.indexOf(bushyflowers$testedBlock));
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
        if (grownFlowers.get().contains(bushyflowers$testedBlock)) {
            BushierFlowers.LOGGER.info("Mixin loaded");
            //only execute if we are on Server Level to prevent syncing issues
            if (!bushyflowers$level.isClientSide()) {
                //getting the vanilla flower block that corresponds to the grown flower in question
                Block bushyflowers$correspondingFlower = validFlowers.get(grownFlowers.get().indexOf(bushyflowers$testedBlock));

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
