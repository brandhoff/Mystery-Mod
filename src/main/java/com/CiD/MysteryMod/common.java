package com.CiD.MysteryMod;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;



public class common {
	/** Used to store IExtendedEntityProperties data temporarily between player death and respawn */
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	public int sphereID() {
		return 0;
		
	}
	public void registerRenderThings() {

		
	}
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
	extendedEntityData.put(name, compound);
	}

	/**
	* Removes the compound from the map and returns the NBT tag stored for name or null if none exists
	*/
	public static NBTTagCompound getEntityData(String name)
	{
	return extendedEntityData.remove(name);
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
	public boolean rightplayer(EntityPlayer player){
		return false;
		}
	public ModelBiped getArmorModel(int id){
		return null;
		}
//	public class CommonProxy
//	{
//		
//	}
	public void registerHandlers() {

	}
	
	public void zoominsniper(ItemStack stack,EntityPlayer player) {
		
	}
	public void registerPackets() { }
public void zoommg(EntityPlayer player) {
		
	}
public void resetSavedFOV() {
	
}
public void spawngasFX(World world, double x, double y, double z){}
}
