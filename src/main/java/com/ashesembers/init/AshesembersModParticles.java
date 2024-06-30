package com.ashesembers.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.ashesembers.client.particle.EmbersParticle;
import com.ashesembers.client.particle.AshesParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AshesembersModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(AshesembersModParticleTypes.ASHES.get(), AshesParticle::provider);
		event.registerSpriteSet(AshesembersModParticleTypes.EMBERS.get(), EmbersParticle::provider);
	}
}
