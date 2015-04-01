package com.CiD.API.energy;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/** implement this class in your tileentity. Cables will concet and energy will be transfered **/
public interface IContainesEnergy {

	/** How much Energy is stored at the moment**/
	public int getEnergy();
	
	/** The max capacity of the TileEntity**/
	public int getMaxEnergy();
	
	/** Whether Cables can connect to the TileEntity WARNING NOT USED ATM**/
	public boolean canConnect(ForgeDirection from);
	
	/** Whether the Energy can be exchanged **/
	public boolean canDrain();
	
	/** Whether the tile creates or consumes Energy**/
	public boolean consumer();
	
	/** How much energy will be exchanged per Tick**/
	public int exchangePerTick();
	
	/** because transferring energy is handled outside of a TileEntity I need the instance of the TileEntity**/
	public TileEntity getInstance();

	/** adds energy calculations are already done and the amount can always be added
	 * IMPORTANT don't add the amount just override the existing with this **/
	public void setEnergy(int amount);
}
