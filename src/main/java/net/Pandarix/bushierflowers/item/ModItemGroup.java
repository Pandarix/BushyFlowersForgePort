package net.Pandarix.bushierflowers.item;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModItemGroup {
    // Registered on the MOD event bus
    public static void buildContents(CreativeModeTabEvent.Register event) {
        BushierFlowers.LOGGER.info(BushierFlowers.MOD_ID + " CreativeModeTab registered");

        event.registerCreativeModeTab(new ResourceLocation(BushierFlowers.MOD_ID, "bushier_flowers"), builder ->
                // Set name of tab to display
                builder.title(Component.translatable("item_group." + BushierFlowers.MOD_ID))
                        // Set icon of creative tab
                        .icon(() -> new ItemStack(ModBlocks.GROWN_ALLIUM.get()))
                        // Add default items to tab
                        .displayItems((params, output) -> {
                            output.accept(ModBlocks.GROWN_ALLIUM.get());
                            output.accept(ModBlocks.GROWN_AZURE_BLUET.get());
                            output.accept(ModBlocks.GROWN_BLUE_ORCHID.get());
                            output.accept(ModBlocks.GROWN_CORNFLOWER.get());
                            output.accept(ModBlocks.GROWN_LILY.get());
                            output.accept(ModBlocks.GROWN_DANDELION.get());
                            output.accept(ModBlocks.GROWN_ORANGE_TULIP.get());
                            output.accept(ModBlocks.GROWN_PINK_TULIP.get());
                            output.accept(ModBlocks.GROWN_RED_TULIP.get());
                            output.accept(ModBlocks.GROWN_WHITE_TULIP.get());
                            output.accept(ModBlocks.GROWN_OXEYE_DAISY.get());
                            output.accept(ModBlocks.GROWN_POPPY.get());
                            output.accept(ModBlocks.GROWN_WITHER_ROSE.get());
                        })
        );
    }
}
