package com.CiD.MysteryMod.GUI.Book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Pages.BookInfo;
import com.CiD.MysteryMod.Pages.PageInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/** mainly from the book class copied ;)*/
public class GUImystBook extends GuiScreen {
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
	private static final int TOTAL_PAGES = BookInfo.TOTAL_MYST_BOOK_PAGES;
	private static final ResourceLocation texture = new ResourceLocation(MysteryMain.MODID+":textures/gui/mystBook.png");
    private GUImystBook.NextPageButton buttonNextPage;
    private GUImystBook.NextPageButton buttonPreviousPage;
    private static final ResourceLocation bookGuiTextures = new ResourceLocation(MysteryMain.MODID+":textures/gui/mystBook.png");

    private GuiButton buttonDone;

	private int currentPage;

	private String pageTitle;

	private EntityPlayer player;
	private ItemStack stack;
	
	private boolean[] hasPage = new boolean[BookInfo.TOTAL_MYST_BOOK_PAGES];
			public GUImystBook(EntityPlayer player, ItemStack stack) {
					this.player = player;
					this.stack = stack;
					if(stack.stackTagCompound != null){
					for(int i = 0; i < this.TOTAL_PAGES; i++){
						hasPage[i] = stack.stackTagCompound.getBoolean("HasPage"+i);
					}
					}
			}
	@Override
    public void initGui()
    {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        

        int i = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.buttonList.add(this.buttonNextPage = new GUImystBook.NextPageButton(1, i + 120, b0 + 174, true));
        this.buttonList.add(this.buttonPreviousPage = new GUImystBook.NextPageButton(2, i + 38, b0 + 174, false));
    }
	
	@Override
	protected void actionPerformed(GuiButton button)
    {
        if (button.enabled){
           
             if (button.id == 1)
            {
                if (this.currentPage < this.TOTAL_PAGES - 1)
                {
                    ++this.currentPage;
                }
            
            }
            else if (button.id == 2)
            {
                if (this.currentPage > 0)
                {
                    --this.currentPage;
                }
            }
          
        }
        
    }
	@Override
	  public void onGuiClosed()
	    {
	        Keyboard.enableRepeatEvents(false);
	    }

    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bookGuiTextures);
        int k = (this.width - this.bookImageWidth) / 2;
        byte b0 = 4;
        this.drawTexturedModalRect(k+16, b0+30, 20, 1, this.bookImageWidth -46, this.bookImageHeight-15);
        String s;
        String s1;
        int l;

        
            s = I18n.format("book.pageIndicator", new Object[] {Integer.valueOf(this.currentPage + 1), Integer.valueOf(this.TOTAL_PAGES)});
            s1 = "";

            if (this.currentPage >= 0 && this.currentPage < this.TOTAL_PAGES)
            {
            	if(hasPage[currentPage]){
            		switch(currentPage){
            		case 1 : s1 = PageInfo.TEXT_PAGE1_SWORD;
            		}
               
            	}else{
            		s1 = EnumChatFormatting.OBFUSCATED + 
            		"asdfghjklqwertzuiop"+
            		"asdfghjklqwertzuiop"+
            		"asdfghjklqwertzuiop"+
            		"asdfghjklqwertzuiop"+
            		"asdfghjklqwertzuiop"+
            		"asdfghjklqwertzuiop"+
            		"asdfghjklqwertzuiop";
            	}
            }

     

            l = this.fontRendererObj.getStringWidth(s);
            this.fontRendererObj.drawString(s, k - l + this.bookImageWidth - 44, b0 + 46, 0);

            this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 46 + 16, 116, 0);
        

        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
    }
	

	    @SideOnly(Side.CLIENT)
	    static class NextPageButton extends GuiButton
	        {
	            private final boolean field_146151_o;

	            public NextPageButton(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_)
	            {
	                super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 13, "");
	                this.field_146151_o = p_i1079_4_;
	            }

	            /**
	             * Draws this button to the screen.
	             */
	            public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	            {
	                if (this.visible)
	                {
	                    boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
	                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	                    p_146112_1_.getTextureManager().bindTexture(GUImystBook.bookGuiTextures);
	                    int k = 0;
	                    int l = 192;

	                    if (flag)
	                    {
	                        k += 23;
	                    }

	                    if (!this.field_146151_o)
	                    {
	                        l += 13;
	                    }

	                    this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
	                }
	            }
	        }
	
	}
