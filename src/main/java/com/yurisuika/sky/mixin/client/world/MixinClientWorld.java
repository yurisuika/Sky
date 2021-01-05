package com.yurisuika.sky.mixin.client.world;

import com.yurisuika.sky.registry.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
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
     //@Overwrite
     //public double getVoidFogHeight() {
     //       return 0.0D;
     //}

    /**
     * @author
     * Sap
     * @reason
     * Horizon Height
     */
    //@Overwrite
    //public double getFogDistance() {
    //    return 1.0D;
    //}
    @Inject(method = "getFogDistance", at = @At("HEAD"), cancellable = true)
    private void getFogDistance(CallbackInfoReturnable<Double> ci) {
        double value =  1.0D;
        if (ModDimensions.isSkyDimension(Minecraft.getInstance().world)) {
            ci.setReturnValue(value);
        }
    }

}
