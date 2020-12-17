package com.yurisuika.sky.world;

import net.minecraft.world.WorldType;

public class SkyWorldType extends WorldType {
    public SkyWorldType() {
        super("SKY_WORLD_TYPE");
    }

    @Override
    public float getCloudHeight() {
        return 0F;
    }

    @Override
    public double voidFadeMagnitude() {
        return 0.0D;
    }
}
