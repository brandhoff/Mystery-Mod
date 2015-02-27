package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDeepBrick extends TileEntity implements IRGBcoloredTile{
private float red;
private float green;
private float blue;

	@Override
	public void updateEntity() {

		super.updateEntity();
	}

	@Override
	public float getRed() {

		return red;
	}

	@Override
	public float getGreen() {

		return green;
	}

	@Override
	public float getBlue() {

		return blue;
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
		public void writeToNBT(NBTTagCompound tag) {
		tag.setFloat("red", this.red);		
		tag.setFloat("green", this.green);
		tag.setFloat("blue", this.blue);

			super.writeToNBT(tag);
			
		}
	
		@Override
		public void readFromNBT(NBTTagCompound tag) {
		this.red = tag.getFloat("red");
		this.green = tag.getFloat("green");
		this.blue = tag.getFloat("blue");

			super.readFromNBT(tag);
			
		}

	public void addRed(){
		this.red+=0.01;

	}
	public void addGreen(){
		this.green+=0.01;
		
	}
	public void addBlue(){
		this.blue+=0.01;
		
	}
	
	public void setRed(float red) {
		this.red = red;
	}
	public void setBlue(float blue) {
		this.blue = blue;
	}
	public void setGreen(float green) {
		this.green = green;
	}
}
