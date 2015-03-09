package com.CiD.MysteryMod.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderTileModelAsItem implements IItemRenderer{
	public ResourceLocation ModelTexture;
	public ResourceLocation resModel;
	public IModelCustom Model;
	public TileEntity tile;
	
	public RenderTileModelAsItem(ResourceLocation modle, ResourceLocation texture, TileEntity tile){
		this.tile = tile;
		this.ModelTexture = texture;
		this.resModel = modle;
		Model = (IModelCustom) AdvancedModelLoader.loadModel(modle);

	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		default: return true;
		case ENTITY: return true;
		case INVENTORY: return true;
		case EQUIPPED: return true;
		case FIRST_PERSON_MAP: return true;

		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0F, -0.5F, 0F);

		 Minecraft.getMinecraft().renderEngine.bindTexture(ModelTexture);
        ((IModelCustom) Model).renderAll();

        GL11.glPopMatrix();
		
	}
	
	
	
}
