package net.Pandarix.bushierflowers.item;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.Pandarix.bushierflowers.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final CreativeModeTab BUSHIER_FLOWERS = new CreativeModeTab("bushier_flowers") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.GROWN_ALLIUM.get());
        }
    };
}
