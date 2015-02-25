package com.CiD.MysteryMod.TecEvolution.TileEntity;

import com.CiD.MysteryMod.TecEvolution.Tank;
import com.CiD.MysteryMod.TecEvolution.TankManager;
import com.sun.org.apache.xml.internal.resolver.readers.XCatalogReader;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityTank extends TileEntity implements IFluidHandler {

	public final Tank tank = new Tank("tank", FluidContainerRegistry.BUCKET_VOLUME * 32, this);
	public final TankManager<Tank> tankManager = new TankManager<Tank>(tank);
	public boolean hasUpdate = false;
	private int prevLightValue = 0;

	/* UPDATING */
	@Override
	public void updateEntity() {
		if (worldObj.isRemote) {
			int lightValue = getFluidLightLevel();
			if (prevLightValue != lightValue) {
				prevLightValue = lightValue;
				worldObj.updateLightByType(EnumSkyBlock.Block, xCoord, yCoord, zCoord);
			}
			return;
		}

		// Have liquid flow down into tanks below if any.
		if (tank.getFluid() != null) {
			moveFluidBelow();
		}

	}

	
	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
		tankManager.readFromNBT(data);
	}

	@Override
	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
		tankManager.writeToNBT(data);
	}

	/* HELPER FUNCTIONS */
	/**
	 * @return Last tank block below this one or this one if it is the last.
	 */
	public TileEntityTank getBottomTank() {

		TileEntityTank lastTank = this;

		while (true) {
			TileEntityTank below = getTankBelow(lastTank);
			if (below != null) {
				lastTank = below;
			} else {
				break;
			}
		}

		return lastTank;
	}

	public TileEntityTank getTopTank() {

		TileEntityTank lastTank = this;

		while (true) {
			TileEntityTank above = getTankAbove(lastTank);
			if (above != null) {
				lastTank = above;
			} else {
				break;
			}
		}

		return lastTank;
	}

	public static TileEntityTank getTankBelow(TileEntityTank tile) {
		TileEntity below = tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord -1, tile.zCoord) ;
		if (below != null && below instanceof TileEntityTank) {
			return (TileEntityTank) below;
		} else {
			return null;
		}
	}

	public static TileEntityTank getTankAbove(TileEntityTank tile) {
		TileEntity above = tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord + 1, tile.zCoord) ;
		if (above != null && above instanceof TileEntityTank) {
			return (TileEntityTank) above;
		} else {
			return null;
		}
	}

	public void moveFluidBelow() {
		TileEntityTank below = getTankBelow(this);
		if (below == null) {
			return;
		}

		int used = below.tank.fill(tank.getFluid(), true);
		if (used > 0) {
			hasUpdate = true;
			below.hasUpdate = true;

			tank.drain(used, true);
		}
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (resource == null) {
			return 0;
		}

		FluidStack resourceCopy = resource.copy();
		int totalUsed = 0;
		TileEntityTank tankToFill = getBottomTank();

		FluidStack liquid = tankToFill.tank.getFluid();
		if (liquid != null && liquid.amount > 0 && !liquid.isFluidEqual(resourceCopy)) {
			return 0;
		}

		while (tankToFill != null && resourceCopy.amount > 0) {
			int used = tankToFill.tank.fill(resourceCopy, doFill);
			resourceCopy.amount -= used;
			if (used > 0) {
				tankToFill.hasUpdate = true;
			}

			totalUsed += used;
			tankToFill = getTankAbove(tankToFill);
		}
		return totalUsed;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
		TileEntityTank bottom = getBottomTank();
		bottom.hasUpdate = true;
		return bottom.tank.drain(maxEmpty, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource == null) {
			return null;
		}
		TileEntityTank bottom = getBottomTank();
		if (!resource.isFluidEqual(bottom.tank.getFluid())) {
			return null;
		}
		return drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection direction) {
		FluidTank compositeTank = new FluidTank(tank.getCapacity());

		TileEntityTank tile = getBottomTank();

		int capacity = tank.getCapacity();

		if (tile != null && tile.tank.getFluid() != null) {
			compositeTank.setFluid(tile.tank.getFluid().copy());
		} else {
			return new FluidTankInfo[]{compositeTank.getInfo()};
		}

		tile = getTankAbove(tile);

		while (tile != null) {

			FluidStack liquid = tile.tank.getFluid();
			if (liquid == null || liquid.amount == 0) {
				// NOOP
			} else if (!compositeTank.getFluid().isFluidEqual(liquid)) {
				break;
			} else {
				compositeTank.getFluid().amount += liquid.amount;
			}

			capacity += tile.tank.getCapacity();
			tile = getTankAbove(tile);
		}

		compositeTank.setCapacity(capacity);
		return new FluidTankInfo[]{compositeTank.getInfo()};
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		Fluid tankFluid = getBottomTank().tank.getFluidType();
		return tankFluid == null || tankFluid == fluid;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		Fluid tankFluid = getBottomTank().tank.getFluidType();
		return tankFluid != null && tankFluid == fluid;
	}

	public int getFluidLightLevel() {
		FluidStack tankFluid = tank.getFluid();
		return tankFluid == null ? 0 : tankFluid.getFluid().getLuminosity(tankFluid);
	}
}