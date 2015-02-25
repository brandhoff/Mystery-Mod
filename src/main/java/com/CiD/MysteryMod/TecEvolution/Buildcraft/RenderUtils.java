package com.CiD.MysteryMod.TecEvolution.Buildcraft;

import org.lwjgl.opengl.GL11;

public class RenderUtils {

	//FROM BUILDCRAFT
	public static void setGLColorFromInt(int color) {
		float red = (color >> 16 & 255) / 255.0F;
		float green = (color >> 8 & 255) / 255.0F;
		float blue = (color & 255) / 255.0F;
		GL11.glColor4f(red, green, blue, 1.0F);
	}
	
}
