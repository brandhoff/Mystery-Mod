package com.CiD.MysteryMod.Network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
	

public class PacketTileSync extends PacketUpdate{
	public TileEntity payload;
	
	public PacketTileSync(TileEntity tile) {
		this.posX = tile.xCoord;
		this.posY = tile.yCoord;
		this.posZ = tile.zCoord;
		this.payload = tile;
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