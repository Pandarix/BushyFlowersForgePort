package net.Pandarix.bushierflowers.world.feature;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BushierFlowers.MOD_ID);

    public static final RegistryObject<PlacedFeature> GROWN_FLOWER_DEFAULT_PLACED = PLACED_FEATURES.register("grown_flower_default_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GROWN_FLOWER_DEFAULT.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(24),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> GROWN_FLOWER_FOREST_PLACED = PLACED_FEATURES.register(
            "grown_flower_flower_forest_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GROWN_FLOWER_FOREST.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(24),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> GROWN_FLOWER_SWAMP_PLACED = PLACED_FEATURES.register(
            "grown_flower_swamp_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GROWN_FLOWER_SWAMP.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(24),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> GROWN_FLOWER_PLAIN_PLACED = PLACED_FEATURES.register(
            "grown_flower_plain_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GROWN_FLOWER_PLAIN.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(24),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()))
    );

    public static final RegistryObject<PlacedFeature> GROWN_FLOWER_MEADOW = PLACED_FEATURES.register(
            "grown_flower_meadow_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GROWN_FLOWER_MEADOW.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(24),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()))
    );

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

}
