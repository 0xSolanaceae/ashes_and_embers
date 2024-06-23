
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ashesembers.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import com.ashesembers.AshesembersMod;

public class AshesembersModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AshesembersMod.MODID);
	public static final RegistryObject<SimpleParticleType> ASHES = REGISTRY.register("ashes", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> EMBERS = REGISTRY.register("embers", () -> new SimpleParticleType(false));
}
