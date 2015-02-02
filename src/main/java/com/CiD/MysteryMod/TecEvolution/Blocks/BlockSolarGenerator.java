package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;

public class BlockSolarGenerator extends BlockBase{

	public BlockSolarGenerator(Material material, Float hardness,
			 String BlockName) {
		super(material, hardness, TileEnergyProducer.class, BlockName);

	
	}

	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEnergyProducer tl = new TileEnergyProducer();
		tl.iniProducer(20*100,10);
		return tl;
	}
}

