package com.CiD.MysteryMod.Network.packet.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.Network.packet.PacketUpdate;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMiner;
	

public class UpdateMinerTOclient extends PacketUpdate{
	public TileEntityMiner payload;
	public int digY;
	public UpdateMinerTOclient(TileEntityMiner tile, int digY) {
		this.posX = tile.xCoord;
		this.posY = tile.yCoord;
		this.posZ = tile.zCoord;
		this.payload = tile;
		this.digY = digY;
	}
	
	public UpdateMinerTOclient() {

	 }
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(posX);
		buffer.writeShort(posY);
		buffer.writeInt(posZ);
		buffer.writeInt(digY);

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		posX = buffer.readInt();
		posY = buffer.readShort();
		posZ = buffer.readInt();
		digY = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		TileEntityMiner miner = (TileEntityMiner) player.worldObj.getTileEntity(posX, posY, posZ);
		miner.setYdig(digY);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
	
	}
}