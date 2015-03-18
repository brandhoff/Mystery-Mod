package com.CiD.MysteryMod.TecEvolution.RFbridge;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockConverter extends BlockBase{
	public static IIcon OtherSides;

	public BlockConverter(Material material,
			String BlockName) {
		super(material, 10.0F, TileEntityConverter.class, BlockName);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {
		if(player.isSneaking())
			return false;
		
    	player.openGui(MysteryMain.instance, GUIHandler.CONVERTER_GUI_ID, world, x, y, z);

		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		
		OtherSides = reg.registerIcon(MysteryMain.MODID + ":converter_front");
		blockIcon = reg.registerIcon(MysteryMain.MODID + ":converter_normal");
	}
	
	
	@Override
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if(side != 3){
				return this.blockIcon;
				}else{
					return this.OtherSides;
				}
		}
	
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityConverter tl = new TileEntityConverter();
		tl.ini(1000000, 1000);
		return tl;
	}
}
