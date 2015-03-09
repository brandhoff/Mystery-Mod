package com.CiD.MysteryMod.TecEvolution.Render.Item;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.TecEvolution.Render.ModelInnerBlock;

public class RenderItemPaintModel implements IItemRenderer{
	public ResourceLocation ModelTexture;
	public ResourceLocation resModel;
	private final ModelInnerBlock model = new ModelInnerBlock();
	public TileEntity tile;
	private float red;
	private float green;
	private float blue;
	Random ran = new Random();

	public RenderItemPaintModel(ResourceLocation texture, TileEntity tile){
		this.tile = tile;
		this.ModelTexture = texture;
		red = ran.nextFloat();
		green = ran.nextFloat();
		blue = ran.nextFloat();
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
	
    	if(type == ItemRenderType.EQUIPPED_FIRST_PERSON){
		GL11.glPushMatrix();
		GL11.glTranslatef(0F, -0.75F, 0F);
		GL11.glDisable(GL11.GL_LIGHTING);
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
	    GL11.glColor3f(red,green,blue);
		 Minecraft.getMinecraft().renderEngine.bindTexture(ModelTexture);
		 model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix(); 
        
    	}else{
		GL11.glPushMatrix();
		GL11.glTranslatef(0F, -0.75F, 0F);

		GL11.glDisable(GL11.GL_LIGHTING);
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
	    GL11.glColor3f(red,green,blue);
		 Minecraft.getMinecraft().renderEngine.bindTexture(ModelTexture);
		 model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix(); 
    	}
		
	}
	
	
	
}
