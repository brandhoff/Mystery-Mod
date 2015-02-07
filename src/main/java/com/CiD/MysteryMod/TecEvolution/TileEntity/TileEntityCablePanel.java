package com.CiD.MysteryMod.TecEvolution.TileEntity;

import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.CableNetwork.CableNetwork;

import net.minecraft.tileentity.TileEntity;

public class TileEntityCablePanel extends TileEntityEnergy{
private CableNetwork nt;
	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
	if(nt != null){
		nt.onNetworkUpdate();
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
							}
						}
					
					}
					case TecHelper.SIDE_UP : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
							}
						}

					}
					case TecHelper.SIDE_X : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
							}
						}

					}
					case TecHelper.SIDE_MX : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
							}
						}

					}
					case TecHelper.SIDE_Z : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
							}
						}

					}
					case TecHelper.SIDE_MZ : {
						TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
						if(tl != null && tl instanceof TileEntityCable){
							TileEntityCable cable = (TileEntityCable)tl;
							if(cable.getNetwork() == null && this.getNetwork() != null){
								cable.setNetwork(getNetwork());
							}
						}

					}
				
				}
			}
	}
		}
	}else{
		this.setNetwork(new CableNetwork());
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
