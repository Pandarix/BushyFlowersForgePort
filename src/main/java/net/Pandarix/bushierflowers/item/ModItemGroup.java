package net.Pandarix.bushierflowers.item;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BushierFlowers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemGroup {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BushierFlowers.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BUSHIERFLOWERS_TAB = TABS.register("bushierflowers_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.bushierflowers_tab"))
                    .icon(ModBlocks.GROWN_ALLIUM.get().asItem()::getDefaultInstance)
                    .build()
    );

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == BUSHIERFLOWERS_TAB.get()) {
            event.accept(ModBlocks.GROWN_ALLIUM.get());
            event.accept(ModBlocks.GROWN_AZURE_BLUET.get());
            event.accept(ModBlocks.GROWN_BLUE_ORCHID.get());
            event.accept(ModBlocks.GROWN_CORNFLOWER.get());
            event.accept(ModBlocks.GROWN_LILY.get());
            event.accept(ModBlocks.GROWN_DANDELION.get());
            event.accept(ModBlocks.GROWN_ORANGE_TULIP.get());
            event.accept(ModBlocks.GROWN_PINK_TULIP.get());
            event.accept(ModBlocks.GROWN_RED_TULIP.get());
            event.accept(ModBlocks.GROWN_WHITE_TULIP.get());
            event.accept(ModBlocks.GROWN_OXEYE_DAISY.get());
            event.accept(ModBlocks.GROWN_POPPY.get());
            event.accept(ModBlocks.GROWN_WITHER_ROSE.get());
            event.accept(ModBlocks.GROWN_TORCHFLOWER.get());
        }
    }
}
