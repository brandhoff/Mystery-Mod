package com.CiD.MysteryMod.Events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Helper.Location;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

public class BaseEvent {

	@ActiveEvent
    public static void startPlayerGreenCrystalEvent(EntityPlayer player, TileEntity tile){
		TileEntityGreenCrystal GreenTile = (TileEntityGreenCrystal)tile;
    	World world = player.worldObj;
    	if(!world.isRemote){
    		int startX = tile.xCoord - 10;
    		int startY = tile.yCoord - 2;
    		int startZ = tile.zCoord -10;

    		int stopX = tile.xCoord + 10;
    		int stopY = tile.yCoord + 2;
    		int stopZ = tile.zCoord + 10;

    		//LOOP
//    		while(startX < stopX){
//    			startX++;
//    			while(startY < stopY){
//    				startY++;
//    				while(startZ < stopZ){
//    					startZ++;
    					//CODE HERE
    		for(int x = startX; x < stopX; x++){			
        		for(int y = startY; y < stopY; y++){			
            		for(int z = startZ; z < stopZ; z++){			

    			
    			Random ran = new Random();
    					if(ran.nextInt(100) < 5){
    						Block block = world.getBlock(x, y, z);
    						if(block != Blocks.bedrock && block != MysteryMain.green_crystal){
//    							world.spawnEntityInWorld(new EntityFallingBlock(world, x, y, z, block));
    							Random rand = new Random();
//    							for(int i = 0; i <100; i++)
//    								 world.spawnParticle("reddust", x +0.5 + (rand.nextDouble() - 0.5D) * (double)0.5, (y+1.5 + rand.nextDouble() * (double)30.5) - 0.25D, z +0.5 + (rand.nextDouble() - 0.5D) * (double)0.5, -1.0D, 1.0D,0.0D);
    							GreenTile.addLocation(new Location(x, y, z));	 
//    							world.spawnEntityInWorld(new EntityGraviBlock(world, x, y, z, block, new Location(x, y, z)));
    							world.func_147480_a(x, y, z, false);
    						}
    					}
    					
    					
    				}
    			}
    		}
    		
    		
    	}
    }
	
	
}
