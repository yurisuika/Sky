package com.yurisuika.sky.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class SkySurfaceBuilder<T extends SurfaceBuilderConfig> extends SurfaceBuilder<T> {

    public SkySurfaceBuilder(Codec<T> config) {
        super(config);
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int sealevel, long seed, T config) {
        this.genSkyBiomeTerrain(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), sealevel);
    }

    public final void genSkyBiomeTerrain(Random rand, IChunk chunk, Biome biome, int x, int z, int startHeight, double noiseVal, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel) {
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        defaultBlock = Blocks.AIR.getDefaultState();
        defaultFluid = Blocks.AIR.getDefaultState();
        bottom = Blocks.AIR.getDefaultState();
        middle = Blocks.AIR.getDefaultState();
        top = Blocks.AIR.getDefaultState();
    }
}
