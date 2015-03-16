package com.CiD.MysteryMod.TecEvolution.TileEntity;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Helper.Methods;
import com.CiD.MysteryMod.Network.packet.AbstractPacket;
import com.CiD.MysteryMod.Network.packet.client.RenderMinerBoxPacket;
import com.CiD.MysteryMod.TecEvolution.TecDATA;
import com.CiD.MysteryMod.TecEvolution.Render.RenderMinerBox;
import com.CiD.MysteryMod.TecEvolution.Render.Particles.EnumTecParticles;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class TileEntityAtomicMiner extends TileEntityMachine implements ISidedInventory{
private int sleepTimer = 20*1;
private int renderTick;
private ItemStack[] invStacks = new ItemStack[6];
private boolean shouldRenderBox;
private RenderMinerBox BoxRenderer;

	public TileEntityAtomicMiner() {

	}
	 
	@Override
	public void ini(int MaxE, int drPerTick) {
		setMaxEnergy(energyPerTick()*10);
		setDrainPerTickConnection(energyPerTick());
	}
	
	@Override
		public void updateEntity() {
			super.updateEntity();
			if(shouldRenderBox && worldObj.isRemote){
				System.out.println("rendeering");
				RenderMinerBox render = new RenderMinerBox();
				render.renderTileEntityAt(this, xCoord, yCoord, zCoord, 0.0F);
			}
		}
	
//	public void RenderMinerBox(){
//		if(shouldRenderBox){
//			 if(worldObj.isRemote) {
//		        } else {
//					MysteryMain.packetPipeline.sendToAllAround(new RenderMinerBoxPacket(this, xCoord, yCoord, zCoord),new TargetPoint( worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 60));
//
//		        }
//		}
//	}
//	
	public void shouldRenderBox(boolean b){
		this.shouldRenderBox = b;
	}
	public boolean shouldRenderBox(){
		return this.shouldRenderBox;
	}
	
		@Override
		public void OnProduceTick() {
			if(sleepTimer == 0){
				sleepTimer = 20;
			for(int corz = 0 - TecDATA.ATOMIC_MINER_DIG_Z; corz < TecDATA.ATOMIC_MINER_DIG_Z; corz++){
				for(int corx = 0 - TecDATA.ATOMIC_MINER_DIG_X; corx<TecDATA.ATOMIC_MINER_DIG_X; corx++){
					for(int i = 1; i<TecDATA.ATOMIC_MINER_DIG_Y;i++){
						if(worldObj.getBlock(xCoord + corx, yCoord-i, zCoord+corz) != null && worldObj.getBlock(xCoord+corx, yCoord-i, zCoord+corz) != Blocks.bedrock&& worldObj.getBlock(xCoord+corx, yCoord-i, zCoord+corz) != Blocks.air){
							if(worldObj.getBlock(xCoord + corx, yCoord-i, zCoord+corz).getBlockHardness(worldObj, xCoord+ corx, yCoord-i, zCoord + corz)<5){

								List<ItemStack> stackList = worldObj.getBlock(xCoord + corx, yCoord-i, zCoord + corz).getDrops(worldObj, xCoord, yCoord-i, zCoord, 0, 0);
								
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

								Methods.BreakBlock(worldObj, xCoord + corx, yCoord-i, zCoord + corz, false);

								}else{
									for(int x = 0; x <20; x++)
									EnumTecParticles.Simple.spawnParticle(worldObj, xCoord +0.5 + corx, yCoord - i, zCoord+0.5+corz, 0, 0.4, 0, 0, 0, 0.6F,0);
								}
								return;
							}


						}
					}
					
				}
			}
				
				
			}else{
				sleepTimer--;
			}
			
		}
	
			@Override
			public void onChunkUnload() {
			
			shouldRenderBox = false;
			}
		
	@Override
	public int energyPerTick() {

		return TecDATA.ATOMIC_MINER_PER_BLOCK;
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
