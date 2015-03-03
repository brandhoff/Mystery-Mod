package com.CiD.MysteryMod.TecEvolution.Blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColored;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockColorAble extends BlockBase{

	public BlockColorAble(Material material, Float hardness, Class BlockTile,
			String BlockName) {
		super(material, hardness, BlockTile, BlockName);

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
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {

			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.red_ink){
				if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z)instanceof TileEntityColored){
					TileEntityColored tile = (TileEntityColored) world.getTileEntity(x, y, z);
					tile.addRed();
					return true;

				}
			}
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.green_ink){
				if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z)instanceof TileEntityColored){
					TileEntityColored tile = (TileEntityColored) world.getTileEntity(x, y, z);
					tile.addGreen();
					return true;

				}
			}if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.blue_ink){
				if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z)instanceof TileEntityColored){
					TileEntityColored tile = (TileEntityColored) world.getTileEntity(x, y, z);
					tile.addBlue();
					return true;

				}
			}
		
			
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.ink_scanner){
				ItemStack scannerStack = player.getCurrentEquippedItem();
				IRGBcoloredTile Itile = (IRGBcoloredTile) world.getTileEntity(x, y, z);
				TileEntityColored tile = (TileEntityColored) world.getTileEntity(x, y, z);
				if(scannerStack.stackTagCompound != null &&scannerStack.stackTagCompound.hasKey("red")){
					tile.setRed(scannerStack.stackTagCompound.getFloat("red"));
					tile.setBlue(scannerStack.stackTagCompound.getFloat("blue"));
					tile.setGreen(scannerStack.stackTagCompound.getFloat("green"));
					return true;

				}else{
					scannerStack.stackTagCompound = new NBTTagCompound();
					scannerStack.stackTagCompound.setFloat("red", Itile.getRed());
					scannerStack.stackTagCompound.setFloat("green", Itile.getGreen());
					scannerStack.stackTagCompound.setFloat("blue", Itile.getBlue());
				
					return true;


				}
			}
		
		
		return false;
	}
	
}
