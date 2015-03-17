package com.CiD.MysteryMod.Network.packet.server;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

import com.CiD.MysteryMod.Helper.Methods;
import com.CiD.MysteryMod.Network.packet.PacketUpdate;
import com.CiD.MysteryMod.TecEvolution.RFbridge.TileEntityConverter;
	

public class ConverterResetPacket extends PacketUpdate{
	public TileEntityConverter payload;
	public ConverterResetPacket(TileEntityConverter tile) {
		this.posX = tile.xCoord;
		this.posY = tile.yCoord;
		this.posZ = tile.zCoord;
		this.payload = tile;
	}
	
	public ConverterResetPacket() {

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
		TileEntityConverter miner = (TileEntityConverter) player.worldObj.getTileEntity(posX, posY, posZ);
		miner.resetSettings();
	}
}