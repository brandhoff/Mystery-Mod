
package com.CiD.MysteryMod.TecEvolution.Blocks;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityTank;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTank extends BlockBase {
	public static IIcon OtherSides;

	public BlockTank(Material material, Float hardness, Class BlockTile,
			String BlockName) {
		super(material, hardness, BlockTile, BlockName);
	}



	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		super.registerBlockIcons(reg);
		OtherSides = reg.registerIcon(MysteryMain.MODID + ":iron_tank_under");

	}
	
	
		@Override
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if(side == 0){
				return OtherSides;

			}else
			return blockIcon;
		}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, 
			int par6, float par7, float par8, float par9) {
		ItemStack stack = player.inventory.getCurrentItem();
		if (stack != null) {
			TileEntity tile = world.getTileEntity(x, y, z);

			if (tile instanceof TileEntityTank) {
				TileEntityTank tank = (TileEntityTank) tile;
				if (FluidContainerRegistry.isContainer(stack)) {
					FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(stack);
					if (liquid != null) {
						int amount = tank.fill(ForgeDirection.UNKNOWN, liquid, true);
						if (amount != 0 && !player.capabilities.isCreativeMode) {
							if (stack.stackSize > 1) {
								if (!player.inventory.addItemStackToInventory(FluidContainerRegistry.drainFluidContainer(stack))) {
									player.dropPlayerItemWithRandomChoice(FluidContainerRegistry.drainFluidContainer(stack), false);
								}

								player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
							} else {
								player.inventory.setInventorySlotContents(player.inventory.currentItem, FluidContainerRegistry.drainFluidContainer(stack));
							}
						}

						return true;

					} else {
						FluidStack available = tank.getTankInfo(ForgeDirection.UNKNOWN)[0].fluid;

						if (available != null) {
							ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, stack);

							liquid = FluidContainerRegistry.getFluidForFilledItem(filled);

							if (liquid != null) {
								if (!player.capabilities.isCreativeMode) {
									if (stack.stackSize > 1) {
										if (!player.inventory.addItemStackToInventory(filled)) {
											return false;
										} else {
											player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
										}
									} else {
										player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
										player.inventory.setInventorySlotContents(player.inventory.currentItem, filled);
									}
								}

								tank.drain(ForgeDirection.UNKNOWN, liquid.amount, true);

								return true;
							}
						}
					}
				} else if (stack.getItem() instanceof IFluidContainerItem) {
					if (!world.isRemote) {
						IFluidContainerItem container = (IFluidContainerItem) stack.getItem();
						FluidStack liquid = container.getFluid(stack);
						FluidStack tankLiquid = tank.getTankInfo(ForgeDirection.UNKNOWN)[0].fluid;
						
						boolean mustDrain = liquid == null || liquid.amount == 0;
						
						boolean mustFill = tankLiquid == null || tankLiquid.amount == 0;
						if (mustDrain && mustFill) {
						} else if (mustDrain || !player.isSneaking()) {
								liquid = tank.drain(ForgeDirection.UNKNOWN, 1000, false);
								int qtyToFill = container.fill(stack, liquid, true);
								tank.drain(ForgeDirection.UNKNOWN, qtyToFill, true);
						} else if (mustFill || player.isSneaking()) {
							if (liquid != null && liquid.amount > 0) {
								int qty = tank.fill(ForgeDirection.UNKNOWN, liquid, false);
								tank.fill(ForgeDirection.UNKNOWN, container.drain(stack, qty, true), true);
							}
						}
					}

					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		
			return true;
		
	}



	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile instanceof TileEntityTank) {
			TileEntityTank tank = (TileEntityTank) tile;
			return tank.getFluidLightLevel();
		}

		return super.getLightValue(world, x, y, z);
	}
}