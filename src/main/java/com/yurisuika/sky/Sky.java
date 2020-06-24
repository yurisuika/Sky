package com.yurisuika.sky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yurisuika.sky.init.BiomeInit;
import com.yurisuika.sky.init.DimensionInit;
//import com.yurisuika.sky.world.worldtype.SkyWorldType;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("sky")
@Mod.EventBusSubscriber(modid = Sky.MOD_ID, bus = Bus.MOD)
public class Sky {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "sky";
	public static Sky instance;
	// public static final WorldType EXAMPLE_WORLDTYPE = new SkyWorldType();
	public static final ResourceLocation SKY_DIM_TYPE = new ResourceLocation(MOD_ID, "sky");

	public Sky() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);

		BiomeInit.BIOMES.register(modEventBus);
		DimensionInit.MOD_DIMENSIONS.register(modEventBus);

		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeInit.registerBiomes();
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	@SubscribeEvent
	public static void onServerStarting(FMLServerStartingEvent event) {

	}
}
