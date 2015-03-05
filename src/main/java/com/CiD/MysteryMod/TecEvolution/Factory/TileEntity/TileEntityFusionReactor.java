package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;

public class TileEntityFusionReactor extends TileEntityFactoryBase implements IRGBcoloredTile{

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
		
		return MultiBlockType.FusionReactor;
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
