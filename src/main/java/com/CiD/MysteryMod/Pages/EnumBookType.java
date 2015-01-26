package com.CiD.MysteryMod.Pages;

public enum EnumBookType {
Mystery, Intellegence, Power;


public static final int getTotalPagesByType(EnumBookType type){
	switch(type){
	case Mystery: return BookInfo.TOTAL_MYST_BOOK_PAGES;
	case Intellegence: return BookInfo.TOTAL_MYST_BOOK_PAGES;
	case Power: return BookInfo.TOTAL_MYST_BOOK_PAGES;

	default: return 0;
	}
}

}
