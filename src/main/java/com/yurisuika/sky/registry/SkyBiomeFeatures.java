package com.yurisuika.sky.registry;

import com.yurisuika.sky.Sky;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SkyBiomeFeatures {

    public static final BlockState AIR = Blocks.AIR.getDefaultState();

    public static final SurfaceBuilderConfig SKY = new SurfaceBuilderConfig(AIR, AIR, AIR);

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> sky = registerSurfaceBuilder("sky", SkyDimensions.SKY.func_242929_a(SKY));


    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> registerSurfaceBuilder(String name, ConfiguredSurfaceBuilder<SC> surface) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Sky.MOD_ID, name), surface);
    }

}
