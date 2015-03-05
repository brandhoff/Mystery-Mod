package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;

public class TileEntityFactoryHull extends TileEntityFactoryBase {

	@Override
	public void setTileInMultiblockForm() {
		isMultiBlock = true;

	}

	@Override
	public void disableMultiBlock() {
		isMultiBlock = false;
		
	}

	@Override
	public void updateEntity() {

		super.updateEntity();
	}
	
	@Override
	public boolean isInterface() {

		return false;
	}
	@Override
	public MultiBlockType getType() {

		return MultiBlockType.FusionReactor;
	}
	
	
	@Override
	public float getRed() {
		return 0;
	}
	
	@Override
	public float getGreen() {
		return 0;
	} 
	
	@Override
	public float getBlue() {
		
		if(!isMultiBlock)
		return 0;
		
		return 1;
	}
	
	@Override
	public int getGUIid() {

		return GUIHandler.NO_GUI_ID;
	}

	public int getMultiBlockColor(){
		return  0xFF6666FF;
	}

	@Override
	public boolean isHull() {

		return true;
	}
	
}
