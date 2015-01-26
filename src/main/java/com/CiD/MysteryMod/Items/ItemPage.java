package com.CiD.MysteryMod.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Pages.EnumBookType;

public class ItemPage extends BaseItem{
public EnumBookType bktype;
public int pageNumber;
public String PageTitle;
	public ItemPage(String tooltip, EnumBookType bookType, int PageNumber, String PageTitle) {
		super(tooltip);

		
	}
	@Override
		public void onUpdate(ItemStack stack, World world,
				Entity entity, int p_77663_4_, boolean p_77663_5_) {
			super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
			if(!stack.stackTagCompound.hasKey("pageTitle")){
				if(entity instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer)entity;
					onCreated(stack, world, player);
				}
			}
		}
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		System.out.println("added nbt");
	    itemStack.stackTagCompound = new NBTTagCompound();
	    ItemPage page = (ItemPage) itemStack.getItem();
	    itemStack.stackTagCompound.setString("pageTitle", page.PageTitle);
	    itemStack.stackTagCompound.setInteger("pageNumber", page.pageNumber);

	}
	
	public int getPageNumber(){
		return this.pageNumber;
	}
	
	public EnumBookType getType(){
		return this.bktype;
	}
	
	public String getTitle(){
		return this.PageTitle;
	}
}
