package com.CiD.MysteryMod.Render;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

public class RenderGreenCrystal extends TileModelRender{
private int render;

	public RenderGreenCrystal(ResourceLocation texture, ResourceLocation model) {
		super(texture, model);

	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float f) {
		Tessellator tessellator = Tessellator.instance;
		TileEntityGreenCrystal tl = (TileEntityGreenCrystal) tile;
		GL11.glPushMatrix();
        GL11.glTranslated(x+0.555, y, z+0.5);
        GL11.glRotatef(tl.getRendertick(), 0, 1, 0);
 
        GL11.glColor3f(0.1F, 0.8F, 0.2F);
        bindTexture(ModelTexture);
       ((IModelCustom) Model).renderAll();

        GL11.glTranslated(-x-0.5, -y, -z-0.5);


        GL11.glPopMatrix();
        
        
        
        
        
        
        //BEACON BEAM
//        if(tl.isActive()){
//             GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
//
//             if (1 > 0.0F)
//             {
//                 this.bindTexture(field_147523_b);
//                 GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
//                 GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
//                 GL11.glDisable(GL11.GL_LIGHTING);
//                 GL11.glDisable(GL11.GL_CULL_FACE);
//                 GL11.glDisable(GL11.GL_BLEND);
//                 GL11.glDepthMask(true);
//                 OpenGlHelper.glBlendFunc(770, 1, 1, 0);
//                 float f2 = (float)tile.getWorldObj().getTotalWorldTime() + f;
//                 float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
//                 byte b0 = 1;
//                 double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
//                 tessellator.startDrawingQuads();
//                 tessellator.setColorRGBA(255, 255, 255, 32);
//                 double d5 = (double)b0 * 0.2D;
//                 double d7 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d5;
//                 double d9 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d5;
//                 double d11 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d5;
//                 double d13 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d5;
//                 double d15 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d5;
//                 double d17 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d5;
//                 double d19 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d5;
//                 double d21 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d5;
//                 double d23 = (double)(256.0F * 1);
//                 double d25 = 0.0D;
//                 double d27 = 1.0D;
//                 double d28 = (double)(-1.0F + f3);
//                 double d29 = (double)(256.0F * 1) * (0.5D / d5) + d28;
//                 tessellator.addVertexWithUV(x + d7, y +2+ d23, z + d9, d27, d29);
//                 tessellator.addVertexWithUV(x + d7, y+2, z + d9, d27, d28);
//                 tessellator.addVertexWithUV(x + d11, y+2, z + d13, d25, d28);
//                 tessellator.addVertexWithUV(x + d11, y+2 + d23, z + d13, d25, d29);
//                 tessellator.addVertexWithUV(x + d19, y +2+ d23, z + d21, d27, d29);
//                 tessellator.addVertexWithUV(x + d19, y+2, z + d21, d27, d28);
//                 tessellator.addVertexWithUV(x + d15, y+2, z + d17, d25, d28);
//                 tessellator.addVertexWithUV(x + d15, y +2+ d23, z + d17, d25, d29);
//                 tessellator.addVertexWithUV(x + d11, y+2 + d23, z + d13, d27, d29);
//                 tessellator.addVertexWithUV(x + d11, y+2, z + d13, d27, d28);
//                 tessellator.addVertexWithUV(x + d19, y+2, z + d21, d25, d28);
//                 tessellator.addVertexWithUV(x + d19, y+2 + d23, z + d21, d25, d29);
//                 tessellator.addVertexWithUV(x + d15, y+2 + d23, z + d17, d27, d29);
//                 tessellator.addVertexWithUV(x + d15, y+2, z + d17, d27, d28);
//                 tessellator.addVertexWithUV(x + d7, y+2, z + d9, d25, d28);
//                 tessellator.addVertexWithUV(x + d7, y+2 + d23, z + d9, d25, d29);
//                 tessellator.draw();
//                 GL11.glEnable(GL11.GL_BLEND);
//                 OpenGlHelper.glBlendFunc(770, 771, 1, 0);
//                 GL11.glDepthMask(false);
//                 tessellator.startDrawingQuads();
//                 tessellator.setColorRGBA(255, 255, 255, 32);
//                 double d30 = 0.2D;
//                 double d4 = 0.2D;
//                 double d6 = 0.8D;
//                 double d8 = 0.2D;
//                 double d10 = 0.2D;
//                 double d12 = 0.8D;
//                 double d14 = 0.8D;
//                 double d16 = 0.8D;
//                 double d18 = (double)(256.0F * 1);
//                 double d20 = 0.0D;
//                 double d22 = 1.0D;
//                 double d24 = (double)(-1.0F + f3);
//                 double d26 = (double)(256.0F * 1) + d24;
//                 tessellator.addVertexWithUV(x + d30, y+2 + d18, z + d4, d22, d26);
//                 tessellator.addVertexWithUV(x + d30, y+2, z + d4, d22, d24);
//                 tessellator.addVertexWithUV(x + d6, y+2, z + d8, d20, d24);
//                 tessellator.addVertexWithUV(x + d6, y+2 + d18, z + d8, d20, d26);
//                 tessellator.addVertexWithUV(x + d14, y+2 + d18, z + d16, d22, d26);
//                 tessellator.addVertexWithUV(x + d14, y+2, z + d16, d22, d24);
//                 tessellator.addVertexWithUV(x + d10, y+2, z + d12, d20, d24);
//                 tessellator.addVertexWithUV(x + d10, y+2 + d18, z + d12, d20, d26);
//                 tessellator.addVertexWithUV(x + d6, y+2 + d18, z + d8, d22, d26);
//                 tessellator.addVertexWithUV(x + d6, y+2, z + d8, d22, d24);
//                 tessellator.addVertexWithUV(x + d14, y+2, z + d16, d20, d24);
//                 tessellator.addVertexWithUV(x + d14, y +2+ d18, z + d16, d20, d26);
//                 tessellator.addVertexWithUV(x + d10, y+2 + d18, z + d12, d22, d26);
//                 tessellator.addVertexWithUV(x + d10, y+2, z + d12, d22, d24);
//                 tessellator.addVertexWithUV(x + d30, y+2, z + d4, d20, d24);
//                 tessellator.addVertexWithUV(x + d30, y+2 + d18, z + d4, d20, d26);
//                 tessellator.draw();
//                 GL11.glEnable(GL11.GL_LIGHTING);
//                 GL11.glEnable(GL11.GL_TEXTURE_2D);
//                 GL11.glDepthMask(true);
//             }
//        }               
//        
	}
}
