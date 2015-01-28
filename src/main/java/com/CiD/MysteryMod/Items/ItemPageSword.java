package com.CiD.MysteryMod.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Pages.EnumBookType;

public class ItemPageSword extends ItemPage{

	public ItemPageSword(String tooltip, EnumBookType bookType, int PageNumber,
			String PageTitle, String name) {
		super(tooltip, bookType, 1, "The mystery of the sword", name);
	}


	@Override
		public ItemStack onItemRightClick(ItemStack stack, World world,
				EntityPlayer player) {
		if(!world.isRemote){
			if(player.inventory.hasItem(MysteryMain.book_mystery)){
				for(int i = 0; i < 35;i++){
					if(player.inventory.getStackInSlot(i) != null&&player.inventory.getStackInSlot(i).getItem() != null&&player.inventory.getStackInSlot(i).getItem() == MysteryMain.book_mystery){
						ItemMystBook book = (ItemMystBook)player.inventory.getStackInSlot(i).getItem();
						ItemStack BookStack = player.inventory.getStackInSlot(i);
						if(BookStack.stackTagCompound == null){
							// && !BookStack.stackTagCompound.getBoolean("HasPage"+MysteryMain.page_sword.pageNumber)){
						book.addPageToBook(MysteryMain.page_sword, player.inventory.getStackInSlot(i), player);
						return super.onItemRightClick(stack, world, player);
						}else if(BookStack.stackTagCompound != null && !BookStack.stackTagCompound.getBoolean("HasPage"+MysteryMain.page_sword.pageNumber)){
							book.addPageToBook(MysteryMain.page_sword, player.inventory.getStackInSlot(i), player);
							return super.onItemRightClick(stack, world, player);
						}
					}
				}
			}
		}
			return stack;
		}
	
	
}
