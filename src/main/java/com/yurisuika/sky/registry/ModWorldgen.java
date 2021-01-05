package com.yurisuika.sky.registry;

import com.yurisuika.sky.world.surface.SkySurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModWorldgen {

    public static final SurfaceBuilder<SurfaceBuilderConfig> SKY = RegistryHelper.registerSurfaceBuilder("sky", new SkySurfaceBuilder<>(SurfaceBuilderConfig.field_237203_a_));

}
