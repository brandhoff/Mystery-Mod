package com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Structures {

	public static boolean hasStructure(MultiBlockType type, World world, final int x, final int y, final int z){
		
		switch(type){
			default: return false;
			case CraftingStation:{
				if(world.getTileEntity(x, y, z) instanceof ITileMultiBlock){
					if(world.getBlock(x, y + 1, z) == Blocks.crafting_table && world.getBlock(x, y - 1, z) == Blocks.crafting_table){
						
						((ITileMultiBlock)world.getTileEntity(x, y, z)).setTileInMultiblockForm();
						return true;
					}else{

						((ITileMultiBlock)world.getTileEntity(x, y, z)).disableMultiBlock();
						return true;
					}
				}
			}
		}
				
		return false;
	}
	
	
}
