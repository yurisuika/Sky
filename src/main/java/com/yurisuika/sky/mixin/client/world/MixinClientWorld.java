package com.yurisuika.sky.mixin.client.world;

import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientWorld.class)
public class MixinClientWorld {

    /**
     * @author
     * Sap
     * @reason
     * Horizon Height
     */
    @Overwrite
    public double getHorizonHeight() {
        return 0.0D;
    }
}
