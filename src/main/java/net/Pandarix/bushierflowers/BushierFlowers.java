package net.Pandarix.bushierflowers;

import com.mojang.logging.LogUtils;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.Pandarix.bushierflowers.item.ModItems;
import net.Pandarix.bushierflowers.util.ModDispenserBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BushierFlowers.MOD_ID)
public class BushierFlowers {
    public static final String MOD_ID = "bushierflowers";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BushierFlowers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDispenserBehaviour.registerDispenserBehaviour();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Bushier Flowers set up");
        event.enqueueWork(()-> {
            addPlants();
        });
    }

    private static void addPlants(){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_POPPY.getId(), ModBlocks.POTTED_GROWN_POPPY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_LILY.getId(), ModBlocks.POTTED_GROWN_LILY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_ALLIUM.getId(), ModBlocks.POTTED_GROWN_ALLIUM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_WITHER_ROSE.getId(), ModBlocks.POTTED_GROWN_WITHER_ROSE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_DANDELION.getId(), ModBlocks.POTTED_GROWN_DANDELION);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_CORNFLOWER.getId(), ModBlocks.POTTED_GROWN_CORNFLOWER);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_OXEYE_DAISY.getId(), ModBlocks.POTTED_GROWN_OXEYE_DAISY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_BLUE_ORCHID.getId(), ModBlocks.POTTED_GROWN_BLUE_ORCHID);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_AZURE_BLUET.getId(), ModBlocks.POTTED_GROWN_AZURE_BLUET);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_PINK_TULIP.getId(), ModBlocks.POTTED_GROWN_PINK_TULIP);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_RED_TULIP.getId(), ModBlocks.POTTED_GROWN_RED_TULIP);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_WHITE_TULIP.getId(), ModBlocks.POTTED_GROWN_WHITE_TULIP);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROWN_ORANGE_TULIP.getId(), ModBlocks.POTTED_GROWN_ORANGE_TULIP);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Bushier Flowers Client Setup set up");
            BushierFlowersClient.clientSetup(event);
        }
    }

}
