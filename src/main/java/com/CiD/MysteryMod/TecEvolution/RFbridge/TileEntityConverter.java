package com.CiD.MysteryMod.TecEvolution.RFbridge;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

public class TileEntityConverter extends TileEntityStorage implements IEnergyHandler{
	private List<ForgeDirection> outputs = new ArrayList<ForgeDirection>();
	private List<ForgeDirection> inputs = new ArrayList<ForgeDirection>();

	//TODO DUPE GLITCH
		public TileEntityConverter() {

		}
		
		@Override
		public void readFromNBT(NBTTagCompound nbt) {

			super.readFromNBT(nbt);
		}

		@Override
		public void writeToNBT(NBTTagCompound nbt) {

			super.writeToNBT(nbt);
		}
		
		@Override
		public void updateEntity() {
			if(getDrainPerTickConnection() >1000 || getDrainPerTickConnection() < 1000){
				setDrainPerTickConnection(1000);

			}
			outputs.add(ForgeDirection.UP);
			inputs.add(ForgeDirection.DOWN);

			super.updateEntity();
			
			
			for(ForgeDirection dir : outputs){
				if(inputs.contains(dir)){
					break;
				}
				if(worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY,zCoord+ dir.offsetZ) != null && worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ) instanceof IEnergyHandler){
					IEnergyHandler handler = (IEnergyHandler) worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
					
					handler.receiveEnergy(dir, this.extractEnergy(dir, 100000, false), false);
				}
			} 
			
				for(ForgeDirection dir : inputs){
					if(outputs.contains(dir)){
						break;
					}
			if(this.getMomEnergy() == this.getMaxEnergy()){
				break;
			}
				if(worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY,zCoord+ dir.offsetZ) != null && worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ) instanceof IEnergyHandler){
					IEnergyHandler handler = (IEnergyHandler) worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
					this.receiveEnergy(dir, handler.extractEnergy(dir, 100000, false), false);
				}
			} 
		
		}
		
		public boolean drainAmount(int amount){
			if(this.getMomEnergy() - amount >= 0){
				return true;
			}
			else{
				return false;
			}
		}

		@Override
		public boolean canConnectEnergy(ForgeDirection from) {
			if(outputs.contains(from))
			return true;
			
			return false;
		}

		@Override
		public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
			if(this.getMomEnergy() + maxReceive <= getMaxEnergy()){
				setMomEnergy(getMomEnergy() + maxReceive);
			}else{
				setMomEnergy(getMaxEnergy());
			}
			
			
			return 0;
		}

		@Override
		public
		int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
			if(simulate){
				return 0;
			}
			if(this.getMomEnergy() - maxExtract >= 0){
				
				setMomEnergy(getMomEnergy() - maxExtract);
				return maxExtract;

			}else{
				int temp_energy = getMomEnergy();
				setMomEnergy(0);
				return temp_energy;
			}
			

		}

		@Override
		public
		int getEnergyStored(ForgeDirection from) {

			return getMomEnergy();
		}

		@Override
		public
		int getMaxEnergyStored(ForgeDirection from) {

			return getMaxEnergy();
		}
}
