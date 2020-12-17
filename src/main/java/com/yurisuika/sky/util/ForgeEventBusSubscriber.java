package com.yurisuika.sky.util;

import com.yurisuika.sky.Sky;
import com.yurisuika.sky.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Sky.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(Sky.SKY_DIM_TYPE) == null) {
			DimensionManager.registerDimension(Sky.SKY_DIM_TYPE, DimensionInit.SKY_DIM.get(), null,
					true);
		}
		Sky.LOGGER.info("Dimensions Registered!");
	}

}
