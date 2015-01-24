package com.CiD.MysteryMod.TileEntity;

import java.util.List;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Helper.Location;

public class TileEntityGreenCrystal extends TileEntity{
	private boolean active;
	private int rendertick;
	public int soundTime;
	private List<Location> allBlocks;
	public TileEntityGreenCrystal() {

	}
	@Override
	public void readFromNBT(NBTTagCompound comp) {
		super.readFromNBT(comp);

		this.setActive(comp.getBoolean("CiD_active"));
	}
	@Override
	public void writeToNBT(NBTTagCompound comp) {
		super.writeToNBT(comp);
		
		comp.setBoolean("CiD_active", active);
		
	}
	public void addLocation(Location e){
		//screw it
//		if(e != null)
//		allBlocks.add(e);
//		System.err.println("added "+ e);
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		World world = this.getWorldObj();
		
		
		 if(active){
			world.playSoundEffect(this.xCoord, this.yCoord, zCoord, MysteryMain.MODID+":energy puls", 0.25F, 1F);
    	 Random rand = new Random();
    	 for(int i = 0; i <100; i++)
		 worldObj.spawnParticle("reddust", xCoord +0.5 + (rand.nextDouble() - 0.5D) * (double)0.5, (yCoord+1.5 + rand.nextDouble() * (double)30.5) - 0.25D, zCoord +0.5 + (rand.nextDouble() - 0.5D) * (double)0.5, -1.0D, 1.0D,0.0D);
		 
		rendertick++;
		if(rendertick == 180*5)
			rendertick = 0;
		if(allBlocks != null){
			
		if(!allBlocks.isEmpty()){
			for(int i = 0; i< allBlocks.size(); i++){
				Location loc = allBlocks.get(i);
				int x = loc.getX();
				int y = loc.getY();
				int z = loc.getZ();
		    	 for(int ii = 0; ii <100; ii++)
				 world.spawnParticle("reddust", x +0.5 + (rand.nextDouble() - 0.5D) * (double)0.5, (y+1.5 + rand.nextDouble() * (double)30.5) - 0.25D, z +0.5 + (rand.nextDouble() - 0.5D) * (double)0.5, -1.0D, 1.0D,0.0D);


			}
		}
		
		}
		 }
		 
		 
	}
	public boolean isActive(){
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getRendertick() {
		return rendertick;
	}
	public void playActiveSound(){
		World world = this.getWorldObj();

		if(soundTime == 0){
			 world.playSoundEffect(this.xCoord, this.yCoord, zCoord, MysteryMain.MODID+":energy puls", 0.25F, 1F);
			 soundTime++;
		}else{
			soundTime++;
			if(soundTime == 18*20){
				soundTime = 0;
			}
		}
	}
	
}
