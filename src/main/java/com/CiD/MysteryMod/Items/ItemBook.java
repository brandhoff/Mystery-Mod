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
public ItemPage[] pageAT;
	public ItemBook(String tooltip, EnumBookType bookType, String name) {
		super(tooltip, name);
		bkType = bookType;
		PageNames = new String[bkType.getTotalPagesByType(bkType)];
		HasPage = new boolean[bkType.getTotalPagesByType(bkType)];
		pageAT = new ItemPage[bkType.getTotalPagesByType(bkType)];

	}

	public void addPageToBook(ItemPage page, ItemStack stack, EntityPlayer player){
		if(page.getPageNumber() <= bkType.getTotalPagesByType(bkType)){
			HasPage[page.getPageNumber()] = true;
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setBoolean("HasPage"+page.getPageNumber(), HasPage[page.getPageNumber()]);
//			stack.stackTagCompound.setInteger("ItemPageAt"+page.getPageNumber(), p_74768_2_)
			System.out.println("added page "+page.getPageNumber()+" to the book");
		}
	}
	
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	    itemStack.stackTagCompound = new NBTTagCompound();
	   
	}
}
