package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;

import com.CiD.MysteryMod.TecEvolution.TecDATA;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.Recipes.Recipe;
import com.CiD.MysteryMod.TecEvolution.Recipes.RecipeCracker;

public class TileEntityCracker extends TileEntityMachine implements ISidedInventory{
    private ItemStack[] invStacks = new ItemStack[6];
    private boolean startedProduce;
    private int burningActive;
    private int burningTime = -1;
    private ItemStack producingItem;
    private RecipeCracker crackerRecipe = new RecipeCracker();
	private int currentItemBurnTime;
	private int furnaceCookTime;
   
    
    @Override
    public void updateEntity() {
    	super.updateEntity();
    }
  
    public int getMAxBurningTime(){
    	if(producingItem != null){
    		crackerRecipe.getBurningTime(producingItem.getItem());
    	}
    		
    	return -1;
    }
    
    public int getBurningTime() {
		return burningTime;
	}

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);

        burningTime = tag.getInteger("burningTime");
        startedProduce = tag.getBoolean("startedProduce");
        invStacks = new ItemStack[6];
        NBTTagList camoStackTag = tag.getTagList("camoStacks", 10);
        NBTTagList usingStackTag = tag.getTagList("producingItem", 10);

        for(int i = 0; i < camoStackTag.tagCount(); i++) {
            NBTTagCompound t = camoStackTag.getCompoundTagAt(i);
            int index = t.getByte("index");
            if(index >= 0 && index < invStacks.length) {
                invStacks[index] = ItemStack.loadItemStackFromNBT(t);
            }
        }
        NBTTagCompound t = usingStackTag.getCompoundTagAt(0);
        producingItem = ItemStack.loadItemStackFromNBT(t);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        tag.setInteger("burningTime", burningTime);
        tag.setBoolean("startedProduce", startedProduce);
        NBTTagList camoStackTag = new NBTTagList();
        for(int i = 0; i < invStacks.length; i++) {
            ItemStack stack = invStacks[i];
            if(stack != null) {
                NBTTagCompound t = new NBTTagCompound();
                stack.writeToNBT(t);
                t.setByte("index", (byte)i);
                camoStackTag.appendTag(t);
            }
        }
        tag.setTag("camoStacks", camoStackTag);
        
        
        
        NBTTagList usingStackTag = new NBTTagList();
        if(producingItem != null) {
            NBTTagCompound t = new NBTTagCompound();
            producingItem.writeToNBT(t);
        }
        tag.setTag("producingItem", usingStackTag);

        
        
    }

    
    
    public boolean isBurning()
    {
        return this.burningTime > 0;
    }

    
    @Override
    public void OnProduceTick() {
		if(startedProduce){
			burningTime--;
			if(burningTime == 0){
				if(producingItem != null &&producingItem.getItem() != null){
				burningTime = crackerRecipe.getBurningTime(producingItem.getItem());
					}
					else{
					burningTime = -1;
				}
				if( producingItem != null && getStackInSlot(1) != null && getStackInSlot(1).getItem() == crackerRecipe.getResult(producingItem.getItem())){
						ItemStack stack = getStackInSlot(1);
						ItemStack newStack = new ItemStack(stack.getItem(), stack.stackSize +1); 
					setInventorySlotContents(1, newStack);
					
					startedProduce = false;
				
					}else if(getStackInSlot(1) != null){
						decrStackSize(1, getStackInSlot(1).stackSize);
						ItemStack newStack = new ItemStack(crackerRecipe.getResult(producingItem.getItem()).get(0).getItem(), 1); 
						setInventorySlotContents(1, newStack);
						startedProduce = false;

					}
					else{
						if(producingItem != null){
						ItemStack newStack = new ItemStack(crackerRecipe.getResult(producingItem.getItem()).get(0).getItem(), 1); 
						setInventorySlotContents(1, newStack);
						startedProduce = false;
						}
					}
				}
		
		}
      }
    
    
    @Override
	public boolean Working(){
		if(drainAmount(energyPerTick()) ){
			if(startedProduce){
				
			}else if(getStackInSlot(0) != null && crackerRecipe.isUseable(getStackInSlot(0).getItem())){
				producingItem = getStackInSlot(0);
				startedProduce = true;
				decrStackSize(0, 1);

			}

			whileWorking = true;
			return true;
		}
		if(producingItem != null)
		burningTime = crackerRecipe.getBurningTime(producingItem.getItem());
		startedProduce = false;

		whileWorking = false;

		return false;
	}
    
    @Override
    public int energyPerTick() {
    	return TecDATA.BENDER_PER_TICK;
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