package com.yurisuika.sky.mixin.client.world;

import com.yurisuika.sky.registry.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {

    /**
     * @author
     * Sap
     * @reason
     * Horizon Height
     */
    @Redirect(
            method = "Lnet/minecraft/client/renderer/WorldRenderer;renderSky(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/world/ClientWorld$ClientWorldInfo;getVoidFogHeight()D"
            )
    )
    private double redirectGetSkyDarknessHeight(ClientWorld.ClientWorldInfo properties) {
        if (ModDimensions.isSkyDimension(Minecraft.getInstance().world)) {
            return 0;
        }
        return properties.getVoidFogHeight();
    }

}
