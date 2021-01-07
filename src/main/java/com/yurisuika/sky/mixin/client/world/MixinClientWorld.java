package com.yurisuika.sky.mixin.client.world;

import com.yurisuika.sky.registry.SkyDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.ClientWorldInfo.class)
public class MixinClientWorld {

    /**
     * @author
     * Sap
     * @reason
     * Horizon Height
     */
    @Inject(method = "getFogDistance", at = @At("HEAD"), cancellable = true)
    private void getFogDistance(CallbackInfoReturnable<Double> ci) {
        double value =  1.0D;
        if (SkyDimensions.isSkyDimension(Minecraft.getInstance().world)) {
            ci.setReturnValue(value);
        }
    }

}
