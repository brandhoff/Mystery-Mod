package com.CiD.MysteryMod.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Pages.EnumBookType;

public class ItemBook extends BaseItem{
public String[] PageNames;
public boolean[] HasPage;
public EnumBookType bkType;
public ItemStack[] pageAT;
	public ItemBook(String tooltip, EnumBookType bookType) {
		super(tooltip);
		bkType = bookType;
		PageNames = new String[bkType.getTotalPagesByType(bkType)];
		HasPage = new boolean[bkType.getTotalPagesByType(bkType)];
		pageAT = new ItemStack[bkType.getTotalPagesByType(bkType)];

	}

	public void addPageToBook(ItemPage page, ItemStack stack, EntityPlayer player){
		if(page.getPageNumber() <= bkType.getTotalPagesByType(bkType)){
			HasPage[page.getPageNumber()] = true;
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setBoolean("HasPage"+page.getPageNumber(), HasPage[page.getPageNumber()]);
		}
	}
	
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	    itemStack.stackTagCompound = new NBTTagCompound();
	    ItemPage page = (ItemPage) itemStack.getItem();
	    itemStack.stackTagCompound.setString("pageTitle", page.PageTitle);
	    itemStack.stackTagCompound.setInteger("pageNumber", page.pageNumber);

	}
}
