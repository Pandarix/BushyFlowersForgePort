package net.Pandarix.bushierflowers.mixin;

import net.Pandarix.bushierflowers.BushierFlowers;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class BushierFlowersMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		BushierFlowers.LOGGER.info("Initializing " + BushierFlowers.MOD_ID + " Mixins");
	}

}
