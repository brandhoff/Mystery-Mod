package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityGravitomagnet;

public class BlockGravitomagnet extends BlockBase{

	public BlockGravitomagnet(String BlockName) {
		super(Material.iron, 1.7F, TileEntityGravitomagnet.class, BlockName);

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!player.isSneaking() && player.getCurrentEquippedItem() != null){
			if(player.getCurrentEquippedItem().getItem() == TecEvolutionMain.link_card){
				ItemStack stack = player.getCurrentEquippedItem();
				if(stack.stackTagCompound != null){
					if(stack.stackTagCompound.hasKey("x")){
						TileEntityGravitomagnet tile = (TileEntityGravitomagnet) world.getTileEntity(x, y, z);
						tile.setReciverLoc(stack.stackTagCompound.getInteger("x"), stack.stackTagCompound.getInteger("y"), stack.stackTagCompound.getInteger("z"));
					return true;
					}
				}else{
					stack.stackTagCompound = new NBTTagCompound();
					stack.stackTagCompound.setInteger("x", x);
					stack.stackTagCompound.setInteger("y", y);
					stack.stackTagCompound.setInteger("z", z);
					return true;

				}
			}
		}
		if(player.isSneaking()){
			TileEntityGravitomagnet tile = (TileEntityGravitomagnet) world.getTileEntity(x, y, z);
			if(tile.getReciver() != null)
			tile.sendBlocks(tile.getReciver());
			return true;
		}
		
		return false;
	}
	
	
}
