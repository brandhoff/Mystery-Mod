package com.CiD.MysteryMod.Helper;

import net.minecraft.world.World;

public class Methods {

	
	public static void BreakBlock(final World world, final int x, final int y, final int z, final boolean drop){
		world.func_147480_a(x,y,z,drop);
	}
	
	
}
