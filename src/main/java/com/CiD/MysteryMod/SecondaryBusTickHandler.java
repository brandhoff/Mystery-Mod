package com.CiD.MysteryMod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.Network.PacketDispatcher;
import com.CiD.MysteryMod.Network.packet.SyncPlayerPropsPacket;
import com.CiD.MysteryMod.Network.packet.client.SyncPlayerPropsMessage;
import com.CiD.MysteryMod.Player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SecondaryBusTickHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {


		if (event.entity instanceof EntityPlayer) {

			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
				ExtendedPlayer.register((EntityPlayer) event.entity);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
	if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{

	NBTTagCompound playerData = new NBTTagCompound();
	((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).saveNBTData(playerData);
	MysteryMain.proxy.storeEntityData(((EntityPlayer) event.entity).getCommandSenderName(), playerData);
	ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
			}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
	if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
	{		MysteryMain.packetPipeline.sendTo(new SyncPlayerPropsPacket((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);

	NBTTagCompound playerData = MysteryMain.proxy.getEntityData(((EntityPlayer) event.entity).getCommandSenderName());
	if (playerData != null) {
	((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).loadNBTData(playerData);
	}
	PacketDispatcher.sendTo(new SyncPlayerPropsMessage((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);
		



			}
		}
}
