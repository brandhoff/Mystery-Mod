package com.CiD.MysteryMod.TecEvolution.CableNetwork;

import java.util.List;

import com.CiD.MysteryMod.Helper.Location;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

public class CableNetwork {
private int MAX_ENERGY = 100;
private int momEnergy;
private List<Location> allConnections;
private List<TileEntityStorage> allStorages;
private List<TileEnergyProducer> allProducer;
private List<TileEntityCable> allCableTiles;
private int drainPerTick = 100;
	public CableNetwork() {

	}
	
	
	public void onNetworkUpdate(){
	}
	
	
	
	
	
	public void addCable(TileEntityCable cable){
		allCableTiles.add(cable);
	}
	
	public void removeCable(TileEntityCable cable){
		allCableTiles.remove(cable);
	}
	
	public int getMomEnergy() {
		return momEnergy;
	}
	
	public void setMomEnergy(int momEnergy) {
		this.momEnergy = momEnergy;
	}
	
	public boolean addToStorage(TileEntityEnergy tl){
			
		TileEntityStorage tile = (TileEntityStorage) tl;
		if(this.getMomEnergy() >= tile.getDrainPerTickConnection()){
			if(tile.getMaxEnergy() >= tile.getMomEnergy() + tile.getDrainPerTickConnection()){
				tile.setMomEnergy(tile.getMomEnergy() + tile.getDrainPerTickConnection());
				this.setMomEnergy(this.getMomEnergy() - tile.getDrainPerTickConnection());
				tl.getWorldObj().markBlockForUpdate(tl.xCoord, tl.yCoord, tl.zCoord);
				return true;

			}
		}else if(this.getMomEnergy() < tile.getDrainPerTickConnection() && this.getMomEnergy() > 0){
			if(tile.getMaxEnergy() >= tile.getMomEnergy() + this.getMomEnergy()){
				tile.setMomEnergy(tile.getMomEnergy() + this.getMomEnergy());
				this.setMomEnergy(0);
				tl.getWorldObj().markBlockForUpdate(tl.xCoord, tl.yCoord, tl.zCoord);

				return true;
			}
		}
		return false;

	}
	public boolean drainFromStorage(TileEntityEnergy tl){

		TileEntityStorage tile = (TileEntityStorage) tl;
		if(tile.getMomEnergy() >= this.getDrainPerTick()){
			if(this.getMAX_ENERGY() <= this.getMomEnergy() + this.getDrainPerTick()){
				this.setMomEnergy(this.getMomEnergy() + this.getDrainPerTick());
				tile.setMomEnergy(tile.getMomEnergy() - this.getDrainPerTick());
				return true;

			}
		}else if(tile.getMomEnergy() < this.getDrainPerTick() && tile.getMomEnergy() > 0){
			if(this.getMAX_ENERGY() >= this.getMomEnergy() + tile.getMomEnergy()){
				this.setMomEnergy(this.getMomEnergy() + tile.getMomEnergy());
				tile.setMomEnergy(0);
				return true;
			}
		}
		return false;

	}
	
	public boolean drainFromProducer(TileEntityEnergy tl){

		TileEntityEnergy tile = (TileEntityEnergy) tl;
		if(tile.getMomEnergy() >= this.getDrainPerTick()){
			if(this.getMAX_ENERGY() >= this.getMomEnergy() + this.getDrainPerTick()){
				this.setMomEnergy(this.getMomEnergy() + this.getDrainPerTick());
				tile.setMomEnergy(tile.getMomEnergy() - this.getDrainPerTick());
				return true;

			}
		}else if(tile.getMomEnergy() < this.getDrainPerTick() && tile.getMomEnergy() > 0){
			if(this.getMAX_ENERGY() >= this.getMomEnergy() + tile.getMomEnergy()){
				this.setMomEnergy(this.getMomEnergy() + tile.getMomEnergy());
				tile.setMomEnergy(0);
				return true;
			}
		}
		return false;

	}
	
	public int getMAX_ENERGY() {
		return MAX_ENERGY;
	}
	public int getDrainPerTick() {
		return drainPerTick;
	}
}
