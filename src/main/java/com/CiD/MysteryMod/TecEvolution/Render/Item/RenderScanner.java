package com.CiD.MysteryMod.TecEvolution.Render.Item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderScanner  implements IItemRenderer{


	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
			default: return false;
			case EQUIPPED: return false; 
			case ENTITY: return false; 
			case INVENTORY: return false; 
			case EQUIPPED_FIRST_PERSON: return true;
			case FIRST_PERSON_MAP: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		default: {
			
		}
		case FIRST_PERSON_MAP:{
			if(item.stackTagCompound != null){
				float red = item.stackTagCompound.getFloat("red");
				float green = item.stackTagCompound.getFloat("green");
				float blue = item.stackTagCompound.getFloat("blue");
				GL11.glPushMatrix();
				GL11.glTranslated(10.0d, 3.0d, -10.0d);
//				GL11.glTranslated(1,1,1);

//		        GL11.glRotatef(60.8F*3.5F, 1.7F, 1.0F, 1.5F);
			    GL11.glRotatef(180, 1, 1, 1);
			    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
				GL11.glColor3f(red, green, blue);
				RenderItem renderItem = new RenderItem();
				  IIcon icon = item.getIconIndex();
	              renderItem.renderIcon(0, 0, icon, 16, 16);
					GL11.glPopMatrix();
					break;

			}else{
			GL11.glPushMatrix();
		    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
			GL11.glTranslated(10.0d, 3.0d, -10.0d);
//			GL11.glTranslated(1,1,1);

//	        GL11.glRotatef(60.8F*3.5F, 1.7F, 1.0F, 1.5F);
		    GL11.glRotatef(180, 1, 1, 1);
		    RenderItem renderItem = new RenderItem();
//		    renderItem.renderInFrame = true;
			  IIcon icon = item.getIconIndex();
              renderItem.renderIcon(0, 0, icon, 16, 16);

				GL11.glPopMatrix();
				break;

			}
		}
		
		case ENTITY:{
			if(item.stackTagCompound != null){
				float red = item.stackTagCompound.getFloat("red");
				float green = item.stackTagCompound.getFloat("green");
				float blue = item.stackTagCompound.getFloat("blue");
				GL11.glPushMatrix();
			    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
				GL11.glColor3f(red, green, blue);
				RenderItem renderItem = new RenderItem();
			    renderItem.renderInFrame = true;

				  IIcon icon = item.getIconIndex();
	              renderItem.renderIcon(0, 0, icon, 16, 16);
	  		    renderItem.renderInFrame = false;

					GL11.glPopMatrix();
					break;
			}else{

			GL11.glPushMatrix();

		    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
		    RenderItem renderItem = new RenderItem();
		    renderItem.renderInFrame = true;
			  IIcon icon = item.getIconIndex();
              renderItem.renderIcon(0, 0, icon, 16, 16);
  		    renderItem.renderInFrame = false;

				GL11.glPopMatrix();
				break;

			}
		}

	}
			
	}	



}
