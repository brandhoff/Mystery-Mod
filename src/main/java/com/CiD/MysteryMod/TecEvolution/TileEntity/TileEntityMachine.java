package com.CiD.MysteryMod.TecEvolution.TileEntity;

public class TileEntityMachine extends TileEntityStorage{

	
	public TileEntityMachine() {

	}
	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		
		if(Working()){
			produce();
		}
		
		
	}
	
	public int energyPerTick(){
		return 0;
	}
	
	public boolean Working(){
		if(drainAmount(energyPerTick())){
			return true;
		}
		return false;
	}
	
	
	public void produce(){
		
	}
}
