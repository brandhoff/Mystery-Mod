package com.CiD.MysteryMod.TecEvolution.Factory.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFactoryHull;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultiBlockHull extends MultiBlockBase{

	public MultiBlockHull(Material material, Float hardness, Class BlockTile,
			String BlockName) {
		super(material, hardness, BlockTile, BlockName);

	}

		@Override
		   @SideOnly(Side.CLIENT)
		    public int getRenderBlockPass()
		    {
		        return 1;
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
		public int colorMultiplier(IBlockAccess world, int x, int y, int z) {

			if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityFactoryHull){
				TileEntityFactoryHull tile = (TileEntityFactoryHull) world.getTileEntity(x, y, z);
				if(tile.isMultiBlock()){
					return tile.getMultiBlockColor();
					}
				}
			return 0xFFFFFFFF;
		}
}
