package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import com.CiD.API.color.IRGBcoloredTile;
import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;


public class TileEntityMultiBlockCraftingStation extends TileEntityFactoryBase implements IRGBcoloredTile{

	@Override
	public void setTileInMultiblockForm() {
		isMultiBlock = true;
		
	}

	@Override
	public void disableMultiBlock() {

		isMultiBlock = false;

	}

	@Override
	public MultiBlockType getType() {

		return MultiBlockType.CraftingStation;
	}

	@Override
	public boolean isInterface() {

		return true;
	}

	@Override
	public int getGUIid() {

		return GUIHandler.CRAFTING_STATION_GUI_ID;
	}

	@Override
	public boolean isHull() {

		return false;
	}
	

}
