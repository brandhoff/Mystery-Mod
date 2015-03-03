package com.CiD.MysteryMod.Network.packet.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityAtomicMiner;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class RenderMinerBoxPacket implements IMessage
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
	public void fromBytes(ByteBuf buf) {
		  	posX = buf.readInt();
			posY = buf.readInt();
			posZ = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(posX);
        buf.writeInt(posY);
        buf.writeInt(posZ);
	}

	public static class Handler extends AbstractClientMessageHandler<RenderMinerBoxPacket> {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage handleClientMessage(EntityPlayer player, RenderMinerBoxPacket message, MessageContext ctx) {
		    TileEntity tile = player.worldObj.getTileEntity(message.posX, message.posY, message.posZ);
	        if(tile instanceof TileEntityAtomicMiner) {
	        	((TileEntityAtomicMiner) tile).RenderMinerBox();
	        }
			return null;
		}

	}
	
}
