package com.yurisuika.sky.registry;

import com.yurisuika.sky.data.DataBiomes;
import com.yurisuika.sky.Sky;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SkyBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Sky.MOD_ID);

    public static final RegistryKey<Biome> sky = registerBiome("sky", DataBiomes.makeSky());

    private static RegistryKey<Biome> registerBiome(String name, Biome biome) {
        BIOMES.register(name, () -> biome);
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Sky.MOD_ID, name));
    }

}
