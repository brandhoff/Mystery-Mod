package com.CiD.MysteryMod.TecEvolution.Render;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallEnergyBank;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

public class RenderConnections extends TileEntitySpecialRenderer{
	public static ResourceLocation Connectors = new ResourceLocation(MysteryMain.MODID+":textures/blocks/output_connecter.png");
	private boolean[] output;
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x,
			double y, double z, float p_147500_8_) {
		TileEntityStorage tl = (TileEntityStorage) tile;
		output = tl.getAllOutputSides();
	
		
		if(output[TecHelper.SIDE_MZ]){
			GL11.glPushMatrix();
			
		    GL11.glDisable(GL11.GL_LIGHTING);
		   OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
			Tessellator ts = Tessellator.instance;
		GL11.glTranslated(x, y, z-0.01D);
		ts.startDrawingQuads();
		bindTexture(Connectors);
		
		
		ts.addVertexWithUV(0, 0, 0, 0, 0);//bottom left texture
		ts.addVertexWithUV(0, 1, 0, 0, 1);//top left
		ts.addVertexWithUV(1, 1, 0,  1, 1);//top right
		ts.addVertexWithUV(1, 0, 0,  1, 0);//bottom right
		ts.draw();
		
	    GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x, -y, -z-0.01D);

			GL11.glPopMatrix();
		
		}
		if(output[TecHelper.SIDE_Z]){
			GL11.glPushMatrix();
			
		    GL11.glDisable(GL11.GL_LIGHTING);
		   OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
			Tessellator ts = Tessellator.instance;
			GL11.glTranslated(x, y, z+1.01);
		ts.startDrawingQuads();
		bindTexture(Connectors);
		
		
		ts.addVertexWithUV(0, 0, 0, 0, 0);//bottom left texture
		ts.addVertexWithUV(1, 0, 0, 0, 1);//top left
		ts.addVertexWithUV(1, 1, 0, 1, 1);//top right
		ts.addVertexWithUV(0, 1, 0, 1, 0);//bottom right
		ts.draw();
		
	    GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x,- y,- z+1.01);

			GL11.glPopMatrix();
		}
		if(output[TecHelper.SIDE_X]){
			GL11.glPushMatrix();
			
		    GL11.glDisable(GL11.GL_LIGHTING);
		   OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
			Tessellator ts = Tessellator.instance;
			GL11.glTranslated(x-0.01, y, z);
		ts.startDrawingQuads();
		bindTexture(Connectors);
		
		
		ts.addVertexWithUV(0, 0, 0, 0, 0);//bottom left texture
		ts.addVertexWithUV(0, 0, 1, 0, 1);//top left
		ts.addVertexWithUV(0, 1, 1, 1, 1);//top right
		ts.addVertexWithUV(0, 1, 0, 1, 0);//bottom right
		ts.draw();
		
	    GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x-0.01,- y,- z);

			GL11.glPopMatrix();
		}
		if(output[TecHelper.SIDE_MX]){
			GL11.glPushMatrix();
			
		    GL11.glDisable(GL11.GL_LIGHTING);
		   OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
			Tessellator ts = Tessellator.instance;
			GL11.glTranslated(x+1.01, y, z);
		ts.startDrawingQuads();
		bindTexture(Connectors);
		
		
		ts.addVertexWithUV(0, 0, 0, 0, 0);//bottom left texture
		ts.addVertexWithUV(0, 1, 0, 0, 1);//top left
		ts.addVertexWithUV(0, 1, 1, 1, 1);//top right
		ts.addVertexWithUV(0, 0, 1, 1, 0);//bottom right
		ts.draw();
		
	    GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x+1.01,- y,- z);

			GL11.glPopMatrix();
		}
	
		}

}
