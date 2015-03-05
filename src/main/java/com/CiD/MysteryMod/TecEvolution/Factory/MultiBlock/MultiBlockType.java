package com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock;

import net.minecraft.world.World;

public enum MultiBlockType {
CraftingStation,
FusionReactor;
	
	
	public static boolean hasNeededBlock(MultiBlockType type, World world, final int x, final int y, final int z){
		switch(type){
		
		case CraftingStation:{
				Structures.hasStructure(CraftingStation, world, x, y, z);
				//REST IS HANDLED IN THE STURCTURE CLASS
				
				break;
			}
		case FusionReactor:{
			Structures.hasStructure(FusionReactor, world, x, y, z);
			//REST IS HANDLED IN THE STURCTURE CLASS
			
			break;
		}
		}
		
		return false;
	}
	
	
}
