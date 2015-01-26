package com.CiD.MysteryMod.Items;

import com.CiD.MysteryMod.Pages.BookInfo;
import com.CiD.MysteryMod.Pages.EnumBookType;

public class ItemMystBook extends ItemBook{

	public ItemMystBook(String tooltip) {
		super(tooltip, EnumBookType.Mystery);
		PageNames = new String[BookInfo.TOTAL_MYST_BOOK_PAGES];
		HasPage = new boolean[BookInfo.TOTAL_MYST_BOOK_PAGES];

	}

	
	
	
}
