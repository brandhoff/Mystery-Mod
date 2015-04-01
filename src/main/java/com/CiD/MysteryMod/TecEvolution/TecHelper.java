package com.CiD.MysteryMod.TecEvolution;

import com.CiD.API.energy.IContainesEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class TecHelper {
public static final int SIDE_UP = 0;
	
	public static final int SIDE_DOWN = 1;

	public static final int SIDE_X = 2;

	public static final int SIDE_MX = 3;

	public static final int SIDE_Z = 4;

	public static final int SIDE_MZ = 5;
	
	
	
	/** From X-Tra-Tools */
public static boolean hasHullOfType(World world, int x,int y, int z, int faceing,Block Type){
		
		faceing = world.getBlockMetadata(x, y, z);
	
	switch(faceing){
	case 2: {
		if(world.getBlock(x, y, z+1) == Type && world.getBlock(x, y+1, z+1) == Type && world.getBlock(x, y+2, z+1) == Type && world.getBlock(x, y+3, z+1) == Type){
			if(world.getBlock(x+1, y, z+1) == Type && world.getBlock(x+1, y+1, z+1) == Type && world.getBlock(x+1, y+2, z+1) == Type && world.getBlock(x+1, y+3, z+1) == Type){
				if(world.getBlock(x, y, z+2) == Type && world.getBlock(x, y+1, z+2) == Type && world.getBlock(x, y+2, z+2) == Type && world.getBlock(x, y+3, z+2) == Type){
					if(world.getBlock(x-1, y, z+1) == Type && world.getBlock(x-1, y+1, z+1) == Type && world.getBlock(x-1, y+2, z+1) == Type && world.getBlock(x-1, y+3, z+1) == Type){

			return true;
			}
		}
	}
		
}
}				case 3: {
if(world.getBlock(x, y, z-1) == Type && world.getBlock(x, y+1, z-1) == Type && world.getBlock(x, y+2, z-1) == Type && world.getBlock(x, y+3, z-1) == Type){
	if(world.getBlock(x+1, y, z-1) == Type && world.getBlock(x+1, y+1, z-1) == Type && world.getBlock(x+1, y+2, z-1) == Type && world.getBlock(x+1, y+3, z-1) == Type){
		if(world.getBlock(x, y, z-2) == Type && world.getBlock(x, y+1, z-2) == Type && world.getBlock(x, y+2, z-2) == Type && world.getBlock(x, y+3, z-2) == Type){
			if(world.getBlock(x-1, y, z-1) == Type && world.getBlock(x-1, y+1, z-1) == Type && world.getBlock(x-1, y+2, z-1) == Type && world.getBlock(x-1, y+3, z-1) == Type){

	return true;
	}
}
}

}
}				
	case 4: {
		if(world.getBlock(x+1, y, z) == Type && world.getBlock(x+1, y+1, z) == Type && world.getBlock(x+1, y+2, z) == Type && world.getBlock(x+1, y+3, z) == Type){
			if(world.getBlock(x+1, y, z+1) == Type && world.getBlock(x+1, y+1, z+1) == Type && world.getBlock(x+1, y+2, z+1) == Type && world.getBlock(x+1, y+3, z+1) == Type){
				if(world.getBlock(x+2, y, z) == Type && world.getBlock(x+2, y+1, z) == Type && world.getBlock(x+2, y+2, z) == Type && world.getBlock(x+2, y+3, z) == Type){
					if(world.getBlock(x+1, y, z-1) == Type && world.getBlock(x+1, y+1, z-1) == Type && world.getBlock(x+1, y+2, z-1) == Type && world.getBlock(x+1, y+3, z-1) == Type){

			return true;
			}
		}
	}
		
}
}	
	case 5: {
		if(world.getBlock(x-1, y, z) == Type && world.getBlock(x-1, y+1, z) == Type && world.getBlock(x-1, y+2, z) == Type && world.getBlock(x-1, y+3, z) == Type){
			if(world.getBlock(x-1, y, z+1) == Type && world.getBlock(x-1, y+1, z+1) == Type && world.getBlock(x-1, y+2, z+1) == Type && world.getBlock(x-1, y+3, z+1) == Type){
				if(world.getBlock(x-2, y, z) == Type && world.getBlock(x-2, y+1, z) == Type && world.getBlock(x-2, y+2, z) == Type && world.getBlock(x-2, y+3, z) == Type){
					if(world.getBlock(x-1, y, z-1) == Type && world.getBlock(x-1, y+1, z-1) == Type && world.getBlock(x-1, y+2, z-1) == Type && world.getBlock(x-1, y+3, z-1) == Type){

			return true;
			}
		}
	}
		
}
}		
		
	default: return false;	
	}
}
	/** gets all the connections in an int[] */
	public static boolean[] checkConnections(World world, int xCoord, int yCoord, int zCoord){
		boolean[] connections = new boolean[6];
		if(world.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityEnergy || world.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof IContainesEnergy){
			connections[SIDE_X] = true;
		}else{
			connections[SIDE_X] = false;

		}
		
		if(world.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityEnergy || world.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof IContainesEnergy){
			connections[SIDE_MX] = true;
		}else{
			connections[SIDE_MX] = false;

		}
		
		if(world.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityEnergy || world.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof IContainesEnergy){
			connections[SIDE_Z] = true;
		}else{
			connections[SIDE_Z] = false;

		}
		
		if(world.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityEnergy || world.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof IContainesEnergy){
			connections[SIDE_MZ] = true;
		}else{
			connections[SIDE_MZ] = false;

		}
		
		if(world.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityEnergy || world.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof IContainesEnergy){
			connections[SIDE_UP] = true;
		}else{
			connections[SIDE_UP] = false;

		}
		
		if(world.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityEnergy || world.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof IContainesEnergy){
			connections[SIDE_DOWN] = true;
		}else{
			connections[SIDE_DOWN] = false;

		}
		
		
		return connections;
	}
	
	
	
}
