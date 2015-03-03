package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;


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
	

}
