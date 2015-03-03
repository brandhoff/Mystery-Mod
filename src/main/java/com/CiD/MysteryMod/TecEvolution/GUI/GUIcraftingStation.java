package com.CiD.MysteryMod.TecEvolution.GUI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.TecEvolution.Factory.Containers.ContainerCraftingStation;

public class GUIcraftingStation extends GuiContainer
{
public GUIcraftingStation(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
{
         super(new ContainerCraftingStation(inventoryplayer, world, i, j, k));
}

public void onGuiClosed()
{
         super.onGuiClosed();
}

protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
         this.fontRendererObj.drawString(StatCollector.translateToLocal("\u00a76Better"), 120, 5, 0x404040);
         this.fontRendererObj.drawString(StatCollector.translateToLocal("\u00a76Crafting"), 116, 20, 0x404040);
}

protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
{
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/CraftingStationGUI.png"));
         int l = (width - xSize) / 2;
         int i1 = (height - ySize) / 2;
         drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
}
}