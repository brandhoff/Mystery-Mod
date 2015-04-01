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

import com.CiD.API.color.IRGBcoloredTile;
import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFactoryBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColored;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultiBlockEnergyAcceptor extends MultiBlockBase{

	public MultiBlockEnergyAcceptor(Material material, Float hardness, Class BlockTile,
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

}
