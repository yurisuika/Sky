package com.yurisuika.sky.mixin.block;

import com.yurisuika.sky.registry.SkyDimensions;
import net.minecraft.block.BlockState;
import net.minecraft.block.TNTBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(TNTBlock.class)
public class MixinTNTBlock {

    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos, igniter);
    }

    /** @deprecated */
    @Deprecated
    public void explode(World world, BlockPos worldIn) {
        explode(world, worldIn, (LivingEntity)null);
    }

    /** @deprecated */
    @Deprecated
    private static void explode(World worldIn, BlockPos pos, @Nullable LivingEntity entityIn) {
        if (!worldIn.isRemote) {
            TNTEntity tntentity = new TNTEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, entityIn);
            worldIn.addEntity(tntentity);
            worldIn.playSound((PlayerEntity)null, tntentity.getPosX(), tntentity.getPosY(), tntentity.getPosZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

    }

    /**
     * @author
     * Sky
     * @reason
     * TNT
     */
//    @Overwrite()
//    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
//        if (!worldIn.isRemote) {
//            Entity entity = projectile.func_234616_v_();
//            if (projectile.isBurning()) {
//                if (SkyDimensions.isOverworldDimension(Minecraft.getInstance().world)) {
//                    BlockPos blockpos = hit.getPos();
//                    this.catchFire(state, worldIn, blockpos, (Direction) null, entity instanceof LivingEntity ? (LivingEntity) entity : null);
//                    worldIn.removeBlock(blockpos, false);
//                }
//                else {
//                    if (SkyDimensions.isSkyDimension(Minecraft.getInstance().world)) {
//                        BlockPos blockpos = hit.getPos();
//                    }
//                    else {
//                        BlockPos blockpos = hit.getPos();
//                        this.catchFire(state, worldIn, blockpos, (Direction) null, entity instanceof LivingEntity ? (LivingEntity) entity : null);
//                        worldIn.removeBlock(blockpos, false);
//                    }
//                }
//            }
//        }
//    }
//    @Overwrite()
//    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
//        if (!worldIn.isRemote && !SkyDimensions.isSkyDimension(Minecraft.getInstance().world)) {
//            Entity entity = projectile.func_234616_v_();
//            if (projectile.isBurning()) {
//                BlockPos blockpos = hit.getPos();
//                catchFire(state, worldIn, blockpos, null, entity instanceof LivingEntity ? (LivingEntity)entity : null);
//                worldIn.removeBlock(blockpos, false);
//            }
//        }
//    }

}
