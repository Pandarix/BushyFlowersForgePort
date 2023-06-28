package net.Pandarix.bushierflowers.item;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModItemGroup {
    //TODO move items & blocks here

    // Registered on the MOD event bus
    // Assume we have RegistryObject<Item> and RegistryObject<Block> called ITEM and BLOCK
    @SubscribeEvent
    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(BushierFlowers.MOD_ID, "bushier_flowers"), builder ->
                // Set name of tab to display
                builder.title(Component.translatable("item_group." + BushierFlowers.MOD_ID))
                        // Set icon of creative tab
                        .icon(() -> new ItemStack(ModBlocks.GROWN_ALLIUM.get()))
                        // Add default items to tab
                        .displayItems((enabledFlags, populator) -> {
                            populator.accept(ModBlocks.GROWN_ALLIUM.get());
                            populator.accept(ModBlocks.GROWN_AZURE_BLUET.get());
                            populator.accept(ModBlocks.GROWN_BLUE_ORCHID.get());
                            populator.accept(ModBlocks.GROWN_CORNFLOWER.get());
                            populator.accept(ModBlocks.GROWN_LILY.get());
                            populator.accept(ModBlocks.GROWN_DANDELION.get());
                            populator.accept(ModBlocks.GROWN_ORANGE_TULIP.get());
                            populator.accept(ModBlocks.GROWN_PINK_TULIP.get());
                            populator.accept(ModBlocks.GROWN_RED_TULIP.get());
                            populator.accept(ModBlocks.GROWN_WHITE_TULIP.get());
                            populator.accept(ModBlocks.GROWN_OXEYE_DAISY.get());
                            populator.accept(ModBlocks.GROWN_POPPY.get());
                            populator.accept(ModBlocks.GROWN_WITHER_ROSE.get());
                        })
        );
    }
}
