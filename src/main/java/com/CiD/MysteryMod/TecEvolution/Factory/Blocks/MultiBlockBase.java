package com.CiD.MysteryMod.TecEvolution.Factory.Blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.ITileMultiBlock;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFactoryBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.IRGBcoloredTile;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColored;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultiBlockBase extends BlockBase{

	public MultiBlockBase(Material material, Float hardness, Class BlockTile,
			String BlockName) {
		super(material, hardness, BlockTile, BlockName);

	}

		@Override
	    public boolean onBlockActivated(World world, int x, int y, int z,
	                    EntityPlayer player, int metadata, float what, float these, float are) {
	            TileEntity tileEntity = world.getTileEntity(x, y, z);
	            if (tileEntity == null || player.isSneaking()) {
	                    return false;
	            }
	            	if(tileEntity instanceof TileEntityFactoryBase){
	            		TileEntityFactoryBase tile = (TileEntityFactoryBase) world.getTileEntity(x, y, z);
	            		if(tile.isMultiBlock() && ((ITileMultiBlock)tile).isInterface()){
	            	player.openGui(MysteryMain.instance, ((ITileMultiBlock)tile).getGUIid(), world, x, y, z);
	            	return true;
	            		}
	            }
	                return false;

	    }
}
