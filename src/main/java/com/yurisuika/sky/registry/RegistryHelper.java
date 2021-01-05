package com.yurisuika.sky.registry;

import com.google.common.collect.Lists;
import com.yurisuika.sky.Sky;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

@Mod.EventBusSubscriber(modid = Sky.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHelper {

    public static final List<SurfaceBuilder<?>> SURFACE_BUILDERS = Lists.newArrayList();

    public static SurfaceBuilder<SurfaceBuilderConfig> registerSurfaceBuilder(String name, SurfaceBuilder<SurfaceBuilderConfig> surface) {
        surface.setRegistryName(name);
        SURFACE_BUILDERS.add(surface);
        return surface;
    }

    @SubscribeEvent
    public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
        IForgeRegistry<SurfaceBuilder<?>> registry = event.getRegistry();
        for (SurfaceBuilder<?> surface : SURFACE_BUILDERS) {
            registry.register(surface);
        }
    }

}
