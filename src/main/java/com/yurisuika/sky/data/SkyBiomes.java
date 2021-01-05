package com.yurisuika.sky.data;

import com.google.common.collect.ImmutableMap;
import com.yurisuika.sky.data.provider.SkyBiomeProvider;
import com.yurisuika.sky.registry.ModBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.Map;

public class SkyBiomes extends SkyBiomeProvider {

    public SkyBiomes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected Map<RegistryKey<Biome>, Biome> registerBiomes() {
        final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes = ImmutableMap.builder();

        biomes.put(ModBiomes.sky, makeSky());

        return biomes.build();
    }

    public static Biome makeSky() {
        return buildBiome(
                createBuilder(
                        createAmbience(9871211, 12177892, 13227488),
                        sky(),
                        buildSpawns(createSpawns())
                ).depth(0.0F).scale(1.2F).temperature(0.5F)
        );
    }

}
