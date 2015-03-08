package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;

public class TileEntityFactoryHull extends TileEntityFactoryBase {
    private static Map classToNameMap = new HashMap();

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

		return null;
	}
    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        this.xCoord = p_145839_1_.getInteger("x");
        this.yCoord = p_145839_1_.getInteger("y");
        this.zCoord = p_145839_1_.getInteger("z");
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
       
            p_145841_1_.setInteger("x", this.xCoord);
            p_145841_1_.setInteger("y", this.yCoord);
            p_145841_1_.setInteger("z", this.zCoord);
       
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
