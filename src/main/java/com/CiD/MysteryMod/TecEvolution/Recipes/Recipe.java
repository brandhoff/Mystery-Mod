package com.CiD.MysteryMod.TecEvolution.Recipes;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Recipe {

	
	public Recipe() {

	}
	
	
	public boolean isUseable(Item item){
		return false;
	}
	
	public int getBurningTime(Item item){
		return 0;
	}
	
	public List<ItemStack> getResult(Item item){
		
		return null;
	}
	
}
