package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityThoriumPipe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockThoriumPipe extends BlockBase{

	public BlockThoriumPipe( String BlockName) {
		super(Material.sponge, 9.0F, TileEntityThoriumPipe.class, BlockName);

	}
	@Override
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {

	
		TileEntityThoriumPipe pipe = (TileEntityThoriumPipe) world.getTileEntity(x, y, z);
		ItemStack stack = pipe.getStackInSlot(0);
		
		if(!world.isRemote && stack != null){
			world.spawnEntityInWorld(new EntityItem(world, x, y, z,stack));
		}
		super.breakBlock(world, x, y, z,
				p_149749_5_, p_149749_6_);
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public boolean isNormalCube() {
		return false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int side) {
		
		
		return false;
	}
	
}
