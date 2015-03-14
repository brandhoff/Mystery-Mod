package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCracker;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMiner;

public class BlockMiner extends BlockMachineBase{

	public BlockMiner(String BlockName) {
		super(Material.iron, 1.0F, TileEntityMiner.class, BlockName);
	}

	@Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int metadata, float what, float these, float are) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }else if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.speed_upgrade){
        		TileEntityMiner miner = (TileEntityMiner) world.getTileEntity(x, y, z);
        		if(miner.getUpgradeTier()+1 <= 3){
        			miner.setUpgradeTier(miner.getUpgradeTier() + 1);
        			player.addChatMessage(new ChatComponentText("Upgraded to Tier: " + miner.getUpgradeTier()));
        			player.getCurrentEquippedItem().stackSize--;
        		}
            	return true;
            }
            	player.openGui(MysteryMain.instance, GUIHandler.MINER_GUI_ID, world, x, y, z);
            return true;
    }
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityMiner tl = new TileEntityMiner();
		tl.ini(1, 1);
		return tl;
			}
	@Override
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {

	
		TileEntityMiner pipe = (TileEntityMiner) world.getTileEntity(x, y, z);
		ItemStack stack = pipe.getStackInSlot(0);
		ItemStack stack2 = pipe.getStackInSlot(1);

		if(!world.isRemote && stack != null){
			world.spawnEntityInWorld(new EntityItem(world, x, y, z,stack));
		}if(!world.isRemote && stack2 != null){
			world.spawnEntityInWorld(new EntityItem(world, x, y, z,stack2));
		}
		super.breakBlock(world, x, y, z,
				p_149749_5_, p_149749_6_);
	}
}
