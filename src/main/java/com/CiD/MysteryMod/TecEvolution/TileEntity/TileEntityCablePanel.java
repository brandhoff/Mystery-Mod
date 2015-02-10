package com.CiD.MysteryMod.TecEvolution.TileEntity;

import java.util.List;

import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.CableNetwork.CableNetwork;

import net.minecraft.tileentity.TileEntity;

public class TileEntityCablePanel extends TileEntityEnergy{
private CableNetwork nt;
private int renderTick;
	
		public void onRemove(){
					
			CableNetwork network = getNetwork();
			network.setDead(true);
			List<TileEntityCable> lcabel = network.getAllCableTiles();
			int cx = lcabel.size();
			for(int i = cx-1; i > -1; i--){
				TileEntityCable cable = lcabel.get(i);

				cable.setSleeping(true);
				cable.setNetwork(null);
				

			}
		}


		public int getRenderTick() {
			return renderTick;
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
		
	@Override
	public void updateEntity() {
		super.updateEntity();
		renderTick++;
		if(renderTick >= 360){
			renderTick = 0;
		}
		
		
	if(getNetwork() != null){
		if(hasCable()){
			boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
			for(int i = 0; i < connections.length; i++){
				if(connections[i]){
					switch(i){
					case TecHelper.SIDE_DOWN :{
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
								getNetwork().addCable(cable);
							}
						}
					
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
								getNetwork().addCable(cable);

							}
						}

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
								getNetwork().addCable(cable);

							}
						}

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
								getNetwork().addCable(cable);

							}
						}

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
								getNetwork().addCable(cable);

							}
						}

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
								getNetwork().addCable(cable);

							}
						}

					}
				
				}
			}
	}
		}
		getNetwork().onNetworkUpdate();

	}else{
		this.setNetwork(new CableNetwork(this));
	}
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

	
	
	
	
	
	public void setNetwork(CableNetwork nt) {
		this.nt = nt;
	}
	
	public CableNetwork getNetwork() {
		return nt;
	}
}
