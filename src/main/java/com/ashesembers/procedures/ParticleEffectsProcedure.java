package com.ashesembers.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.ashesembers.init.AshesembersModParticleTypes;
import com.ashesembers.AshesembersMod;

@Mod.EventBusSubscriber
public class ParticleEffectsProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_overworld")))) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				if (!entity.isUnderWater()) {
					AshesembersMod.queueServerWork(30, () -> {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (AshesembersModParticleTypes.ASHES.get()), x, y, z, 8, (Mth.nextInt(RandomSource.create(), 1, 10)), (Mth.nextInt(RandomSource.create(), 5, 10)),
										(Mth.nextInt(RandomSource.create(), 1, 10)), 0.1);
						}
						if (Math.random() < 0.2) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (AshesembersModParticleTypes.EMBERS.get()), x, y, z, 2, (Mth.nextInt(RandomSource.create(), 1, 10)), (Mth.nextInt(RandomSource.create(), 7, 10)),
										(Mth.nextInt(RandomSource.create(), 1, 10)), 0.1);
						}
					});
				}
			}
		}
	}
}
