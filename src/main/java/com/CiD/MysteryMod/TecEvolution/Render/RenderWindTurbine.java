package com.CiD.MysteryMod.TecEvolution.Render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;



public class RenderWindTurbine extends TileEntitySpecialRenderer{
	public ResourceLocation ModelTexture;
	public ResourceLocation resModel;
	public IModelCustom Model;
	
	
	public RenderWindTurbine(ResourceLocation texture, ResourceLocation model) {
		ModelTexture = texture;
		resModel = model;
		Model = (IModelCustom) AdvancedModelLoader.loadModel(model);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x,
			double y, double z, float f) {


        doSimpleRender(x, y, z);
        
	}

	public void doSimpleRender(double x, double y , double z){
		GL11.glPushMatrix();
        GL11.glTranslated(x+0.5, y, z+0.5);

        bindTexture(ModelTexture);
        ((IModelCustom) Model).renderAll();

        GL11.glPopMatrix();
	}
	
	
}
