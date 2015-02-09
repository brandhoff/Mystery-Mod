package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public class TileEnergyProducer extends TileEntityEnergy{

	private int EnergyPerTick;
	
	public TileEnergyProducer() {

	}
	
	public void iniProducer(int MaxE, int perTick) {
		ini(MaxE, 0);
		setEnergyPerTick(perTick);
	}
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("EnergyPerTick", EnergyPerTick);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		EnergyPerTick = tag.getInteger("EnergyPerTick");
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(generateParam()){
		if(this.getMomEnergy()+getEnergyPerTick() <= getMaxEnergy()){
			setMomEnergy(getMomEnergy() + getEnergyPerTick());
		}
	 }
		
	}
	
	public void setEnergyPerTick(int energyPerTick) {
		EnergyPerTick = energyPerTick;
	}
	public int getEnergyPerTick() {
		return EnergyPerTick;
	}
	
	public boolean generateParam(){
		return true;
	}
	
	
	@Override
	public void drainPower() {
	
	}
	
}
