package com.yurisuika.sky.mixin.client.world;

import com.yurisuika.sky.registry.SkyDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.DimensionRenderInfo;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionRenderInfo.class)
public class MixinDimensionRenderInfo {

    /**
     * @author
     * Sap
     * @reason
     * Cloud Height
     */
    @Inject(method = "func_239213_a_", at = @At("HEAD"), cancellable = true)
    private void getCloudHeight(CallbackInfoReturnable<Float> ci) {
        float value =  0F;
        if (SkyDimensions.isSkyDimension(Minecraft.getInstance().world)) {
            ci.setReturnValue(value);
        }
    }

}