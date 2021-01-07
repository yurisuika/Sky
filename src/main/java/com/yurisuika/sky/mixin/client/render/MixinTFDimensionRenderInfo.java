package com.yurisuika.sky.mixin.client.render;

import com.terraforged.mod.client.render.TFDimensionRenderInfo;
import com.yurisuika.sky.registry.SkyDimensions;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TFDimensionRenderInfo.class)
public class MixinTFDimensionRenderInfo {

    /**
     * @author
     * Sap
     * @reason
     * Cloud Height
     */
    @Inject(method = "func_239213_a_", at = @At("TAIL"), cancellable = true)
    public void TFDimensionRenderInfo(CallbackInfoReturnable<Float> ci) {
        float value =  0F;
        if (SkyDimensions.isSkyDimension(Minecraft.getInstance().world)) {
            ci.setReturnValue(value);
        }
        else {
            float valueTF =  220F;
            ci.setReturnValue(valueTF);
        }
    }

}
