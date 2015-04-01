package com.CiD.MysteryMod.TecEvolution.Render;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.CiD.API.color.IRGBcoloredTile;
import com.CiD.MysteryMod.client;

public class RenderColoredTile extends TileEntitySpecialRenderer{
private final ModelInnerBlock model = new ModelInnerBlock();
	public RenderColoredTile() {

	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float p_147500_8_) {
		if(tile instanceof IRGBcoloredTile){
		    GL11.glPushMatrix();
		    GL11.glTranslated(x+0.5, y-0.5, z+0.5);
		    GL11.glDisable(GL11.GL_LIGHTING);
		    GL11.glColor3f(((IRGBcoloredTile) tile).getRed(), ((IRGBcoloredTile) tile).getGreen(), ((IRGBcoloredTile) tile).getBlue());
		    Tessellator tessellator = Tessellator.instance;
		    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
		     bindTexture(client.TEXTUREmodel_white);
		     model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		     GL11.glEnable(GL11.GL_LIGHTING);
		     GL11.glPopMatrix();
		}
	}

}
