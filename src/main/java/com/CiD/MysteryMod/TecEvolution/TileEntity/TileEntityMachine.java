package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityMachine extends TileEntityStorage{
protected boolean whileWorking;
	@Override
	public void ini(int MaxE, int drPerTick) {
		setMaxEnergy(100000);
		setDrainPerTickConnection(1000);
	}
	public TileEntityMachine() {

	}
	
	@Override
		public void writeToNBT(NBTTagCompound tag) {
			super.writeToNBT(tag);
			tag.setBoolean("whileWorking", whileWorking);
		}
	
	@Override
		public void readFromNBT(NBTTagCompound tag) {
			super.readFromNBT(tag);
			whileWorking = tag.getBoolean("whileWorking");
		}
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(whileWorking){
			setMomEnergy(getMomEnergy() - energyPerTick());
			OnProduceTick();
		}
		if(Working()){
			produce();

		}
		
		
	}
	
	public int energyPerTick(){
		return 0;
	}
	
	
	public boolean Working(){
		if(drainAmount(energyPerTick())){
			whileWorking = true;
			return true;
		}
		whileWorking = false;

		return false;
	}
	
	/** OVERRIDE THIS IF YOU WANT TO DO A SINGEL ACTION NOT FOR 
	 * BURNING STUFF etc*/
	public void produce(){
		
	}
	/** OVERRIDE THIS FOR TICK ACTION ON WORKING**/
	public void OnProduceTick(){
		
	}
}
