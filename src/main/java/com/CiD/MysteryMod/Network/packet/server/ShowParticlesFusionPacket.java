package com.CiD.MysteryMod.Network.packet.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.Network.packet.PacketUpdate;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFusionReactor;
	

public class ShowParticlesFusionPacket extends PacketUpdate{
	public TileEntityFusionReactor payload;
	public boolean show;
	
	public ShowParticlesFusionPacket(TileEntityFusionReactor tile, boolean show) {
		this.posX = tile.xCoord;
		this.posY = tile.yCoord;
		this.posZ = tile.zCoord;
		this.payload = tile;
		this.show = show;
	}
	
	public ShowParticlesFusionPacket() {

	 }
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(posX);
		buffer.writeShort(posY);
		buffer.writeInt(posZ);
		buffer.writeBoolean(show);

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		posX = buffer.readInt();
		posY = buffer.readShort();
		posZ = buffer.readInt();
		show = buffer.readBoolean();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TileEntityFusionReactor miner = (TileEntityFusionReactor) player.worldObj.getTileEntity(posX, posY, posZ);
		miner.setShowParticles(show);
	}
}