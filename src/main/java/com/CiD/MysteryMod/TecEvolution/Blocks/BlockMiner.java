package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCracker;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMiner;

public class BlockMiner extends BlockMachineBase{

	public BlockMiner(String BlockName) {
		super(Material.iron, 1.0F, TileEntityMiner.class, BlockName);
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
