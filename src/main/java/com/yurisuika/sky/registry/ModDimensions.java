package com.yurisuika.sky.registry;

import com.yurisuika.sky.Sky;
import com.yurisuika.sky.world.SkyChunkGenerator;
import com.yurisuika.sky.world.layer.SkyBiomeProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class ModDimensions {

    public static final RegistryKey<World> sky_world = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(Sky.MOD_ID, "sky"));
    public static final RegistryKey<DimensionType> sky_dimension = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(Sky.MOD_ID, "sky"));

    public static void initDimension() {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(Sky.MOD_ID, "sky"), SkyBiomeProvider.CODEC);
        Registry.register(Registry.CHUNK_GENERATOR_CODEC, new ResourceLocation(Sky.MOD_ID, "sky_gen"), SkyChunkGenerator.CODEC);
    }

    public static boolean isSkyDimension(World world) {
        final RegistryKey<World> key = world.getDimensionKey();
        return key == sky_world;
    }

}