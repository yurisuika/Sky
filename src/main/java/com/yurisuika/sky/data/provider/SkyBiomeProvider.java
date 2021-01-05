package com.yurisuika.sky.data.provider;

import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import com.yurisuika.sky.registry.SkyBiomeFeatures;
import net.minecraft.data.BiomeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class SkyBiomeProvider extends BiomeProvider {

    public SkyBiomeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void act(DirectoryCache dir) {

        Path out = this.generator.getOutputFolder();

        for(Map.Entry<RegistryKey<Biome>, Biome> biome : registerBiomes().entrySet()) {
            Path path = getPath(out, biome.getKey().getLocation());
            Biome obj = biome.getValue();
            obj.setRegistryName(biome.getKey().getLocation());
            Function<Supplier<Biome>, DataResult<JsonElement>> biomedata = JsonOps.INSTANCE.withEncoder(Biome.BIOME_CODEC);

            try {
                Optional<JsonElement> element = biomedata.apply(biome::getValue).result();
                if (element.isPresent()) {
                    IDataProvider.save(GSON, dir, element.get(), path);
                } else {
                }
            } catch (IOException e) {
            }
        }
    }

    private static Path getPath(Path path, ResourceLocation loc) {
        return path.resolve("data/" + loc.getNamespace() + "/worldgen/biome/" + loc.getPath() + ".json");
    }

    protected abstract Map<RegistryKey<Biome>, Biome> registerBiomes();

    public static Biome buildBiome(Biome.Builder builder) {
        return builder.build();
    }

    public static Biome.Builder createBuilder(BiomeAmbience ambience, BiomeGenerationSettings settings, MobSpawnInfo info) {
        return (new Biome.Builder())
                .precipitation(Biome.RainType.NONE)
                .downfall(0.0F)
                .category(Biome.Category.NONE)
                .withTemperatureModifier(Biome.TemperatureModifier.NONE)
                .setEffects(ambience)
                .withGenerationSettings(settings)
                .withMobSpawnSettings(info);
    }

    public static MobSpawnInfo buildSpawns(MobSpawnInfo.Builder builder) {
        return builder.copy();
    }

    public static MobSpawnInfo.Builder createSpawns() {
        return new MobSpawnInfo.Builder();
    }

    public static BiomeAmbience createAmbience(int plant, int sky, int fog) {
        return createAmbience(plant, plant, sky, fog);
    }

    public static BiomeAmbience createAmbience(int grass, int foliage, int sky, int fog) {
        return (new BiomeAmbience.Builder())
                .withGrassColor(grass)
                .withFoliageColor(foliage)
                .withSkyColor(sky)
                .setFogColor(fog)
                .setWaterColor(16777215)
                .setWaterFogColor(16777215)
                .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                .build();
    }

    public static BiomeGenerationSettings.Builder createSettings() {
        return new BiomeGenerationSettings.Builder();
    }

    public static BiomeGenerationSettings sky() {
        return createSettings()
                .withSurfaceBuilder(SkyBiomeFeatures.sky)
                .build();
    }
}
