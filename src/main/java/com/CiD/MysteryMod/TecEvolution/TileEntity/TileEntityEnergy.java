package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;

import cofh.api.energy.IEnergyHandler;

import com.CiD.MysteryMod.TecEvolution.TecHelper;

public class TileEntityEnergy extends TileEntity{

	private int MaxEnergy;
	
	private int MomEnergy;
	
	private int DrainPerTickConnection;

	private boolean[] sideConnected = new boolean[6];
	
	private boolean[] isOutputSide = new boolean[6];
	
	
	public TileEntityEnergy() {

	}
	
	public void ini(int MaxE, int drPerTick){
		setMaxEnergy(MaxE);
		setMomEnergy(0);
		setDrainPerTickConnection(drPerTick);
	}
	
	   @Override
	    public Packet getDescriptionPacket()
	    {
	     
	      NBTTagCompound tag = new NBTTagCompound();
	      this.writeToNBT(tag);
	      worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
	    }
	   
	
	   @Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		      this.readFromNBT(pkt.func_148857_g());
		      worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
		@Override
		public void readFromNBT(NBTTagCompound tag) {
			for(int i = 0; i < sideConnected.length; i++){
				sideConnected[i] = tag.getBoolean("sideConnected"+i);
			}
			for(int i = 0; i < isOutputSide.length; i++){
				isOutputSide[i] = tag.getBoolean("isOutputSide"+i);
			}
			
			setMaxEnergy(tag.getInteger("MaxEnergy"));
//			MaxEnergy = tag.getInteger("MaxEnergy");
			setMomEnergy(tag.getInteger("MomEnergy"));// = tag.getInteger("MomEnergy");
			setDrainPerTickConnection(tag.getInteger("PerTick"));
			super.readFromNBT(tag);

		}
	@Override
	public void writeToNBT(NBTTagCompound tag) {
			for(int i = 0; i < sideConnected.length; i++){
				tag.setBoolean("sideConnected"+i, sideConnected[i]);
			}
			for(int i = 0; i < isOutputSide.length; i++){
				tag.setBoolean("isOutputSide"+i, isOutputSide[i]);
			}
			
			tag.setInteger("MomEnergy", MomEnergy);
			tag.setInteger("MaxEnergy", MaxEnergy);
			tag.setInteger("PerTick", getDrainPerTickConnection());

			super.writeToNBT(tag);

		}
	

	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
	      worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

		this.markDirty();
		if(this instanceof IEnergyHandler){
			IEnergyHandler handler = (IEnergyHandler) this;
		}
	}
	

	public boolean[] getConnections(){
		return TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
	}
	
	
	/**
	 * 
	 * @param Side Use TecHelper for the correct Side
	 * @param output Whether it is an output
	 */
	public void setSideOutput(int Side, boolean output){
		this.isOutputSide[Side] = output; 
	}
	
	public boolean[] getAllOutputSides(){
		return this.isOutputSide;
	}
	
	
	public void setMaxEnergy(int maxEnergy) {
		MaxEnergy = maxEnergy;
	}
	
	public int getMaxEnergy() {
		return MaxEnergy;
	}
	
	public void setMomEnergy(int momEnergy) {
		MomEnergy = momEnergy;
	}
	
	public int getMomEnergy() {
		return MomEnergy;
	}
	
	public void setDrainPerTickConnection(int drainPerTickConnection) {
		DrainPerTickConnection = drainPerTickConnection;
	}
	public int getDrainPerTickConnection() {
		return DrainPerTickConnection;
	}
}
