package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;

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
	      
	        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
	    }
	   
	
	   @Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		      this.readFromNBT(pkt.func_148857_g());
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
			for(int i = 0; i < sideConnected.length; i++){
				tag.setBoolean("sideConnected"+i, sideConnected[i]);
			}
			for(int i = 0; i < isOutputSide.length; i++){
				tag.setBoolean("isOutputSide"+i, isOutputSide[i]);
			}
			
			tag.setInteger("MomEnergy", MomEnergy);
			tag.setInteger("MaxEnergy", MaxEnergy);

		}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		for(int i = 0; i < sideConnected.length; i++){
			sideConnected[i] = tag.getBoolean("sideConnected"+i);
		}
		for(int i = 0; i < isOutputSide.length; i++){
			isOutputSide[i] = tag.getBoolean("isOutputSide"+i);
		}
		
		MaxEnergy = tag.getInteger("MaxEnergy");
		MomEnergy = tag.getInteger("MomEnergy");

	}
	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		drainPower();
	
		this.markDirty();
	}
	
	
	public void drainPower(){
		boolean[] connections = TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
		
		for(int i = 0; i<connections.length; i++){
			switch(i){
			case TecHelper.SIDE_DOWN : {
				if(connections[i] &&!isOutputSide[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
					if(tl != null && tl instanceof TileEntityEnergy &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				
				}
			}
			case TecHelper.SIDE_MX : {
				if(connections[i] &&!isOutputSide[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEntityEnergy &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
								}	
						}
			case TecHelper.SIDE_X : {
				if(connections[i] &&!isOutputSide[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEntityEnergy &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_MZ : {
				if(connections[i] &&!isOutputSide[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
					if(tl != null && tl instanceof TileEntityEnergy &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_Z : {
				if(connections[i] &&!isOutputSide[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
					if(tl != null && tl instanceof TileEntityEnergy &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
						if(this.getMomEnergy() + this.getDrainPerTickConnection() <= this.getMaxEnergy() ){
							tl.setMomEnergy(tl.getMomEnergy() - this.getDrainPerTickConnection());
							this.setMomEnergy(getMomEnergy() + getDrainPerTickConnection());
						}
					}
				}
			}
			case TecHelper.SIDE_UP : {
				if(connections[i] &&!isOutputSide[i]){
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
					if(tl != null && tl instanceof TileEntityEnergy &&tl.getMomEnergy() - this.getDrainPerTickConnection() >= 0){
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
	
	public boolean[] getConnections(){
		return TecHelper.checkConnections(worldObj, xCoord, yCoord, zCoord);
	}
	
	
	/**
	 * 
	 * @param Side Use TecHelper for the correct Side
	 * @param output Wheater it is output
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
