package com.CiD.MysteryMod.TecEvolution.TileEntity;

import com.CiD.MysteryMod.Helper.Methods;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGravitomagnet extends TileEntity{
private int channel = 1;//TODO CHANGE IN GUI
private boolean sender;
private int reciverX,reciverY,reciverZ;
	public TileEntityGravitomagnet() {

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
			tag.setBoolean("sender", sender);
			tag.setInteger("channel", channel);
			
			tag.setInteger("reciverX", reciverX);
			tag.setInteger("reciverY", reciverY);
			tag.setInteger("reciverZ", reciverZ);

			super.writeToNBT(tag);
		}
	
		@Override
		public void readFromNBT(NBTTagCompound tag) {
			sender = tag.getBoolean("sender");
			channel = tag.getInteger("channel");
			
			reciverX = tag.getInteger("reciverX");
			reciverY = tag.getInteger("reciverY");
			reciverZ = tag.getInteger("reciverZ");

			super.readFromNBT(tag);
		}
	
	
		public void sendBlocks(TileEntityGravitomagnet reciver){
			if(worldObj.isRemote)
				return;
			if(reciver == null)
				return;
			
			if(reciver.isSender())
				return;
			
			if(reciver.getChannel() != this.getChannel())
				return;
			
			for(int x = -5; x < 10; x++){
				for(int y = -5; y < 10; y++){
					for(int z = -5; z < 10; z++){
						Block block = worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z);
						if(block != null && block != Blocks.air){
							worldObj.spawnEntityInWorld(new EntityItem(worldObj, reciver.xCoord, reciver.yCoord + 1, reciver.zCoord, new ItemStack(block, 1)));
							Methods.BreakBlock(worldObj, xCoord + x, yCoord + y, zCoord + z, false);
						}
					}	
				}
			}
		}
	
		
		public boolean isSender() {
			return sender;
		}
		
		public void setSender(boolean sender) {
			this.sender = sender;
		}
		
		public void setChannel(int channel) {
			this.channel = channel;
		}
		public int getChannel() {
			return channel;
		}
		
		public TileEntityGravitomagnet getReciver(){
			if(worldObj.getTileEntity(reciverX, reciverY, reciverZ) != null && worldObj.getTileEntity(reciverX, reciverY, reciverZ) instanceof TileEntityGravitomagnet){
				return (TileEntityGravitomagnet) worldObj.getTileEntity(reciverX, reciverY, reciverZ);
			}
			return null;
		}
		
		public void setReciverLoc(int x, int y, int z){
			this.reciverX = x;
			this.reciverY = y;
			this.reciverZ = z;
		}
		
		public void setReciverX(int reciverX) {
			this.reciverX = reciverX;
		}
		public void setReciverY(int reciverY) {
			this.reciverY = reciverY;
		}
		public void setReciverZ(int reciverZ) {
			this.reciverZ = reciverZ;
		}
}
