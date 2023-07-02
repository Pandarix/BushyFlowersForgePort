package net.Pandarix.bushierflowers;

import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BushierFlowers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BushierFlowersClient {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        //FLOWERS-------------------------------------------------------------------------------------------------------
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_POPPY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_RED_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_ORANGE_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_PINK_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_WHITE_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_AZURE_BLUET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_OXEYE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_BLUE_ORCHID.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_CORNFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_DANDELION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_ALLIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_WITHER_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWN_TORCHFLOWER.get(), RenderType.cutout());
        //POTTED FLOWERS------------------------------------------------------------------------------------------------
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_POPPY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_RED_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_ORANGE_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_PINK_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_WHITE_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_AZURE_BLUET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_OXEYE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_BLUE_ORCHID.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_CORNFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_DANDELION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_ALLIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_WITHER_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_GROWN_TORCHFLOWER.get(), RenderType.cutout());
    }
}
