package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityWindTurbine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWindGenerator extends BlockBase{

	public static IIcon OtherSides;



	public BlockWindGenerator(Material material, Float hardness,
			 String BlockName) {
		super(material, hardness, TileEntityWindTurbine.class, BlockName);

	
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
	
	@Override
	public void onBlockAdded(World world, int x,
			int y, int z) {
		world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		world.markBlockForUpdate(x, y, z);
		world.markBlockForUpdate(x+1, y, z);
		world.markBlockForUpdate(x-1, y, z);
		world.markBlockForUpdate(x, y, z+1);
		world.markBlockForUpdate(x, y, z-1);
		world.markBlockForUpdate(x, y+1, z);
		world.markBlockForUpdate(x, y-1, z);

		super.onBlockAdded(world, x, y, z);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		
		blockIcon = reg.registerIcon(MysteryMain.MODID + ":white");
	}
	
	
	@Override
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
				return this.blockIcon;
			
		}
	
	
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityWindTurbine tl = new TileEntityWindTurbine();
		tl.iniProducer(20*100,1000);
		return tl;
		
		
	}
}

