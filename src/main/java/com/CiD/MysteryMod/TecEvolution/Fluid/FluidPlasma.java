package com.CiD.MysteryMod.TecEvolution.Fluid;

import com.CiD.MysteryMod.Blocks.BlockBase;

import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

public class FluidPlasma extends Fluid{

	public FluidPlasma(String fluidName) {
		super(fluidName);

	}

	@Override
	public IIcon getFlowingIcon() {

		return BlockBase.flowingPlasma;
	}
	
	@Override
	public IIcon getStillIcon() {
		
		return BlockBase.stillPlasma;

	}
	
}
