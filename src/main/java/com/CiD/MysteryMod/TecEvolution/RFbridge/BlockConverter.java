package com.CiD.MysteryMod.TecEvolution.RFbridge;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

public class BlockConverter extends BlockBase{

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
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityConverter tl = new TileEntityConverter();
		tl.ini(1000000, 1000);
		return tl;
	}
}
