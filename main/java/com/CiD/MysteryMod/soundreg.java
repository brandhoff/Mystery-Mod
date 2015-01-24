package com.CiD.MysteryMod;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class soundreg {
		/** This is my Method for playing own sounds*/
		public static void onEntityPlay(String location, World world, Entity entity,float vol, float pitchs){
			world.playSoundAtEntity(entity, MysteryMain.MODID+":"+location, vol, pitchs);
		}
    
		
}