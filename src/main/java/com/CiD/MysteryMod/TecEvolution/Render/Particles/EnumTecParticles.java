package com.CiD.MysteryMod.TecEvolution.Render.Particles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public enum EnumTecParticles {	
	Simple,
	Circle
	;
	@SideOnly(Side.CLIENT)
	public void spawnParticle(World world, double x, double y, double z, double motionX, double motionY, double motionZ, float rot, float green, float blue, double d) {
		Minecraft mc = Minecraft.getMinecraft();
		if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
			int particleSetting = mc.gameSettings.particleSetting;
			
			
			
			double distanceX = mc.renderViewEntity.posX - x;
			double distanceY = mc.renderViewEntity.posY - y;
			double distanceZ = mc.renderViewEntity.posZ - z;
			
			double maxDistance = 16;
			if (distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ > maxDistance * maxDistance) {
				return;
			}
			
			EntityFX particleEffect = null;
			switch(this) {
				case Simple:
					particleEffect = new FXsimple(world, x, y, z, motionX, motionY, motionZ, rot, green, blue);
					break;
				case Circle:
					particleEffect = new FXcircle(world, x, y, z, motionX, motionY, motionZ, rot, green, blue,d);
					break;
		
			}
			
			if (particleEffect != null) {
				Minecraft.getMinecraft().effectRenderer.addEffect(particleEffect);
			}
			
			
		}
	}
	
}
