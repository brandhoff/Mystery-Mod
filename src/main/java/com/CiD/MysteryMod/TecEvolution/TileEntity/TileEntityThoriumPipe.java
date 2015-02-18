package com.CiD.MysteryMod.TecEvolution.TileEntity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityThoriumPipe extends TileEntity implements ISidedInventory{
	private ItemStack[] invStacks = new ItemStack[6];

	public TileEntityThoriumPipe() {

	}
	@Override
	public void updateEntity() {

		super.updateEntity();
		addToInventory();
	}
	   
	
	public void addToInventory(){
	if(this.getStackInSlot(0) == null){
		TileEntity tileX = worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		TileEntity tileY = worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
		TileEntity tileMX = worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
		TileEntity tileMY = worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		TileEntity tileZ = worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		TileEntity tileMZ = worldObj.getTileEntity(xCoord, yCoord, zCoord-1);

		if(tileX != null && tileX instanceof ISidedInventory && this.getStackInSlot(0) == null){
			ISidedInventory inv = (ISidedInventory) tileX;
			int slots[] = inv.getAccessibleSlotsFromSide(4);
			for(int i = 0; i < slots.length; i++){
				if(inv.getStackInSlot(i) != null){
					ItemStack tempStack = inv.getStackInSlot(i).copy();
					setInventorySlotContents(0, tempStack);
					inv.decrStackSize(i, tempStack.stackSize);
					break;
				}
			}
		}
		
		if(tileMX != null && tileMX instanceof ISidedInventory && this.getStackInSlot(0) == null){
			ISidedInventory inv = (ISidedInventory) tileMX;
			int slots[] = inv.getAccessibleSlotsFromSide(4);
			for(int i = 0; i < slots.length; i++){
				if(inv.getStackInSlot(i) != null){
					ItemStack tempStack = inv.getStackInSlot(i).copy();
					setInventorySlotContents(0, tempStack);
					inv.decrStackSize(i, tempStack.stackSize);
					break;
				}
			}
		}
		
		if(tileZ != null && tileZ instanceof ISidedInventory && this.getStackInSlot(0) == null){
			ISidedInventory inv = (ISidedInventory) tileZ;
			int slots[] = inv.getAccessibleSlotsFromSide(4);
			for(int i = 0; i < slots.length; i++){
				if(inv.getStackInSlot(i) != null){
					ItemStack tempStack = inv.getStackInSlot(i).copy();
					setInventorySlotContents(0, tempStack);
					inv.decrStackSize(i, tempStack.stackSize);
					break;
				}
			}
		}
		
		if(tileMZ != null && tileMZ instanceof ISidedInventory && this.getStackInSlot(0) == null){
			ISidedInventory inv = (ISidedInventory) tileMZ;
			int slots[] = inv.getAccessibleSlotsFromSide(4);
			for(int i = 0; i < slots.length; i++){
				if(inv.getStackInSlot(i) != null){
					ItemStack tempStack = inv.getStackInSlot(i).copy();
					setInventorySlotContents(0, tempStack);
					inv.decrStackSize(i, tempStack.stackSize);
					break;
				}
			}
		}
		if(tileY != null && tileY instanceof ISidedInventory && this.getStackInSlot(0) == null){
			ISidedInventory inv = (ISidedInventory) tileY;
			int slots[] = inv.getAccessibleSlotsFromSide(4);
			for(int i = 0; i < slots.length; i++){
				if(inv.getStackInSlot(i) != null){
					ItemStack tempStack = inv.getStackInSlot(i).copy();
					setInventorySlotContents(0, tempStack);
					inv.decrStackSize(i, tempStack.stackSize);
					break;
				}
			}
		}
		
		if(tileMY != null && tileMY instanceof ISidedInventory && this.getStackInSlot(0) == null){
			ISidedInventory inv = (ISidedInventory) tileMY;
			int slots[] = inv.getAccessibleSlotsFromSide(4);
			for(int i = 0; i < slots.length; i++){
				if(inv.getStackInSlot(i) != null){
					ItemStack tempStack = inv.getStackInSlot(i).copy();
					setInventorySlotContents(0, tempStack);
					inv.decrStackSize(i, tempStack.stackSize);
					break;
				}
			}
		}
		
	}
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

		return "ThoriumPipe";
	}

	@Override
	public boolean hasCustomInventoryName() {

		return true;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
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
	
}

