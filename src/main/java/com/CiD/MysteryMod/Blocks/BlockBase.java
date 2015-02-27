package com.CiD.MysteryMod.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.client;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBase extends BlockContainer{
private Class<?extends TileEntity> tile;
@SideOnly(Side.CLIENT)
public static IIcon GUI_TEC_SLOT;
@SideOnly(Side.CLIENT)
public static IIcon IconParticleSimple;

	public BlockBase(Material material, Float hardness, Class BlockTile, String BlockName) {
		super(material);
		
		setHardness(hardness);
		setCreativeTab(MysteryMain.block_tab);
		setBlockName(BlockName);
		tile = BlockTile;
		
		if(BlockTile != null){
			if(BlockTile.getInterfaces() != null){
				for(int i = 0; i < BlockTile.getInterfaces().length; i++){
					if(BlockTile.getInterfaces()[i] == IRGBcoloredTile.class){
						client.addToIcolorTileList(BlockTile);
					}
				}
			}
		}
		
		GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
	}
	@Override
	public boolean onBlockActivated(World world, int x,
			int y, int z, EntityPlayer player,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		// TODO Auto-generated method stub
		return super.onBlockActivated(world, x, y,
				z, player, p_149727_6_, p_149727_7_, p_149727_8_,
				p_149727_9_);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		try {
			return tile.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	//OLD RENDERING STUFF

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
	
	blockIcon = reg.registerIcon(MysteryMain.MODID + ":" + this.getUnlocalizedName().substring(5));
	GUI_TEC_SLOT = reg.registerIcon(MysteryMain.MODID+":textures/gui/GUItecSlot");
	IconParticleSimple = reg.registerIcon(MysteryMain.MODID+":textures/particles/simple");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
	return blockIcon;
		}
}
