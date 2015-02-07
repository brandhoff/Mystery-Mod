package com.CiD.MysteryMod.TecEvolution.TileEntity;

import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.CableNetwork.CableNetwork;
import com.CiD.MysteryMod.TileEntity.TileSwiftStone;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class TileEntityCable extends TileEntityEnergy{
	private int renderTick;
	private boolean sleeping;
	private boolean hasNetwork;
	private CableNetwork network;
	public TileEntityCable() {

	}
	
	@Override
	public void ini(int MaxE, int drPerTick) {
		setDrainPerTickConnection(100);
		setMaxEnergy(1000);
		setMomEnergy(0);
	
	}
	public CableNetwork getNetwork() {
		return network;
	}
	public void setNetwork(CableNetwork network) {
		this.network = network;
	}
	
	@Override
	public void updateEntity() {
		renderTick++;
		if(renderTick >= 360){
			renderTick = 0;
		}
		if(!this.sleeping){
		if(!worldObj.isRemote);
//		onCableUpdate();

		}else{
			setSleeping(false);
		}
		if(this.network != null){

			if(hasProducer()){
				boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
				for(int i = 0; i < connections.length; i++){
					if(connections[i]){
						switch(i){
						case TecHelper.SIDE_DOWN :{
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
							if(tl != null && tl instanceof TileEnergyProducer){
								getNetwork().drainFromProducer(tl);
							}
						
						}
						case TecHelper.SIDE_UP : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
							if(tl != null && tl instanceof TileEnergyProducer){
								getNetwork().drainFromProducer(tl);
							}

						}
						case TecHelper.SIDE_X : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
							if(tl != null && tl instanceof TileEnergyProducer) {
								getNetwork().drainFromProducer(tl);
							}

						}
						case TecHelper.SIDE_MX : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
							if(tl != null && tl instanceof TileEnergyProducer) {
								getNetwork().drainFromProducer(tl);
							}

						}
						case TecHelper.SIDE_Z : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
							if(tl != null && tl instanceof TileEnergyProducer) {
								getNetwork().drainFromProducer(tl);
							}

						}
						case TecHelper.SIDE_MZ : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
							if(tl != null && tl instanceof TileEnergyProducer) {
								getNetwork().drainFromProducer(tl);
							}

						}
					
					}
				}
		}
			
			}
			
			if(hasStorage()){

				
				boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
				for(int i = 0; i < connections.length; i++){
					if(connections[i]){
						switch(i){
						case TecHelper.SIDE_DOWN :{
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	
						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_UP]){
							getNetwork().drainFromStorage(tl);
						}
						
							}
						}
						case TecHelper.SIDE_UP : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
							
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null ){ 
								if(tl instanceof TileEntityStorage){ 

									if(output[TecHelper.SIDE_DOWN]){

								getNetwork().drainFromStorage(tl);
							
							}
							}}
						}}
						case TecHelper.SIDE_X : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
							
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MX]){
								getNetwork().drainFromStorage(tl);
							}
							}
						}
						case TecHelper.SIDE_MX : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_X]) {
								getNetwork().drainFromStorage(tl);
							}
							}
						}
						case TecHelper.SIDE_Z : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
							if(tl != null){


							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MZ]) {
								getNetwork().drainFromStorage(tl);
							}
							}
						}
						case TecHelper.SIDE_MZ : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
							
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_Z]) {
								getNetwork().drainFromStorage(tl);
							}
							}
						}
					
					}
				}
		}
				
			}
			
			
			
			
			
			
			
			
			
	
			if(hasStoreSpace()){
				boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);

				for(int i = 0; i < connections.length; i++){
					if(connections[i]){
						switch(i){
						case TecHelper.SIDE_DOWN :{
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	
						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_UP]){
							getNetwork().addToStorage(tl);
						}
						
							}
						}
						case TecHelper.SIDE_UP : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
							
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null ){ 
								if(tl instanceof TileEntityStorage){ 

									if(!output[TecHelper.SIDE_DOWN]){

										getNetwork().addToStorage(tl);

							
							}
							}}
						}}
						case TecHelper.SIDE_X : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
							
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_MX]){
								getNetwork().addToStorage(tl);

							}
							}
						}
						case TecHelper.SIDE_MX : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_X]) {
								getNetwork().addToStorage(tl);

							}
							}
						}
						case TecHelper.SIDE_Z : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
							if(tl != null){


							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_MZ]){
								getNetwork().addToStorage(tl);

							}
							}
						}
						case TecHelper.SIDE_MZ : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
							
							if(tl != null){

							boolean[] output = tl.getAllOutputSides();	

							if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_Z]){
								getNetwork().addToStorage(tl);

							}
							}
						}
					
					}
				}
		}
			}
			
			
			
			
			
			
			
			
			////////////////////////////////////////////////////////////////////
		}else{
			if(hasCable()){
				boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
				for(int i = 0; i < connections.length; i++){
					if(connections[i]){
						switch(i){
						case TecHelper.SIDE_DOWN :{
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
							if(tl != null && tl instanceof TileEntityCable){
								TileEntityCable cable = (TileEntityCable)tl;
								if(cable.getNetwork() != null && this.getNetwork() == null){
									setNetwork(cable.getNetwork());
								}
							}
						
						}
						case TecHelper.SIDE_UP : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
							if(tl != null && tl instanceof TileEntityCable){
								TileEntityCable cable = (TileEntityCable)tl;
								if(cable.getNetwork() != null && this.getNetwork() == null){
									setNetwork(cable.getNetwork());
								}
							}

						}
						case TecHelper.SIDE_X : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
							if(tl != null && tl instanceof TileEntityCable){
								TileEntityCable cable = (TileEntityCable)tl;
								if(cable.getNetwork() != null && this.getNetwork() == null){
									setNetwork(cable.getNetwork());
								}
							}

						}
						case TecHelper.SIDE_MX : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
							if(tl != null && tl instanceof TileEntityCable){
								TileEntityCable cable = (TileEntityCable)tl;
								if(cable.getNetwork() != null && this.getNetwork() == null){
									setNetwork(cable.getNetwork());
								}
							}

						}
						case TecHelper.SIDE_Z : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
							if(tl != null && tl instanceof TileEntityCable){
								TileEntityCable cable = (TileEntityCable)tl;
								if(cable.getNetwork() != null && this.getNetwork() == null){
									setNetwork(cable.getNetwork());
								}
							}

						}
						case TecHelper.SIDE_MZ : {
							TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
							if(tl != null && tl instanceof TileEntityCable){
								TileEntityCable cable = (TileEntityCable)tl;
								if(cable.getNetwork() != null && this.getNetwork() == null){
									setNetwork(cable.getNetwork());
								}
							}

						}
					
					}
				}
		}
			}
		}
		
		
//		if(hasProducer()){
//			tradeFromProducer();
//		}
//		if (hasStorage()){
//			tradeFromStorage();
//		}
//		
//			tradeFromCable();
//		
//		
	}
	
	public void onConnectionUpdate(){
		
	}
	
	
	@Override
	public void drainPower() {
		
	}
	
	public boolean isConnected(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
		for(int i = 0 ; i < connections.length; i++){
			if (connections[i]) {
				return true;
			}
		}
		return false;

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
					
					if(tl != null){

					boolean[] output = tl.getAllOutputSides();	
					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_UP]) return true;
					
						}
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null ){ 
							if(tl instanceof TileEntityStorage){ 

								if(output[TecHelper.SIDE_DOWN]){

							return true;
						
						}
						}}
					}}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MX]) return true;
						}
					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_X]) return true;
						}
					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null){


						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MZ]) return true;
						}
					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_Z]) return true;
						}
					}
				
				}
			}
	}
	return false;
}
	
	
	public boolean hasStoreSpace(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
					
					if(tl != null){

					boolean[] output = tl.getAllOutputSides();	
					if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_UP]) return true;
					
						}
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null ){ 
							if(tl instanceof TileEntityStorage){ 

								if(!output[TecHelper.SIDE_DOWN]){

							return true;
						
						}
						}}
					}}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_MX]) return true;
						}
					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_X]) return true;
						}
					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null){


						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_MZ]) return true;
						}
					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_Z]) return true;
						}
					}
				
				}
			}
	}
	return false;
}
	
	
	public boolean hasCable(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						if(tl != null && tl instanceof TileEntityCable) return true;
					
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl != null && tl instanceof TileEntityCable) return true;

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable) return true;

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable) return true;

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null && tl instanceof TileEntityCable) return true;

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl != null && tl instanceof TileEntityCable) return true;

					}
				
				}
			}
	}
	return false;
}

	
	public void onCableUpdate(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
		boolean skip = false;
		
		if(hasStoreSpace()){
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
					
					if(tl != null){

					boolean[] output = tl.getAllOutputSides();	
					if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_UP]){
						addToStorage(tl);
					}
					
						}
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null ){ 
							if(tl instanceof TileEntityStorage){ 

								if(!output[TecHelper.SIDE_DOWN]){

							addToStorage(tl);

						
						}
						}}
					}}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_MX]){
							addToStorage(tl);

						}
						}
					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_X]) {
							addToStorage(tl);

						}
						}
					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null){


						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_MZ]){
							addToStorage(tl);

						}
						}
					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && !output[TecHelper.SIDE_Z]){
							addToStorage(tl);

						}
						}
					}
				
				}
			}
	}
		}
		
		
		if(hasProducer() && !skip){
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						if(tl != null && tl instanceof TileEnergyProducer){
							drainFromProducer(tl);

						}
					
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl != null && tl instanceof TileEnergyProducer){
							drainFromProducer(tl);

						}

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEnergyProducer){
							drainFromProducer(tl);

						}

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEnergyProducer){
							drainFromProducer(tl);

						}

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null && tl instanceof TileEnergyProducer){
							drainFromProducer(tl);

						}

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl != null && tl instanceof TileEnergyProducer){
							drainFromProducer(tl);

						}

					}
				
				}
			}
	}
		}
		if(hasStorage()&& !skip){
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
					
					if(tl != null){

					boolean[] output = tl.getAllOutputSides();	
					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_UP]){
						drainFromStorage(tl);

					}
					
						}
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null ){ 
							if(tl instanceof TileEntityStorage){ 

								if(output[TecHelper.SIDE_DOWN]){

									drainFromStorage(tl);

						
						}
						}}
					}}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MX]){
							drainFromStorage(tl);

							}
						}
					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_X]){
							drainFromStorage(tl);

							}
						}
					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null){


						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MZ]){
							drainFromStorage(tl);

							}
						}
					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						
						if(tl != null){

						boolean[] output = tl.getAllOutputSides();	

						if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_Z]){
							drainFromStorage(tl);

							}
						}
					}
				
				}
			}
	}
		}
		if(hasCable()&& !skip){
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							drainFromCable(tl);
						}
					
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							drainFromCable(tl);

						}

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							drainFromCable(tl);

						}

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							drainFromCable(tl);

						}

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null && tl instanceof TileEntityCable){
							drainFromCable(tl);

						}

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl != null && tl instanceof TileEntityCable){
							drainFromCable(tl);

						}

					}
				
				}
			}
				}
		}
	}
	
	public boolean drainFromCable(TileEntityEnergy tl){

		TileEntityCable tile = (TileEntityCable) tl;
		if(tile.getMomEnergy() >= this.getDrainPerTickConnection()){
			if(this.getMaxEnergy() >= this.getMomEnergy() + this.getDrainPerTickConnection()){
				this.setMomEnergy(this.getMomEnergy() + this.getDrainPerTickConnection());
				tile.setMomEnergy(tile.getMomEnergy() - this.getDrainPerTickConnection());
//				tile.setSleeping(true);
				return true;

			}
		}else if(tile.getMomEnergy() < this.getDrainPerTickConnection() && tile.getMomEnergy() > 0){
			if(this.getMaxEnergy() >= this.getMomEnergy() + tile.getMomEnergy()){
				this.setMomEnergy(this.getMomEnergy() + tile.getMomEnergy());
				tile.setMomEnergy(0);
//				tile.setSleeping(true);

				return true;
			}
		}
		return false;

	}
	
	public boolean drainFromStorage(TileEntityEnergy tl){

		TileEntityStorage tile = (TileEntityStorage) tl;
		if(tile.getMomEnergy() >= this.getDrainPerTickConnection()){
			if(this.getMaxEnergy() <= this.getMomEnergy() + this.getDrainPerTickConnection()){
				this.setMomEnergy(this.getMomEnergy() + this.getDrainPerTickConnection());
				tile.setMomEnergy(tile.getMomEnergy() - this.getDrainPerTickConnection());
				return true;

			}
		}else if(tile.getMomEnergy() < this.getDrainPerTickConnection() && tile.getMomEnergy() > 0){
			if(this.getMaxEnergy() >= this.getMomEnergy() + tile.getMomEnergy()){
				this.setMomEnergy(this.getMomEnergy() + tile.getMomEnergy());
				tile.setMomEnergy(0);
				return true;
			}
		}
		return false;

	}
	
	public boolean drainFromProducer(TileEntityEnergy tl){

		TileEntityEnergy tile = (TileEntityEnergy) tl;
		if(tile.getMomEnergy() >= this.getDrainPerTickConnection()){
			if(this.getMaxEnergy() >= this.getMomEnergy() + this.getDrainPerTickConnection()){
				this.setMomEnergy(this.getMomEnergy() + this.getDrainPerTickConnection());
				tile.setMomEnergy(tile.getMomEnergy() - this.getDrainPerTickConnection());
				return true;

			}
		}else if(tile.getMomEnergy() < this.getDrainPerTickConnection() && tile.getMomEnergy() > 0){
			if(this.getMaxEnergy() >= this.getMomEnergy() + tile.getMomEnergy()){
				this.setMomEnergy(this.getMomEnergy() + tile.getMomEnergy());
				tile.setMomEnergy(0);
				return true;
			}
		}
		return false;

	}
	
	public boolean addToStorage(TileEntityEnergy tl){

		TileEntityStorage tile = (TileEntityStorage) tl;
		if(this.getMomEnergy() >= tile.getDrainPerTickConnection()){
			if(tile.getMaxEnergy() >= tile.getMomEnergy() + tile.getDrainPerTickConnection()){
				tile.setMomEnergy(tile.getMomEnergy() + tile.getDrainPerTickConnection());
				this.setMomEnergy(this.getMomEnergy() - tile.getDrainPerTickConnection());
				return true;

			}
		}else if(this.getMomEnergy() < tile.getDrainPerTickConnection() && this.getMomEnergy() > 0){
			if(tile.getMaxEnergy() >= tile.getMomEnergy() + this.getMomEnergy()){
				tile.setMomEnergy(tile.getMomEnergy() + this.getMomEnergy());
				this.setMomEnergy(0);
				return true;
			}
		}
		return false;

	}
	//OLD STUFF
//	public void tradeFromProducer(){
//		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
//		
//		for(int i = 0; i<connections.length; i++){
//			switch(i){
//			case TecHelper.SIDE_DOWN : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
//					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//						}
//					}
//				
//				}
//			}
//			case TecHelper.SIDE_MX : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
//					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//						}
//					}
//								}	
//						}
//			case TecHelper.SIDE_X : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
//					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//						}
//					}
//				}
//			}
//			case TecHelper.SIDE_MZ : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
//					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//						}
//					}
//				}
//			}
//			case TecHelper.SIDE_Z : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
//					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//						}
//					}
//				}
//			}
//			case TecHelper.SIDE_UP : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
//					if(tl != null && tl instanceof TileEnergyProducer &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//						}
//					}
//				}
//			}
//			}
//		}
//		
//		
//	}
//	
//	public void tradeFromStorage(){
//		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
//		if(this.isSleeping()){
//			setSleeping(false);
//		}else{
//		for(int i = 0; i<connections.length; i++){
//			switch(i){
//			case TecHelper.SIDE_DOWN : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_UP]&&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}}
//				
//				}
//			}
//			case TecHelper.SIDE_MX : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_X]&&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}}
//								}	
//						}
//			case TecHelper.SIDE_X : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MX]&&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}}
//					}
//				}
//			}
//			case TecHelper.SIDE_MZ : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage&& output[TecHelper.SIDE_Z] &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}}
//				}
//			}
//			case TecHelper.SIDE_Z : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage&& output[TecHelper.SIDE_MZ] &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}}
//				}
//			}
//			case TecHelper.SIDE_UP : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
//					
//					if(tl != null){
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage&& output[TecHelper.SIDE_DOWN] &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}
//				}}
//			}
//			}
//		}
//		
//		
//	}
//}
//	
//	
//	public void tradeFromCable(){
//		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
//		if(this.isSleeping()){
//			setSleeping(false);
//		}else{
//		for(int i = 0; i<connections.length; i++){
//			switch(i){
//			case TecHelper.SIDE_DOWN : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
//					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}
//				
//				}
//			}
//			case TecHelper.SIDE_MX : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
//					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}
//								}	
//						}
//			case TecHelper.SIDE_X : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
//					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}
//				}
//			}
//			case TecHelper.SIDE_MZ : {
//				if(connections[i] ){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
//					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}
//				}
//			}
//			case TecHelper.SIDE_Z : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
//					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//
//						}
//					}
//				}
//			}
//			case TecHelper.SIDE_UP : {
//				if(connections[i]){
//					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
//					if(tl != null && tl instanceof TileEntityCable &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
//						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
//							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
//							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
//							setSleeping(true);
//						}
//					}
//				}
//			}
//			}
//		}
//		
//		}
//	}
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
	public boolean isSleeping() {
		return sleeping;
	}
	public int getRenderTick() {
		return renderTick;
	}
	
	
}
