package com.CiD.MysteryMod.TecEvolution.TileEntity;

import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityNuclearReactor extends TileEnergyProducer implements IInventory{
	private ItemStack[] inventoryStacks;
	public TileEntityNuclearReactor() {
		inventoryStacks = new ItemStack[6];
	}
	
	@Override
	public boolean generateParam() {
		if(getStackInSlot(0) != null && getStackInSlot(0).getItem() == TecEvolutionMain.bundled_uranium){
			if(getStackInSlot(1) != null && getStackInSlot(1).getItem() == TecEvolutionMain.bundled_uranium){
				if(getStackInSlot(2) != null && getStackInSlot(2).getItem() == TecEvolutionMain.bundled_uranium){
					if(getStackInSlot(3) != null && getStackInSlot(3).getItem() == TecEvolutionMain.bundled_uranium){
						if(getStackInSlot(4) != null && getStackInSlot(4).getItem() == TecEvolutionMain.bundled_uranium){
							if(getStackInSlot(5) != null && getStackInSlot(5).getItem() == TecEvolutionMain.bundled_uranium){
								return true;
							}
						}
					}
				}
			}
		}
		return false;

	}
	
    @Override
    public int getSizeInventory() {
            return inventoryStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
            return inventoryStacks[slot];
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
    	inventoryStacks[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
                            }
                    }
            }
            return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }
    
    @Override
    public int getInventoryStackLimit() {
            return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
            return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

 
    
    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);

        NBTTagList camoStackTag = tag.getTagList("camoStacks", 10);

        for(int i = 0; i < camoStackTag.tagCount(); i++) {
            NBTTagCompound t = camoStackTag.getCompoundTagAt(i);
            int index = t.getByte("index");
            if(index >= 0 && index < inventoryStacks.length) {
                this.inventoryStacks[index] = ItemStack.loadItemStackFromNBT(t);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);

        NBTTagList camoStackTag = new NBTTagList();
        for(int i = 0; i < inventoryStacks.length; i++) {
            ItemStack stack = inventoryStacks[i];
            if(stack != null) {
                NBTTagCompound t = new NBTTagCompound();
                stack.writeToNBT(t);
                t.setByte("index", (byte)i);
                camoStackTag.appendTag(t);
            }
        }
        tag.setTag("camoStacks", camoStackTag);
    }

			@Override
			public String getInventoryName() {
				return "NuclearReactor";
			}
			@Override
			public boolean hasCustomInventoryName() {
				return true;
			}
			@Override
			public void openInventory() {
				
			}
			@Override
			public void closeInventory() {
				
			}
			@Override
			public boolean isItemValidForSlot(int i,
					ItemStack stack) {
				return true;
			}
}