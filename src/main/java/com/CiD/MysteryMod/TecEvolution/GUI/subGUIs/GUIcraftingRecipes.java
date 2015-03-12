package com.CiD.MysteryMod.TecEvolution.GUI.subGUIs;

import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.TecEvolution.Factory.Containers.ContainerRecipesDummy;
import com.CiD.MysteryMod.TecEvolution.Factory.CraftingTableHook.BetterCraftingManager;
import com.CiD.MysteryMod.TecEvolution.Factory.CraftingTableHook.BetterShapedRecipes;

public class GUIcraftingRecipes extends GuiContainer{
private int page;
private EntityPlayer player;
private World world;
private int x,y,z;
private final int maxPages = BetterCraftingManager.getInstance().getRecipeList().size();
	public GUIcraftingRecipes(EntityPlayer player, InventoryPlayer inventory, World world, int i, int j, int k) {
		super(new ContainerRecipesDummy(inventory, world, i, j, k));
		this.player = player;
		this.world = world;
		this.x = i;
		this.y = j;
		this.z = k;
	}
	


	@Override
		public void initGui() {
		super.initGui();
	    buttonList.add(new GuiButton(1, 20, 72, 90, 20, "Next Page"));
	    buttonList.add(new GuiButton(2, 20, 42, 90, 20, "Go back"));
	    buttonList.add(new GuiButton(3, 20, 12, 90, 20, "Back to crafting"));

		}
	@Override
		protected void drawGuiContainerForegroundLayer(int p_146979_1_,
				int p_146979_2_) {
		fontRendererObj.drawString("Page: "+page, guiLeft, guiTop - 50, 0x338234,true);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id){
		case 1:{
			if(page + 1 <= maxPages-1){

				page++;
				break;
			}
		}
		case 2:{
			if(page - 1 >= 0){
				page--;
				break;
			}
		}
		case 3:{

			player.openGui(MysteryMain.instance, GUIHandler.CRAFTING_STATION_GUI_ID, world, x, y, z);
			break;
			}
		}
	}
	@Override
		public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
			// TODO Auto-generated method stub
			super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		
		}
	
	@Override
		public void drawBackground(int p_146278_1_) {
//			super.drawBackground(p_146278_1_);
		}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int par1, int par2) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/CraftingStationGUI.png"));
      
         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
       
     	if(page <= maxPages-1){
			List list = BetterCraftingManager.getInstance().getRecipeList();
			BetterShapedRecipes rec = (BetterShapedRecipes) list.get(page);
			ContainerRecipesDummy container = (ContainerRecipesDummy) inventorySlots;
			container.displayRecp(rec);
			}
		
	}

}
