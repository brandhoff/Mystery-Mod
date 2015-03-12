package com.CiD.MysteryMod.Network.packet;

import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PacketUpdate extends AbstractPacket {

	public int posX;
	public int posY;
	public int posZ;
	public ByteBuf stream;

	public PacketUpdate() {
	}

	public PacketUpdate(int posX, int posY, int posZ) {
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;

	}

	public PacketUpdate(int packetId) {
	
	}


	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(posX);
		buffer.writeShort(posY);
		buffer.writeInt(posZ);
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		posX = buffer.readInt();
		posY = buffer.readShort();
		posZ = buffer.readInt();
		
	}

	@Override
	public void handleClientSide(EntityPlayer player) {

		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

		
	}
}