package com.yurisuika.sky;

import com.yurisuika.sky.data.DataBiomes;
import com.yurisuika.sky.registry.SkyBiomes;
import com.yurisuika.sky.registry.SkyDimensions;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("sky")
@Mod.EventBusSubscriber(modid = Sky.MOD_ID, bus = Bus.MOD)
public class Sky {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "sky";
	public static Sky instance;

	public static ResourceLocation locate(String name)
	{
		return new ResourceLocation(MOD_ID, name);
	}


	public Sky() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		new SkyBiomes();

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(this::gatherData);

		SkyBiomes.BIOMES.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		SkyDimensions.initDimension();
	}

	public void clientSetup(FMLClientSetupEvent event) {
		DimensionRenderInfo sky = new DimensionRenderInfo(0.0F, true, DimensionRenderInfo.FogType.NORMAL, false, false) {
			@Override
			public Vector3d func_230494_a_(Vector3d vector3d, float v) {
				return vector3d;
			}

			@Override
			public boolean func_230493_a_(int i, int i1) {
				return false;
			}
		};
		DimensionRenderInfo.field_239208_a_.put(new ResourceLocation(Sky.MOD_ID, "sky"), sky);
	}

	public void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new DataBiomes(generator));
		}
	}

}
