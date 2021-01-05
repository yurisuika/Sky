package com.yurisuika.sky.world.layer;

import com.yurisuika.sky.registry.ModBiomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class SkyBiomesLayer implements IAreaTransformer0 {
    protected int[] biomes = new int[]{
            SkyLayerUtil.getBiomeId(ModBiomes.sky),
    };

    public SkyBiomesLayer() { }

    @Override
    public int apply(INoiseRandom iNoiseRandom, int rand1, int rand2) {
        return biomes[iNoiseRandom.random(biomes.length)];
    }
}
