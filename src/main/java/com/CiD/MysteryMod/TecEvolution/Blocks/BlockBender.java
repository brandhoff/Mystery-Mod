package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityBender;

public class BlockBender extends BlockMachineInventoryBase{

	public BlockBender(String BlockName) {
		super(BlockName);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityBender tl = new TileEntityBender();
		tl.ini(1, 1);
		
		return tl;
		
		
	}
}
