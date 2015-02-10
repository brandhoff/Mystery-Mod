package com.CiD.MysteryMod.TecEvolution.TileEntity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.CiD.MysteryMod.TecEvolution.TecDATA;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;

public class TileEntityBender extends TileBaseInventoryMachine implements IInventory{
	private ItemStack[] inventoryStacks;
	public TileEntityBender() {
		inventoryStacks = new ItemStack[6];
		burningTime = TecDATA.BENDER_BURNINGTIME;

	}
	@Override
	public int getMaxBurningTime(){
		return TecDATA.BENDER_BURNINGTIME;
	}
	@Override
	public void updateEntity() {
		
		
		setMomEnergy(getMomEnergy() - energyPerTick());
		
		super.updateEntity();
	}
	@Override
	public boolean Working(){
		if(inventoryStacks[1]!= null && drainAmount(energyPerTick()) && inventoryStacks[1].getItem() == Items.iron_ingot){
			return true;
		}
		return false;
	}
	@Override
	public int energyPerTick() {

		return TecDATA.BENDER_PER_TICK;
	}
	//TODO FIX ALL THE BURNING STUFF
	@Override
	public void produce() {
		burningTime--;
		if(burningTime == 0){
			inventoryStacks[1].stackSize--;

			burningTime = TecDATA.BENDER_BURNINGTIME;
			if(inventoryStacks[2] != null && inventoryStacks[2].getItem() != TecEvolutionMain.iron_plate &&inventoryStacks[2].getItem() != null){
				if(!worldObj.isRemote)
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord, zCoord, new ItemStack(TecEvolutionMain.iron_plate,1)));
			}else if(inventoryStacks[2] != null && inventoryStacks[2].getItem() == TecEvolutionMain.iron_plate){
				if(inventoryStacks[2].stackSize < 64){
					inventoryStacks[2].stackSize++;
				}else{
					if(!worldObj.isRemote)
					worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord, zCoord, new ItemStack(TecEvolutionMain.iron_plate,1)));
				}
			}else{
				inventoryStacks[2] = new ItemStack(TecEvolutionMain.iron_plate,1);
			}
		}
	}

	public int getSlotCount(){
		return this.inventoryStacks.length;
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
				return "Machine";
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
