package com.CiD.MysteryMod.TecEvolution.TileEntity;

import java.util.List;

import scala.xml.persistent.SetStorage;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Helper.Methods;
import com.CiD.MysteryMod.Network.packet.client.UpdateMinerTOclient;
import com.CiD.MysteryMod.TecEvolution.TecDATA;
import com.CiD.MysteryMod.TecEvolution.Render.Particles.EnumTecParticles;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class TileEntityMiner extends TileEntityMachine implements ISidedInventory{
private int sleepTimer;
private int renderTick;
private ItemStack[] invStacks = new ItemStack[6];
private int ydig = TecDATA.MINER_DIG_Y;
private int upgradeTier = 1;
	public TileEntityMiner() {

	}
	@Override
		public void writeToNBT(NBTTagCompound tag) {
			super.writeToNBT(tag);
			tag.setInteger("ydig", ydig);
			tag.setInteger("upgradeTier", upgradeTier);

		}
	@Override
		public void readFromNBT(NBTTagCompound tag) {
			super.readFromNBT(tag);
			ydig = tag.getInteger("ydig");
			upgradeTier = tag.getInteger("upgradeTier");

		}
	
	public void setUpgradeTier(int upgradeTier) {
		this.upgradeTier = upgradeTier;
	}
	public int getUpgradeTier() {
		return upgradeTier;
	}
	
	public int getYdig() {
		return ydig;
	}
	
	public void setYdig(int ydig) {
		this.ydig = ydig;
	}
	
	@Override
	public void ini(int MaxE, int drPerTick) {
		setMaxEnergy(energyPerTick()*10);
		setDrainPerTickConnection(energyPerTick());
	}
		@Override
		public void produce() {
			if(sleepTimer == 0){
				sleepTimer = (20*1)/upgradeTier;
				
					
					for(int i = 1; i<ydig;i++){
						if(worldObj.getBlock(xCoord, yCoord-i, zCoord) != null && worldObj.getBlock(xCoord, yCoord-i, zCoord) != Blocks.bedrock&& worldObj.getBlock(xCoord, yCoord-i, zCoord) != Blocks.air){
							if(worldObj.getBlock(xCoord, yCoord-i, zCoord).getBlockHardness(worldObj, xCoord, yCoord-i, zCoord)<5){

								List<ItemStack> stackList = worldObj.getBlock(xCoord, yCoord-i, zCoord).getDrops(worldObj, xCoord, yCoord-i, zCoord, 0, 0);
								
								for(int x = 0; x < stackList.size(); x++){
									if(getStackInSlot(0) == null){
										setInventorySlotContents(0, stackList.get(x));
									}else{
										if(!worldObj.isRemote){

									worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord+1, zCoord, stackList.get(x)));
										}
										}
									}
								if(!worldObj.isRemote){

								Methods.BreakBlock(worldObj, xCoord, yCoord-i, zCoord, false);
								}else{
									for(int x = 0; x <20; x++)
									EnumTecParticles.Simple.spawnParticle(worldObj, xCoord +0.5, yCoord - i, zCoord+0.5, 0, 0.4, 0, 0.25F, 0.25F, 0.25F,0);
								}
								break;
							}
						}
					}
					
				
				
				
				
			}else{
				sleepTimer--;
			}
			
		}
	
	@Override
	public int energyPerTick() {

		return TecDATA.MINER_PER_BLOCK;
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
		// TODO Auto-generated method stub
		return "Miner";
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
	
}
