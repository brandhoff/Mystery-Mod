package com.CiD.MysteryMod.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Pages.BookInfo;
import com.CiD.MysteryMod.Pages.EnumBookType;

public class ItemMystBook extends ItemBook{

	public ItemMystBook(String tooltip, String name) {
		super(tooltip, EnumBookType.Mystery, name);
		PageNames = new String[BookInfo.TOTAL_MYST_BOOK_PAGES];
		HasPage = new boolean[BookInfo.TOTAL_MYST_BOOK_PAGES];

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		player.openGui(MysteryMain.instance, GUIHandler.MYSTBOOK_GUI_ID, world,(int) player.posX, (int) player.posY, (int) player.posZ);
		
		
		return stack;
	}
	
	
}
