package com.CiD.MysteryMod.TecEvolution.Factory.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.ITileMultiBlock;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.MultiBlockType;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;

public abstract class TileEntityFactoryBase extends TileEntityEnergy implements ITileMultiBlock, ISidedInventory
, IRGBcoloredTile{
	protected boolean hasInterface;
	protected boolean hasInventory;
	protected boolean hasEnergy;
	protected boolean isMultiBlock;
	protected ItemStack[] invStacks = new ItemStack[6];

	private MultiBlockType type;
	private boolean UpdateNeeded;
	private int updateIdle = 20;
	
	public TileEntityFactoryBase() {

	}
	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
	if(!isHull()){
		updateIdle--;
		if(updateIdle == 0){
			UpdateNeeded = true;
			updateIdle = 20;
		}
		if(UpdateNeeded){
		
			if(isInterface()){
				MultiBlockType.hasNeededBlock(getType(), worldObj, xCoord, yCoord, zCoord);
			}
			
			
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		UpdateNeeded = false;
		
	}
}
	@Override
	public float getRed() {
		if(isMultiBlock){
			return 0;
		}else
		return 1;
	}
	
	@Override
	public float getGreen() {
		if(isMultiBlock){
			return 1;
		}else
		return 0;
	} 
	
	
	public void setUpdateNeeded(boolean updateNeeded) {
		UpdateNeeded = updateNeeded;
	}
	
	public boolean isUpdateNeeded() {
		return UpdateNeeded;
	}
	
	
	 /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory(){
        return invStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int slot){
        return invStacks[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
    public ItemStack decrStackSize(int slot, int decreaseAmount){
        if(invStacks[slot] != null) {
            ItemStack itemstack;

            if(invStacks[slot].stackSize <= decreaseAmount) {
                itemstack = invStacks[slot];
                setInventorySlotContents(slot, null);
                markDirty();
                return itemstack;
            } else {
                itemstack = invStacks[slot].splitStack(decreaseAmount);

                if(invStacks[slot].stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }

                markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot){
        if(invStacks[slot] != null) {
            ItemStack itemstack = invStacks[slot];
            invStacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack){
        invStacks[slot] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }


	@Override
	public String getInventoryName() {

		return "base_generic_inventory_multiblock";
	}

	@Override
	public boolean hasCustomInventoryName() {

		return true;
	}

	@Override
	public int getInventoryStackLimit() {

		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {

		return false;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {

		return new int[]{0};
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {

		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {
		return true;
	}
	
	@Override
	public float getBlue() {

		return 0;
	}
	
	public MultiBlockType getType() {
		return type;
	}
	public void setType(MultiBlockType type) {
		this.type = type;
	}
	
	public boolean isMultiBlock() {
		return isMultiBlock;
	}
}
