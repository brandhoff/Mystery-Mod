package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;

public class TileEntityFusionReactor extends TileEntityFactoryBase implements ISidedInventory, IRGBcoloredTile{

	@Override
	public void setTileInMultiblockForm() {
		isMultiBlock = true;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {

		return true;
	}
	
	@Override
	public void disableMultiBlock() {

		isMultiBlock = false;
	}
	
	@Override
	public MultiBlockType getType() {
		
		return MultiBlockType.FusionReactor;
	}
	@Override
	public boolean isInterface() {

		return true;
	}

	@Override
	public int getGUIid() {

		return GUIHandler.FUISON_REACTOR_GUI_ID;
	}

	@Override
	public boolean isHull() {

		return false;
	}

}
