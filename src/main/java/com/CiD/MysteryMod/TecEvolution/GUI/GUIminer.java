package com.CiD.MysteryMod.TecEvolution.GUI;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Network.packet.server.UpdateMinerCoordsPacket;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMiner;

public class GUIminer extends GUIbaseMachine{
private int yDig;
private TileEntityMiner miner;
private EntityPlayer player;
private int ClientYdisplay;
	public GUIminer(EntityPlayer player, InventoryPlayer inventoryPlayer, TileEntityMiner tileEntity) {
		super(inventoryPlayer, tileEntity);
		yDig = tileEntity.getYdig();
		miner = tileEntity;
		this.player = player;
		ClientYdisplay = yDig;
	}

	@Override
	public void initGui() {
		super.initGui();
	    buttonList.add(new GuiButton(2, 20, 62, 90, 20, "+"));
	    buttonList.add(new GuiButton(3, 20, 82, 90, 20, "-"));
	    buttonList.add(new GuiButton(4, 20, 102, 90, 20, "+ 10"));
	    buttonList.add(new GuiButton(5, 20, 122, 90, 20, "- 10"));

	}
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
		fontRendererObj.drawString("Dig level: "+ClientYdisplay, guiLeft, guiTop - 50, 0x338234,true);
		fontRendererObj.drawString("Upgrade Tier: "+miner.getUpgradeTier(), guiLeft - 50, guiTop - 50, 0x338234,true);

	}
	
	@Override
		protected void actionPerformed(GuiButton button) {
			switch(button.id){
			case 2:{
				MysteryMain.packetPipeline.sendToServer(new UpdateMinerCoordsPacket(miner, miner.getYdig()+1));
				ClientYdisplay++;
				break;
			}
			case 3:{
				if(miner.getYdig()-1 > 0){
					MysteryMain.packetPipeline.sendToServer(new UpdateMinerCoordsPacket(miner, miner.getYdig()-1));
					ClientYdisplay--;
				}
				break;
			}	case 4:{
				MysteryMain.packetPipeline.sendToServer(new UpdateMinerCoordsPacket(miner, miner.getYdig()+10));
				ClientYdisplay = ClientYdisplay+10;
				break;
			}
			case 5:{
				if(miner.getYdig()-10 > 0){
					MysteryMain.packetPipeline.sendToServer(new UpdateMinerCoordsPacket(miner, miner.getYdig()-10));
					ClientYdisplay = ClientYdisplay - 10;
				}
				break;
			}
			case 1:{
				super.actionPerformed(button);
			}
			}
		}
	
}
