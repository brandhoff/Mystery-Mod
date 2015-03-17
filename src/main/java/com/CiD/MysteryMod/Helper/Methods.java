package com.CiD.MysteryMod.Helper;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Methods {
private final static int DOWN = 1;
private final static int EAST = 2;
private final static int NORTH = 3;
private final static int SOUTH = 4;
private final static int UP = 5;
private final static int WEST = 6;

	public static void BreakBlock(final World world, final int x, final int y, final int z, final boolean drop){
		world.func_147480_a(x,y,z,drop);
	}
	
	public static final int ForgeDirectionToInterger(ForgeDirection dir){
		switch(dir){
		default: return 666;
			case DOWN: return DOWN;
			case EAST: return EAST;
			case NORTH: return NORTH;
			case SOUTH: return SOUTH;
			case UP: return UP;
			case WEST: return WEST;
		}
	}
	
	public static final ForgeDirection IntergerToForgeDirection(int i){
		switch(i){
		default: return ForgeDirection.UNKNOWN;
			case DOWN: return ForgeDirection.DOWN;
			case EAST: return ForgeDirection.EAST;
			case NORTH: return ForgeDirection.NORTH;
			case SOUTH: return ForgeDirection.SOUTH;
			case UP: return ForgeDirection.UP;
			case WEST: return ForgeDirection.WEST;
		}
	}
}
