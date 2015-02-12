package com.CiD.MysteryMod.TecEvolution.TileEntity;

import io.netty.buffer.ByteBuf;

import java.util.List;

import com.CiD.MysteryMod.TecEvolution.TecDATA;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;


import cpw.mods.fml.common.network.ByteBufUtils;

public class TileEntityPressureFurnace extends TileEntityMachine implements ISidedInventory{
    private ItemStack[] camoStacks = new ItemStack[6];
    private boolean startedProduce;
    private int burningTime = TecDATA.PRESSURE_SMELTER_BURNINGTIME;

    
   
    
    @Override
    public void updateEntity() {
    	super.updateEntity();
    }
  
    public int getMAxBurningTime(){
    	return TecDATA.PRESSURE_SMELTER_BURNINGTIME;
    }
    
    public int getBurningTime() {
		return burningTime;
	}

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);

        burningTime = tag.getInteger("burningTime");
        startedProduce = tag.getBoolean("startedProduce");
        camoStacks = new ItemStack[6];
        NBTTagList camoStackTag = tag.getTagList("camoStacks", 10);

        for(int i = 0; i < camoStackTag.tagCount(); i++) {
            NBTTagCompound t = camoStackTag.getCompoundTagAt(i);
            int index = t.getByte("index");
            if(index >= 0 && index < camoStacks.length) {
                camoStacks[index] = ItemStack.loadItemStackFromNBT(t);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        tag.setInteger("burningTime", burningTime);
        tag.setBoolean("startedProduce", startedProduce);
        NBTTagList camoStackTag = new NBTTagList();
        for(int i = 0; i < camoStacks.length; i++) {
            ItemStack stack = camoStacks[i];
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
    public void OnProduceTick() {
		if(startedProduce){
			burningTime--;
			if(burningTime == 0){
				burningTime = TecDATA.PRESSURE_SMELTER_BURNINGTIME;
				if(getStackInSlot(1) != null && getStackInSlot(1).getItem() == TecEvolutionMain.tungsten_ingot){
						ItemStack stack = getStackInSlot(1);
						ItemStack newStack = new ItemStack(stack.getItem(), stack.stackSize +1); 
					setInventorySlotContents(1, newStack);
					
					startedProduce = false;
				
					}else if(getStackInSlot(1) != null){
						decrStackSize(1, getStackInSlot(1).stackSize);
						ItemStack newStack = new ItemStack(TecEvolutionMain.tungsten_ingot, 1); 
						setInventorySlotContents(1, newStack);
						startedProduce = false;

					}
					else{
						ItemStack newStack = new ItemStack(TecEvolutionMain.tungsten_ingot, 1); 
						setInventorySlotContents(1, newStack);
						startedProduce = false;

					}
				}
		
		}
      }
    
    
    @Override
	public boolean Working(){
		if(drainAmount(energyPerTick()) ){
			if(startedProduce){
				
			}else if(getStackInSlot(0) != null && getStackInSlot(0).getItem() == Item.getItemFromBlock(TecEvolutionMain.tungsten_ore)){
				startedProduce = true;
				decrStackSize(0, 1);

			}
			whileWorking = true;
			return true;
		}
		burningTime = TecDATA.PRESSURE_SMELTER_BURNINGTIME;
		startedProduce = false;

		whileWorking = false;

		return false;
	}
    
    @Override
    public int energyPerTick() {
    	return TecDATA.PRESSURE_SMELTER_PER_TICK;
    }
    
    
    
    
    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory(){
        return camoStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int slot){
        return camoStacks[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
    public ItemStack decrStackSize(int slot, int decreaseAmount){
        if(camoStacks[slot] != null) {
            ItemStack itemstack;

            if(camoStacks[slot].stackSize <= decreaseAmount) {
                itemstack = camoStacks[slot];
                setInventorySlotContents(slot, null);
                markDirty();
                return itemstack;
            } else {
                itemstack = camoStacks[slot].splitStack(decreaseAmount);

                if(camoStacks[slot].stackSize == 0) {
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
        if(camoStacks[slot] != null) {
            ItemStack itemstack = camoStacks[slot];
            camoStacks[slot] = null;
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
        camoStacks[slot] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName(){
        return "Bender";
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName(){
        return false;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit(){
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player){
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(){}

    @Override
    public void closeInventory(){}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack){
        return stack != null && stack.getItem() instanceof ItemBlock;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side){
    	
    	switch(side){
    	case 0: return new int[]{1};

    	case 1: return new int[]{0};
    	case 2: return new int[]{0};
    	case 3: return new int[]{0};
    	case 4: return new int[]{0};
    	case 5: return new int[]{0};

    	}
    	
        return new int[]{side};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side){
        return isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_){
        return true;
    }

}