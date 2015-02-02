package com.CiD.MysteryMod.TecEvolution.TileEntity;

import com.CiD.MysteryMod.TecEvolution.TecHelper;

public class TileEntityCable extends TileEntityEnergy{
//TODO vom storage drainen laeft net
	
	private boolean sleeping;
	public TileEntityCable() {

	}
	
	@Override
	public void ini(int MaxE, int drPerTick) {
		setDrainPerTickConnection(100);
		setMaxEnergy(1000);
		setMomEnergy(0);
	}
	
	
	@Override
	public void updateEntity() {
//		super.updateEntity();
	
		if(hasProducer()){
			tradeFromProducer();
		}else if (hasStorage()){
			tradeFromStorage();
		}else{
		
			tradeFromCable();
		}
		
	}
	
	
	@Override
	public void drainPower() {
		
	}
	
	
	
	
	public boolean hasProducer(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						if(tl != null && tl instanceof TileEnergyProducer) return true;
					
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl != null && tl instanceof TileEnergyProducer) return true;

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEnergyProducer) return true;

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEnergyProducer) return true;

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null && tl instanceof TileEnergyProducer) return true;

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl != null && tl instanceof TileEnergyProducer) return true;

					}
				
				}
			}
	}
	return false;
}
	
	public boolean hasStorage(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	
					if(tl != null && tl instanceof TileEntityStorage && output[i]) return true;
					
					}
					case TecHelper.SIDE_UP : {
						
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl == null) break;

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[i]) return true;

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl == null) break;

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[i]) return true;

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl == null) break;
						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[i]) return true;

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl == null) break;

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[i]) return true;

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl == null) break;

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[i]) return true;

					}
				
				}
			}
	}
	return false;
}
	public void tradeFromProducer(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
		
		for(int i = 0; i<connections.length; i++){
			switch(i){
			case TecHelper.SIDE_DOWN : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				
				}
			}
			case TecHelper.SIDE_MX : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
								}	
						}
			case TecHelper.SIDE_X : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_MZ : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_Z : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_UP : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			}
		}
		
		
	}
	
	public void tradeFromStorage(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
		
		for(int i = 0; i<connections.length; i++){
			switch(i){
			case TecHelper.SIDE_DOWN : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	

					if(tl != null && tl instanceof TileEntityStorage && output[i]&&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				
				}
			}
			case TecHelper.SIDE_MX : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	

					if(tl != null && tl instanceof TileEntityStorage && output[i]&&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
								}	
						}
			case TecHelper.SIDE_X : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	

					if(tl != null && tl instanceof TileEntityStorage && output[i]&&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_MZ : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	

					if(tl != null && tl instanceof TileEntityStorage&& output[i] &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_Z : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	

					if(tl != null && tl instanceof TileEntityStorage&& output[i] &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_UP : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
					if(tl == null) break;

					boolean[] output = tl.getAllOutputSides();	

					if(tl != null && tl instanceof TileEntityStorage&& output[i] &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			}
		}
		
		
	}
	
	
	
	public void tradeFromCable(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
		if(this.isSleeping()){
			setSleeping(false);
		}else{
		for(int i = 0; i<connections.length; i++){
			switch(i){
			case TecHelper.SIDE_DOWN : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
							setSleeping(true);

						}
					}
				
				}
			}
			case TecHelper.SIDE_MX : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
							setSleeping(true);

						}
					}
								}	
						}
			case TecHelper.SIDE_X : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
							setSleeping(true);

						}
					}
				}
			}
			case TecHelper.SIDE_MZ : {
				if(connections[i] ){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
							setSleeping(true);

						}
					}
				}
			}
			case TecHelper.SIDE_Z : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
							setSleeping(true);

						}
					}
				}
			}
			case TecHelper.SIDE_UP : {
				if(connections[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
							setSleeping(true);
						}
					}
				}
			}
			}
		}
		
		}
	}
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
	public boolean isSleeping() {
		return sleeping;
	}
	
	
	
}
