package com.CiD.MysteryMod.TecEvolution.Render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.TecEvolution.Buildcraft.FluidRenderer;
import com.CiD.MysteryMod.TecEvolution.Buildcraft.RenderUtils;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityTank;
/** BY THE BUILDCRAFT TEAM*/
public class RenderTank extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

		TileEntityTank tank = (TileEntityTank) tileentity;

		FluidStack liquid = tank.tank.getFluid();
		int color = tank.tank.colorRenderCache;
		if (liquid == null || liquid.amount <= 0) {
			return;
		}

		int[] displayList = FluidRenderer.getFluidDisplayLists(liquid, tileentity.getWorldObj(), false);
		if (displayList == null) {
			return;
		}

		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		bindTexture(FluidRenderer.getFluidSheet(liquid));
		RenderUtils.setGLColorFromInt(color);

		GL11.glTranslatef((float) x +0.05f, (float) y + 0.5F, (float) z +0.05f);
		GL11.glScalef(0.9F, 0.9F, 0.9F);
		GL11.glTranslatef(0, -0.5F, 0);

		GL11.glCallList(displayList[(int) ((float) liquid.amount / (float) (tank.tank.getCapacity()) * (FluidRenderer.DISPLAY_STAGES - 1))]);

		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}
}