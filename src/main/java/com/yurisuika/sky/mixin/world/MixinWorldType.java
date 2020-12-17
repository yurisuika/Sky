package com.yurisuika.sky.mixin.world;

import net.minecraft.world.WorldType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WorldType.class)
public class MixinWorldType {

    public double voidFadeMagnitude() {
        return 1.0D;
    }
}
