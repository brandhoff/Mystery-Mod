package com.CiD.MysteryMod.Helper;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Location {
	private int boundX;
	private int boundY;
	private int boundZ;
	
	public Location(int x, int y,int z ) {
		
		boundX = x;
		boundY = y;
		boundZ = z;
	}
	
	public Location(double posX, double posY, double posZ) {
		boundX = (int) posX;
		boundY = (int) posY;
		boundZ = (int) posZ;
	}

	public static Location getLocationFromEntity(Entity entity){
		if(entity == null){
		return null;
		}else{
			if(entity instanceof EntityPlayer){
				return new Location(entity.posX, entity.posY, entity.posZ);

			}
			return new Location(entity.posX, entity.posY, entity.posZ);
		}
	}
	
	public int getX(){
		
		return boundX;
	}
		public int getY(){
				
				return boundY;
			}
			public int getZ(){
				
				return boundZ;
			}

	
}
