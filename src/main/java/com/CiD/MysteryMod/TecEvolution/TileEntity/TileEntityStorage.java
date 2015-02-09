package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class TileEntityStorage extends TileEntityEnergy{

	
	public TileEntityStorage() {
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(getDrainPerTickConnection() >1000 || getDrainPerTickConnection() < 1000){
			setDrainPerTickConnection(1000);

		}
	}
	
	public void printEnergy(EntityPlayer player){
		player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"Energy: "+this.getMomEnergy()));

	}
	
	public boolean drainAmount(int amount){
		if(this.getMomEnergy() - amount > 0){
			setMomEnergy(getMomEnergy() - amount);
			return true;
		}
		else{
			return false;
		}
	}
}
