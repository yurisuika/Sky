package com.yurisuika.sky.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.yurisuika.sky.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class SkyBiomeProvider extends BiomeProvider {

	private Random rand;

	public SkyBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.SKY_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.SKY_BIOME.get();
	}

}
