package com.CiD.MysteryMod.TecEvolution.TileEntity;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.CiD.MysteryMod.Helper.Methods;
import com.CiD.MysteryMod.TecEvolution.TecDATA;

public class TileEntityMiner extends TileEntityMachine{
private int sleepTimer = 20*1;
private int renderTick;
	public TileEntityMiner() {

	}
	
	@Override
	public void ini(int MaxE, int drPerTick) {
		setMaxEnergy(energyPerTick()*10);
		setDrainPerTickConnection(energyPerTick());
	}
		@Override
		public void produce() {
			if(sleepTimer == 0){
				sleepTimer = 20*1;
				
				if(!worldObj.isRemote){
					
					for(int i = 1; i<TecDATA.MINER_DIG_Y;i++){
						if(worldObj.getBlock(xCoord, yCoord-i, zCoord) != null && worldObj.getBlock(xCoord, yCoord-i, zCoord) != Blocks.bedrock&& worldObj.getBlock(xCoord, yCoord-i, zCoord) != Blocks.air){
							if(worldObj.getBlock(xCoord, yCoord-i, zCoord).getBlockHardness(worldObj, xCoord, yCoord-i, zCoord)<5){
								//worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord+1, zCoord, worldObj.getBlock(xCoord, yCoord-i, zCoord).getDrops(worldObj, xCoord, yCoord-i, zCoord, 0, 0).get(0)));
								List<ItemStack> stackList = worldObj.getBlock(xCoord, yCoord-i, zCoord).getDrops(worldObj, xCoord, yCoord-i, zCoord, 0, 0);
								for(int x = 0; x < stackList.size(); x++){
									worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord+1, zCoord, stackList.get(x)));
								}
								
								Methods.BreakBlock(worldObj, xCoord, yCoord-i, zCoord, false);
								break;
							}
						}
					}
					
				}
				
				
				
			}else{
				sleepTimer--;
			}
			
		}
	
	@Override
	public int energyPerTick() {

		return TecDATA.MINER_PER_BLOCK;
	}
	
}
