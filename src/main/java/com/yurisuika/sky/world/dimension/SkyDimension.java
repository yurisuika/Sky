package com.yurisuika.sky.world.dimension;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class SkyDimension extends Dimension {

	public SkyDimension(World world, DimensionType type) {
		super(world, type, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new SkyChunkGenerator(world, new SkyBiomeProvider(), new SkyGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		double d0 = MathHelper.frac((double) worldTime / 24000.0D - 0.25D);
		double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
		return (float) (d0 * 2.0D + d1) / 3.0F;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
			float f = MathHelper.cos(celestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
			f = MathHelper.clamp(f, 0.0F, 1.0F);
			float f1 = 0.78823529F;
			float f2 = 0.83921568F;
			float f3 = 0.87843137F;
			f1 = f1 * (f * 0.94F + 0.06F);
			f2 = f2 * (f * 0.94F + 0.06F);
			f3 = f3 * (f * 0.91F + 0.09F);
			return new Vec3d((double) f1, (double) f2, (double) f3);
	}


	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}

	@Override
	public float getCloudHeight() {
		return 0F;
	}

	public double voidFadeMagnitude() {
		return 0.0D;
	}

}
