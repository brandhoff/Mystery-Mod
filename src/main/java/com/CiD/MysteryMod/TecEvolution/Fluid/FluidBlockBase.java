package com.CiD.MysteryMod.TecEvolution.Fluid;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Helper.Methods;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluidBlockBase extends BlockFluidClassic{
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	Fluid fluid;
	public FluidBlockBase(Fluid fluid, Material material) {
		super(fluid, Material.lava);
		this.fluid = fluid;
		GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
		setCreativeTab(MysteryMain.fluid_tab);
		this.blockHardness = 60.0F;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
	
		stillIcon = reg.registerIcon(MysteryMain.MODID + ":" + this.getUnlocalizedName().substring(5)+"_still");
		flowingIcon = reg.registerIcon(MysteryMain.MODID + ":" + this.getUnlocalizedName().substring(5)+"_flow");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side != 0){
			return flowingIcon;
		}
		if(side != 1){
			return flowingIcon;
		}
			return stillIcon;
		
              
       }

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
			super.onEntityCollidedWithBlock(world, x, y,z, entity);
			
			if(fluid instanceof FluidPlasma){
				if(!world.isRemote)
				world.createExplosion(entity, x, y, z, 10, true);
			}
	}
	
		@Override
		public void updateTick(World world, int x, int y, int z, Random rand) {
			super.updateTick(world, x, y, z, rand);
		}
//			if(fluid instanceof FluidPlasma){
//				if(world.getBlock(x + 1, y, z) != null && !world.getBlock(x+1 , y, z).isNormalCube()&&world.getBlock(x + 1, y, z) != Blocks.bedrock && world.getBlock(x + 1, y, z) != FluidRegister.block_plasma){
//					Methods.BreakBlock(world, x + 1, y, z, false);
//				}
//				if(world.getBlock(x - 1, y, z) != null &&!world.getBlock(x-1 , y, z).isNormalCube()&&world.getBlock(x - 1, y, z) != Blocks.bedrock && world.getBlock(x - 1, y, z) != FluidRegister.block_plasma){
//					Methods.BreakBlock(world, x - 1, y, z, false);
//				}
//				
//				if(world.getBlock(x, y, z-1) != null &&!world.getBlock(x , y, z-1).isNormalCube() &&world.getBlock(x, y, z-1) != Blocks.bedrock && world.getBlock(x, y, z-1) != FluidRegister.block_plasma){
//					Methods.BreakBlock(world, x, y, z - 1, false);
//				}
//				if(world.getBlock(x , y, z + 1) != null &&!world.getBlock(x , y, z+1).isNormalCube() &&world.getBlock(x , y, z + 1) != Blocks.bedrock && world.getBlock(x, y, z+1) != FluidRegister.block_plasma){
//					Methods.BreakBlock(world, x , y, z + 1, false);
//				}
//				
//				if(world.getBlock(x , y+1, z) != null &&!world.getBlock(x , y+1, z).isNormalCube() &&world.getBlock(x, y+1, z) != Blocks.bedrock && world.getBlock(x, y+1, z) != FluidRegister.block_plasma){
//					Methods.BreakBlock(world, x, y, z - 1, false);
//				}
//				if(world.getBlock(x , y-1, z) != null &&!world.getBlock(x , y-1, z).isNormalCube() &&world.getBlock(x , y-1, z ) != Blocks.bedrock && world.getBlock(x, y-1, z) != FluidRegister.block_plasma){
//					Methods.BreakBlock(world, x , y, z + 1, false);
//				}
//			}
//		}
}
