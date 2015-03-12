package com.CiD.MysteryMod.Network.packet.server;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Network.packet.server.AbstractServerMessageHandler;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class UpdatePageInGUIpacket implements IMessage {
	private int page;

	// The basic, no-argument constructor MUST be included to use the new automated handling
	public UpdatePageInGUIpacket() {}

	// if there are any class fields, be sure to provide a constructor that allows
	// for them to be initialized, and use that constructor when sending the packet
	public UpdatePageInGUIpacket(int page) {
		this.page = page;
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		page = buffer.readInt();
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(page);
	}
	
	public static class Handler extends AbstractServerMessageHandler<UpdatePageInGUIpacket> {
		@Override
		public IMessage handleServerMessage(EntityPlayer player, UpdatePageInGUIpacket message, MessageContext ctx) {
			
			return null;
		}
	}

}
