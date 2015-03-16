package com.CiD.MysteryMod.Player;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.common;
import com.CiD.MysteryMod.Network.packet.SyncPlayerPropsPacket;
import com.CiD.MysteryMod.Pages.PageInfo;

public class ExtendedPlayer implements IExtendedEntityProperties
{
//PAGE STUFF
	

	
private boolean knowPage_1;	
	
private boolean shouldRenderMinerbox;	
private int renderMinerX, renderMinerY, renderMinerZ;	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public final static String EXT_PROP_NAME = "ExtendedPlayer";
public static final int CHI_WATCHER = 20;

private final EntityPlayer player;


private int currentChi;
private int maxChi;
private int ChiPerSecond;
private int PlayerLevel;

public ExtendedPlayer(EntityPlayer player)
{
	this.player = player;
	this.currentChi = 0;
	this.maxChi = 500;
	this.PlayerLevel = 1;
	this.ChiPerSecond = 10;
	this.player.getDataWatcher().addObject(CHI_WATCHER, this.maxChi);
}

public static final void register(EntityPlayer player)
{

	player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
}

/**
* Returns ExtendedPlayer properties for player
* This method is for convenience only; it will make your code look nicer
*/
public static final ExtendedPlayer get(EntityPlayer player)
{
	return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
}

@Override
public void saveNBTData(NBTTagCompound compound)
{
	NBTTagCompound properties = new NBTTagCompound();
	properties.setInteger("PlayerLevel", this.PlayerLevel);
	properties.setInteger("ChiPerSecond", this.ChiPerSecond);

	properties.setInteger("MaxChi", this.maxChi);
	properties.setInteger("CurrentChi", this.player.getDataWatcher().getWatchableObjectInt(CHI_WATCHER));
	
	properties.setBoolean("knowPage_1", this.knowPage_1);
	
	
	compound.setTag(EXT_PROP_NAME, properties);
}

@Override
public void loadNBTData(NBTTagCompound compound)
{
	NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
	this.PlayerLevel = properties.getInteger("PlayerLevel");
	this.ChiPerSecond = properties.getInteger("ChiPerSecond");

	
	this.knowPage_1 = properties.getBoolean("knowPage_1");
	
	this.currentChi = properties.getInteger("CurrentChi");
	this.maxChi = properties.getInteger("MaxChi");
	this.player.getDataWatcher().updateObject(CHI_WATCHER, properties.getInteger("CurrentChi"));

	
}

private static final String getSaveKey(EntityPlayer player) {
	return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
	}

	public static final void loadProxyData(EntityPlayer player) {
	ExtendedPlayer playerData = ExtendedPlayer.get(player);
	NBTTagCompound savedData = common.getEntityData(getSaveKey(player));
	if (savedData != null) { playerData.loadNBTData(savedData); }
	
	MysteryMain.packetPipeline.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
	}
	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
	
		common.storeEntityData(getSaveKey(player), savedData);
		}

@Override
public void init(Entity entity, World world)
{
	
}

public final boolean knowsPage(int i){
	switch(i){
	default: return false;
	case 1: return this.knowPage_1;
	}
}
public final void setKnowsPage(int i, boolean b){
	switch(i){
	default: ;
	case 1: this.knowPage_1 = b;
	}
	MysteryMain.packetPipeline.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);

}


public final boolean consumeChi(int amount)
{
int Chi = this.player.getDataWatcher().getWatchableObjectInt(CHI_WATCHER);
if(Chi - amount > 0){
	this.player.getDataWatcher().updateObject(CHI_WATCHER, Chi-amount);
	return true;
		}else{
	return false;
	}
}

public final void replenishChi()
{
this.player.getDataWatcher().updateObject(CHI_WATCHER, this.maxChi);
}


public final int getChi()
{
return this.player.getDataWatcher().getWatchableObjectInt(CHI_WATCHER);
}


public final int getMaxChi(){
//	if(!player.worldObj.isRemote)
//	MysteryMain.packetPipeline.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);

	return this.maxChi;
	
}
public final void setChiPerSecond(int i){
	this.ChiPerSecond = i;
}
public final int getPlayerLevel(){
	return this.PlayerLevel;
}

public final int getChiPerSecond(){
	return this.ChiPerSecond;
}

public final void LevelUP(){
	PlayerLevel = getPlayerLevel() + 1;
	this.maxChi = getMaxChi() + PlayerLevel*10;
	this.ChiPerSecond = getChiPerSecond() + PlayerLevel*10;
}
public final void setCurrentChi(int amount)
{
this.player.getDataWatcher().updateObject(CHI_WATCHER, (amount < this.maxChi ? amount : this.maxChi));
}




public void addChiPerTick(){
	if(getChi() + this.ChiPerSecond <= getMaxChi()){
		this.player.getDataWatcher().updateObject(CHI_WATCHER, getChi()+this.ChiPerSecond);

	}
}

}