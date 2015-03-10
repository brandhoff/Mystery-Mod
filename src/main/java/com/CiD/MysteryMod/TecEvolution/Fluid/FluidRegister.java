package com.CiD.MysteryMod.TecEvolution.Fluid;

import com.CiD.MysteryMod.Blocks.BlockBase;

import net.minecraft.block.BlockPackedIce;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidRegister {
	
	
public static FluidBlockBase block_plasma;
public static FluidPlasma fluid_plasma;

public static ItemTungstenBucket plasma_bucket;

	public static void registerFluids(){
		fluid_plasma = new FluidPlasma("plasma");
		FluidRegistry.registerFluid(fluid_plasma);

		block_plasma = (FluidBlockBase) new FluidBlockBase(FluidRegistry.getFluid("plasma"), Material.iron).setBlockName("plasma");
		
		
		
		
		plasma_bucket = (ItemTungstenBucket) new ItemTungstenBucket(block_plasma, "plasma_bucket").setUnlocalizedName("plasma_bucket");

		
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid("plasma"), new ItemStack(plasma_bucket), new ItemStack(Items.bucket));

		BucketHandler.INSTANCE.buckets.put(block_plasma, plasma_bucket);

		
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
	
	
	
}
