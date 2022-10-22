package net.Pandarix.bushierflowers.world.feature;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BushierFlowers.MOD_ID);

    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }

    public static final RegistryObject<ConfiguredFeature<?, ?>> GROWN_FLOWER_DEFAULT = CONFIGURED_FEATURES.register("grown_flower_default", () -> new ConfiguredFeature<>(Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.GROWN_POPPY.get().defaultBlockState(), 2).add(ModBlocks.GROWN_DANDELION.get().defaultBlockState(), 1)), 64)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GROWN_FLOWER_FOREST = CONFIGURED_FEATURES.register(
            "grown_flower_flower_forest", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(96,
                    6, 2,
                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(ModBlocks.GROWN_DANDELION.get().defaultBlockState(), ModBlocks.GROWN_POPPY.get().defaultBlockState(), ModBlocks.GROWN_ALLIUM.get().defaultBlockState(), ModBlocks.GROWN_AZURE_BLUET.get().defaultBlockState(), ModBlocks.GROWN_RED_TULIP.get().defaultBlockState(), ModBlocks.GROWN_ORANGE_TULIP.get().defaultBlockState(), ModBlocks.GROWN_WHITE_TULIP.get().defaultBlockState(), ModBlocks.GROWN_PINK_TULIP.get().defaultBlockState(), ModBlocks.GROWN_OXEYE_DAISY.get().defaultBlockState(), ModBlocks.GROWN_CORNFLOWER.get().defaultBlockState(), ModBlocks.GROWN_LILY.get().defaultBlockState())))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GROWN_FLOWER_SWAMP = CONFIGURED_FEATURES.register(
            "grown_flower_swamp", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(64, 6, 2,
                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GROWN_BLUE_ORCHID.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GROWN_FLOWER_PLAIN = CONFIGURED_FEATURES.register(
            "grown_flower_plain", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(64, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F, ModBlocks.GROWN_DANDELION.get().defaultBlockState(), List.of(ModBlocks.GROWN_ORANGE_TULIP.get().defaultBlockState(), ModBlocks.GROWN_RED_TULIP.get().defaultBlockState(), ModBlocks.GROWN_PINK_TULIP.get().defaultBlockState(), ModBlocks.GROWN_WHITE_TULIP.get().defaultBlockState()), List.of(ModBlocks.GROWN_POPPY.get().defaultBlockState(), ModBlocks.GROWN_AZURE_BLUET.get().defaultBlockState(), ModBlocks.GROWN_OXEYE_DAISY.get().defaultBlockState(), ModBlocks.GROWN_CORNFLOWER.get().defaultBlockState())))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GROWN_FLOWER_MEADOW = CONFIGURED_FEATURES.register(
            "grown_flower_meadow", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new DualNoiseProvider(new InclusiveRange<Integer>(1, 3), new NormalNoise.NoiseParameters(-10, 1.0D), 1.0F, 2345L, new NormalNoise.NoiseParameters(-3, 1.0D), 1.0F, List.of(Blocks.TALL_GRASS.defaultBlockState(), ModBlocks.GROWN_ALLIUM.get().defaultBlockState(), ModBlocks.GROWN_POPPY.get().defaultBlockState(), ModBlocks.GROWN_AZURE_BLUET.get().defaultBlockState(), ModBlocks.GROWN_DANDELION.get().defaultBlockState(), ModBlocks.GROWN_CORNFLOWER.get().defaultBlockState(), ModBlocks.GROWN_OXEYE_DAISY.get().defaultBlockState(), Blocks.GRASS.defaultBlockState())))))));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }

}
