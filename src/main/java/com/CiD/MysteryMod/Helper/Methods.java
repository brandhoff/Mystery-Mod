package com.CiD.MysteryMod.Helper;

import net.minecraft.world.World;

public class Methods {

	
	public static void BreakBlock(World world, int x, int y, int z, boolean drop){
		world.func_147480_a(x,y,z,drop);
	}
	
	
}
