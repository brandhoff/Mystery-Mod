package com.CiD.MysteryMod.Render;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Mobs.EntityChiGuard;

import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderChiGuard extends RenderEntity{
	public ResourceLocation ModelTexture;
	public ResourceLocation resModel;
	public ResourceLocation mainBody = new ResourceLocation(MysteryMain.MODID+":textures/model/Chi_Guard_main_part.obj");

	public IModelCustom Model;
	public IModelCustom mainModel;

	public RenderChiGuard(ResourceLocation texture, ResourceLocation model) {
		
		ModelTexture = texture;
		resModel = model;
		Model = (IModelCustom) AdvancedModelLoader.loadModel(model);
//		mainModel = (IModelCustom) AdvancedModelLoader.loadModel(mainBody);

	}
	@Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
		EntityChiGuard ev = (EntityChiGuard)entity;
		GL11.glPushMatrix();
        GL11.glTranslated(x, y+0.3, z);
        GL11.glColor3f(0.0F, 0.3F, 0.7F);
        GL11.glRotated(ev.getRenderTick(), 0, 1, 0);

        bindTexture(ModelTexture);
        ((IModelCustom) Model).renderAll();


        GL11.glPopMatrix();
	}
}
