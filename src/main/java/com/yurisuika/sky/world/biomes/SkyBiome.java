package com.yurisuika.sky.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class SkyBiome extends Biome {

	public SkyBiome(Builder biomeBuilder) {
		super(biomeBuilder);
	}

	//private int calculateSkyColor() {
	//    float f = this.temperature;
	//    f /= 3.0F;
	//    f = MathHelper.clamp(f, -1.0F, 1.0F);
	//    return MathHelper.hsvToRGB(0.5805F - f * 0.05F, 0.2F + f * 0.1F, 0.89F);
	//}
}
