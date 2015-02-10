package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMiner;

public class BlockMiner extends BlockMachineBase{

	public BlockMiner(String BlockName) {
		super(Material.iron, 1.0F, TileEntityMiner.class, BlockName);
	}

	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityMiner tl = new TileEntityMiner();
		tl.ini(1, 1);
		return tl;
			}
}
