package com.yurisuika.sky.data;

import com.google.common.collect.ImmutableMap;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;

import java.util.Map;

public class DataBiomes extends DataBiomeProvider {

    public DataBiomes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected Map<RegistryKey<Biome>, Biome> registerBiomes() {
        final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes = ImmutableMap.builder();

        biomes.put(com.yurisuika.sky.registry.SkyBiomes.sky, makeSky());

        return biomes.build();
    }

    public static Biome makeSky() {
        return buildBiome(
                createBuilder(
                        createAmbience(9871211, 9871211, getSkyForTemp(0.5f), 12638463),
                        sky(),
                        buildSpawns(createSpawns())
                ).depth(0.0F).scale(1.2F).temperature(0.5F)
        );
    }

    private static int getSkyForTemp(float temperature) {
        float a = MathHelper.clamp(temperature / 3.0f, -1.0f, 1.0f);
        return MathHelper.hsvToRGB(0.62222224f - a * 0.05f, 0.5f + a * 0.1f, 1.0f);
    }

}
