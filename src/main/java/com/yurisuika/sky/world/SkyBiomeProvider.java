package com.yurisuika.sky.world;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.List;
import java.util.Random;

import static com.yurisuika.sky.registry.SkyBiomes.*;

public class SkyBiomeProvider extends BiomeProvider {

    public static final Codec<SkyBiomeProvider> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.LONG.fieldOf("seed").orElse(new Random().nextLong()).forGetter((obj) -> obj.seed),
            RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((obj) -> obj.registry)
    ).apply(instance, instance.stable(SkyBiomeProvider::new)));

    private final long seed;
    private final Registry<Biome> registry;
    private final Layer genBiomes;
    private static final List<RegistryKey<Biome>> biomes = ImmutableList.of(
            sky);

    public SkyBiomeProvider(long seed, Registry<Biome> registry) {
        super(biomes.stream().map(key -> () -> registry.getOrThrow(key)));
        this.seed = seed;
        this.registry = registry;
        this.genBiomes = SkyBiomesLayer.makeLayers(seed, registry);
    }

    @Override
    public BiomeProvider getBiomeProvider(long s) {
        return new SkyBiomeProvider(s, registry);
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return this.getBiomeFromPos(registry, x, z);
    }

    public Biome getBiomeFromPos(Registry<Biome> registry, int x, int z) {
        int i = genBiomes.field_215742_b.getValue(x, z);
        Biome biome = registry.getByValue(i);
        if (biome == null) {
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + i));
            } else {
                return registry.getValueForKey(BiomeRegistry.getKeyFromID(0));
            }
        } else {
            return biome;
        }
    }
}
