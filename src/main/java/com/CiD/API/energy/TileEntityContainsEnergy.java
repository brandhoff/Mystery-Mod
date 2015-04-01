package com.CiD.API.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/** This is an example of how to use IContainsEnergy if you want to you can extend this class**/
public class TileEntityContainsEnergy extends TileEntity implements IContainesEnergy{

	/** the momentary amount of energy**/
	protected int energy;
	
	/** max capacity of energy**/
	protected static int max_energy = 10000;
	
	protected int exchange_per_tick = 100;
	
	public TileEntityContainsEnergy() {

	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {

		super.writeToNBT(tag);
		
		tag.setInteger("energy", energy);
		tag.setInteger("exchange_per_tick", exchange_per_tick);
		tag.setInteger("max_energy", max_energy);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {

		super.readFromNBT(tag);
		
		energy = tag.getInteger("energy");
		exchange_per_tick = tag.getInteger("exchange_per_tick");
		max_energy = tag.getInteger("max_energy");


	}
	
	
	@Override
	public int getEnergy() {

		return energy;
	}

	@Override
	public int getMaxEnergy() {

		return max_energy;
	}

	@Override
	public boolean canConnect(ForgeDirection from) {

		return true;
	}

	@Override
	public boolean canDrain() {

		return true;
	}

	@Override
	public boolean consumer() {

		return true;
	}

	@Override
	public int exchangePerTick() {

		return exchange_per_tick;
	}


	@Override
	public TileEntity getInstance() {

		return (TileEntity) this;
	}


	@Override
	public void setEnergy(int amount) {
		this.energy = amount;
	}

}
