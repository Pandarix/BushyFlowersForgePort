package net.Pandarix.bushierflowers.block;

import com.google.common.base.Suppliers;
import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.custom.GrowableFlower;
import net.Pandarix.bushierflowers.block.custom.GrowableWitherRose;
import net.Pandarix.bushierflowers.item.ModItemGroup;
import net.Pandarix.bushierflowers.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BushierFlowers.MOD_ID);

    //FLOWERS-----------------------------------------------------------------------------------------------------------
    public static final RegistryObject<Block> GROWN_POPPY = registerBlock("grown_poppy", () -> new GrowableFlower(MobEffects.NIGHT_VISION, 8, BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_GROWN_POPPY = BLOCKS.register("potted_grown_poppy", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_POPPY, BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> GROWN_RED_TULIP = registerBlock("grown_red_tulip", () -> new GrowableFlower(MobEffects.WEAKNESS, 12, BlockBehaviour.Properties.copy(Blocks.RED_TULIP)));
    public static final RegistryObject<Block> POTTED_GROWN_RED_TULIP = BLOCKS.register("potted_grown_red_tulip", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_RED_TULIP, BlockBehaviour.Properties.copy(Blocks.POTTED_RED_TULIP)));
    public static final RegistryObject<Block> GROWN_ORANGE_TULIP = registerBlock("grown_orange_tulip", () -> new GrowableFlower(MobEffects.WEAKNESS, 12, BlockBehaviour.Properties.copy(Blocks.ORANGE_TULIP)));
    public static final RegistryObject<Block> POTTED_GROWN_ORANGE_TULIP = BLOCKS.register("potted_grown_orange_tulip", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_ORANGE_TULIP, BlockBehaviour.Properties.copy(Blocks.POTTED_ORANGE_TULIP)));
    public static final RegistryObject<Block> GROWN_PINK_TULIP = registerBlock("grown_pink_tulip", () -> new GrowableFlower(MobEffects.WEAKNESS, 12, BlockBehaviour.Properties.copy(Blocks.PINK_TULIP)));
    public static final RegistryObject<Block> POTTED_GROWN_PINK_TULIP = BLOCKS.register("potted_grown_pink_tulip", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_PINK_TULIP, BlockBehaviour.Properties.copy(Blocks.POTTED_PINK_TULIP)));
    public static final RegistryObject<Block> GROWN_WHITE_TULIP = registerBlock("grown_white_tulip", () -> new GrowableFlower(MobEffects.WEAKNESS, 12, BlockBehaviour.Properties.copy(Blocks.WHITE_TULIP)));
    public static final RegistryObject<Block> POTTED_GROWN_WHITE_TULIP = BLOCKS.register("potted_grown_white_tulip", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_WHITE_TULIP, BlockBehaviour.Properties.copy(Blocks.POTTED_WHITE_TULIP)));
    public static final RegistryObject<Block> GROWN_AZURE_BLUET = registerBlock("grown_azure_bluet", () -> new GrowableFlower(MobEffects.BLINDNESS, 11, BlockBehaviour.Properties.copy(Blocks.AZURE_BLUET)));
    public static final RegistryObject<Block> POTTED_GROWN_AZURE_BLUET = BLOCKS.register("potted_grown_azure_bluet", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_AZURE_BLUET, BlockBehaviour.Properties.copy(Blocks.POTTED_AZURE_BLUET)));
    public static final RegistryObject<Block> GROWN_OXEYE_DAISY = registerBlock("grown_oxeye_daisy", () -> new GrowableFlower(MobEffects.REGENERATION, 11, BlockBehaviour.Properties.copy(Blocks.OXEYE_DAISY)));

    //POTTED FLOWERS----------------------------------------------------------------------------------------------------
    public static final RegistryObject<Block> POTTED_GROWN_OXEYE_DAISY = BLOCKS.register("potted_grown_oxeye_daisy", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_OXEYE_DAISY, BlockBehaviour.Properties.copy(Blocks.POTTED_OXEYE_DAISY)));
    public static final RegistryObject<Block> GROWN_BLUE_ORCHID = registerBlock("grown_blue_orchid", () -> new GrowableFlower(MobEffects.SATURATION, 1, BlockBehaviour.Properties.copy(Blocks.BLUE_ORCHID)));
    public static final RegistryObject<Block> POTTED_GROWN_BLUE_ORCHID = BLOCKS.register("potted_grown_blue_orchid", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_BLUE_ORCHID, BlockBehaviour.Properties.copy(Blocks.POTTED_BLUE_ORCHID)));
    public static final RegistryObject<Block> GROWN_CORNFLOWER = registerBlock("grown_cornflower", () -> new GrowableFlower(MobEffects.JUMP, 9, BlockBehaviour.Properties.copy(Blocks.CORNFLOWER)));
    public static final RegistryObject<Block> POTTED_GROWN_CORNFLOWER = BLOCKS.register("potted_grown_cornflower", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_CORNFLOWER, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));
    public static final RegistryObject<Block> GROWN_DANDELION = registerBlock("grown_dandelion", () -> new GrowableFlower(MobEffects.SATURATION, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_GROWN_DANDELION = BLOCKS.register("potted_grown_dandelion", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_DANDELION, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> GROWN_ALLIUM = registerBlock("grown_allium", () -> new GrowableFlower(MobEffects.FIRE_RESISTANCE, 8, BlockBehaviour.Properties.copy(Blocks.ALLIUM)));
    public static final RegistryObject<Block> POTTED_GROWN_ALLIUM = BLOCKS.register("potted_grown_allium", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_ALLIUM, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> GROWN_WITHER_ROSE = registerBlock("grown_wither_rose", () -> new GrowableWitherRose(BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static final RegistryObject<Block> POTTED_GROWN_WITHER_ROSE = BLOCKS.register("potted_grown_wither_rose", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_WITHER_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_WITHER_ROSE)));
    public static final RegistryObject<Block> GROWN_LILY = registerBlock("grown_lily", () -> new GrowableFlower(MobEffects.POISON, 15, BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_GROWN_LILY = BLOCKS.register("potted_grown_lily", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_LILY, BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> GROWN_TORCHFLOWER = registerBlock("grown_torchflower", () -> new GrowableFlower(MobEffects.FIRE_RESISTANCE, 15, BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_GROWN_TORCHFLOWER = BLOCKS.register("potted_grown_torchflower", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GROWN_TORCHFLOWER, BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final Supplier<List<Block>> grownFlowers = Suppliers.memoize(() -> List.of(ModBlocks.GROWN_POPPY.get(), ModBlocks.GROWN_RED_TULIP.get(), ModBlocks.GROWN_ORANGE_TULIP.get(), ModBlocks.GROWN_PINK_TULIP.get(), ModBlocks.GROWN_WHITE_TULIP.get(), ModBlocks.GROWN_AZURE_BLUET.get(),
            ModBlocks.GROWN_OXEYE_DAISY.get(), ModBlocks.GROWN_BLUE_ORCHID.get(), ModBlocks.GROWN_CORNFLOWER.get(), ModBlocks.GROWN_DANDELION.get(), ModBlocks.GROWN_ALLIUM.get(), ModBlocks.GROWN_WITHER_ROSE.get(), ModBlocks.GROWN_LILY.get(), ModBlocks.GROWN_TORCHFLOWER.get()));
    public static final List<Block> validFlowers = Arrays.asList(Blocks.POPPY, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.PINK_TULIP, Blocks.WHITE_TULIP, Blocks.AZURE_BLUET, Blocks.OXEYE_DAISY, Blocks.BLUE_ORCHID, Blocks.CORNFLOWER, Blocks.DANDELION, Blocks.ALLIUM, Blocks.WITHER_ROSE,
            Blocks.LILY_OF_THE_VALLEY, Blocks.TORCHFLOWER);


    //REGISTRY----------------------------------------------------------------------------------------------------------

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
