package com.CiD.MysteryMod.TecEvolution.Render;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderCable extends TileEntitySpecialRenderer{

	@Override
	public void renderTileEntityAt(TileEntity tile, double x,
			double y, double z, float p_147500_8_) {
		TileEntityCable tl = (TileEntityCable) tile;
		GL11.glPushMatrix();
		GL11.glTranslated(x+0.5, y, z+0.5);
		Tessellator ts = new Tessellator();
//		ts.
		GL11.glPopMatrix();
		
		
	}

}
