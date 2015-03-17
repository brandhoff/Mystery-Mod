package com.CiD.MysteryMod.Network.packet.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

import com.CiD.MysteryMod.Helper.Methods;
import com.CiD.MysteryMod.Network.packet.PacketUpdate;
import com.CiD.MysteryMod.TecEvolution.RFbridge.TileEntityConverter;
	

public class ConverterInputPacket extends PacketUpdate{
	public TileEntityConverter payload;
	public int dir;
	public ConverterInputPacket(TileEntityConverter tile, ForgeDirection dir) {
		this.posX = tile.xCoord;
		this.posY = tile.yCoord;
		this.posZ = tile.zCoord;
		this.payload = tile;
		this.dir = Methods.ForgeDirectionToInterger(dir);
	}
	
	public ConverterInputPacket() {

	 }
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(posX);
		buffer.writeShort(posY);
		buffer.writeInt(posZ);
		buffer.writeInt(dir);

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		posX = buffer.readInt();
		posY = buffer.readShort();
		posZ = buffer.readInt();
		dir = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TileEntityConverter miner = (TileEntityConverter) player.worldObj.getTileEntity(posX, posY, posZ);
		miner.addToInput(Methods.IntergerToForgeDirection(dir));
	}
}