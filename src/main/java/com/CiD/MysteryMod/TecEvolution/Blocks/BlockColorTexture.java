package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.API.color.IRGBcoloredTile;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColorTexture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockColorTexture extends BlockBase{

	public BlockColorTexture(Material material, Float hardness, Class BlockTile,
			String BlockName) {
		super(material, hardness, BlockTile, BlockName);

	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {

			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.red_ink){
				if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z)instanceof TileEntityColorTexture){
					TileEntityColorTexture tile = (TileEntityColorTexture) world.getTileEntity(x, y, z);
					tile.addRed();
					return true;

				}
			}
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.green_ink){
				if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z)instanceof TileEntityColorTexture){
					TileEntityColorTexture tile = (TileEntityColorTexture) world.getTileEntity(x, y, z);
					tile.addGreen();
					return true;

				}
			}if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.blue_ink){
				if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z)instanceof TileEntityColorTexture){
					TileEntityColorTexture tile = (TileEntityColorTexture) world.getTileEntity(x, y, z);
					tile.addBlue();
					return true;

				}
			}
		
			
		
		
		
		return false;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
		TileEntityColorTexture tile = (TileEntityColorTexture) world.getTileEntity(x, y, z);
		return tile.getRGBcolor();
	}
	
}
