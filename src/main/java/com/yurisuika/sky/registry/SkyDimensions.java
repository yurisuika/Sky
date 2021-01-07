package com.yurisuika.sky.registry;

import com.yurisuika.sky.Sky;
import com.yurisuika.sky.world.SkyChunkGenerator;
import com.yurisuika.sky.world.SkyBiomeProvider;
import com.yurisuika.sky.world.SkySurfaceBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SkyDimensions {
    public static final ResourceLocation SKY_ID = Sky.locate("sky");
    public static final RegistryKey<World> SKY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, SKY_ID);
    public static final RegistryKey<Dimension> SKY_DIM = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, SKY_ID);
    public static final RegistryKey<DimensionType> SKY_TYPE = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, SKY_ID);
    public static final RegistryKey<DimensionSettings> SKY_NOISE_SETTINGS = RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, SKY_ID);
    public static final SurfaceBuilder<SurfaceBuilderConfig> SKY_BUILDER = RegistryHelper.registerSurfaceBuilder("sky", new SkySurfaceBuilder<>(SurfaceBuilderConfig.field_237203_a_));

    public static void initDimension() {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(Sky.MOD_ID, "sky"), SkyBiomeProvider.CODEC);
        Registry.register(Registry.CHUNK_GENERATOR_CODEC, new ResourceLocation(Sky.MOD_ID, "sky_gen"), SkyChunkGenerator.CODEC);
    }

    public static boolean isSkyDimension(World world) {
        final RegistryKey<World> key = world.getDimensionKey();
        return key == SKY;
    }

}
