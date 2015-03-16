package com.CiD.MysteryMod.Network.packet.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.Network.packet.AbstractPacket;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityAtomicMiner;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class RenderMinerBoxPacket extends AbstractPacket
{
	private TileEntityAtomicMiner tile;
	private int posX;
	private int posY;
	private int posZ;
	public RenderMinerBoxPacket() {}

	public RenderMinerBoxPacket(TileEntityAtomicMiner tile, int x, int y, int z) {
		this.tile = tile;
	}

	

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buf) {
		buf.writeInt(posX);
        buf.writeInt(posY);
        buf.writeInt(posZ);		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buf) {
				posX = buf.readInt();
				posY = buf.readInt();
				posZ = buf.readInt();		
				
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		TileEntityAtomicMiner tile = (TileEntityAtomicMiner) player.worldObj.getTileEntity(posX, posY, posZ);
		tile.shouldRenderBox(true);
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

		
	}
	
}
