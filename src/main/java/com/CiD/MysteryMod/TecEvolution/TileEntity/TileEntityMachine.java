package com.CiD.MysteryMod.TecEvolution.TileEntity;

public class TileEntityMachine extends TileEntityStorage{

	@Override
	public void ini(int MaxE, int drPerTick) {
		setMaxEnergy(100000);
		setDrainPerTickConnection(1000);
	}
	public TileEntityMachine() {

	}
	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		
		if(Working()){
			produce();
			setMomEnergy(getMomEnergy() - energyPerTick());

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
