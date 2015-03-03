package com.CiD.MysteryMod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.CiD.MysteryMod.Network.PacketDispatcher;
import com.CiD.MysteryMod.Network.packet.SyncPlayerPropsPacket;
import com.CiD.MysteryMod.Network.packet.client.SyncPlayerPropsMessage;
import com.CiD.MysteryMod.Pages.PageInfo;
import com.CiD.MysteryMod.Player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickHandler
{

//
//@SubscribeEvent
//public void onPlayerTick(PlayerTickEvent ev){
//	if(!ev.player.worldObj.isRemote){
//		ExtendedPlayer exPlayer = ExtendedPlayer.get(ev.player);
//		exPlayer.addChiPerTick();
//		
//		}
//
//
//	}

}