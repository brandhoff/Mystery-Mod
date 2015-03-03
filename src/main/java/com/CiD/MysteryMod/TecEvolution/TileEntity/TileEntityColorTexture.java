package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityColorTexture extends TileEntity implements IcoloredTexture{
private int red = 0x00;
private int green = 0x00;
private int blue = 0x00;
private int color = 0xFF000000;
	@Override
	public void updateEntity() {

		super.updateEntity();
	}

	@Override
	public int getRed() {

		return red;
	}

	@Override
	public int getGreen() {

		return green;
	}

	@Override
	public int getBlue() {

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
		tag.setInteger("red", this.red);		
		tag.setInteger("green", this.green);
		tag.setInteger("blue", this.blue);
		tag.setInteger("color", this.color);

			super.writeToNBT(tag);
			
		}
	
		@Override
		public void readFromNBT(NBTTagCompound tag) {
		this.red = tag.getInteger("red");
		this.green = tag.getInteger("green");
		this.blue = tag.getInteger("blue");
		this.color = tag.getInteger("color");

			super.readFromNBT(tag);
			
		}

	public void addRed(){
		this.red++;

	}
	public void addGreen(){
		if(this.green < 0xFF)
		this.green++;
		
	}
	public void addBlue(){
		if(this.blue < 0xFF)
		this.blue++;
		
	}
	
	public int getRGBcolor(){
		return color;
	}
	
	public void setRed() {
		if(this.color == 0xFF00FFFF){
			color = 0xFFFFFFFF;
		}else if(this. color == 0xFF00FF00){
			color = 0xFFFFFF00;
		}else if(this.color == 0xFF0000FF){
			color = 0xFFFF00FF;
		}else{
			color = 0xFFFF0000;

		}
	}
	public void setBlue() {
		if(this.color == 0xFF00FFFF){
			color = 0xFFFFFFFF;
		}else if(this. color == 0xFF00FF00){
			color = 0xFFFFFF00;
		}else if(this.color == 0xFF0000FF){
			color = 0xFFFF00FF;
		}else{
			color = 0xFFFF0000;

		}
	}
	
	public void setGreen() {
		
		if(this.color == 0xFFFF00FF){
			color = 0xFFFFFFFF;
		}else if(this. color == 0xFFFF0000){
			color = 0xFFFFFF00;
		}else if(this.color == 0xFF0000FF){
			color = 0xFFFF00FF;
		}else{
			color = 0xFF00FF00;

		}
	}
}
