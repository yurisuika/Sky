package com.yurisuika.sky.init;

import com.yurisuika.sky.Sky;
import com.yurisuika.sky.world.dimension.SkyModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {

	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Sky.MOD_ID);

	public static final RegistryObject<ModDimension> SKY_DIM = MOD_DIMENSIONS.register("sky", () -> new SkyModDimension());
}
