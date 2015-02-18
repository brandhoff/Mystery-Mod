package com.CiD.MysteryMod.TecEvolution.Recipes;

import java.util.ArrayList;
import java.util.List;

import com.CiD.MysteryMod.TecEvolution.TecDATA;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeCracker extends Recipe{

	
	@Override
	public boolean isUseable(Item item) {
		if(item == Item.getItemFromBlock(Blocks.cobblestone) ){
			return true;	
		}
		if(item == Item.getItemFromBlock(Blocks.stone) ){
			return true;	
		}
		if(item == Item.getItemFromBlock(Blocks.sand) ){
			return true;	
		}
		return false;
	}
	
	@Override
	public int getBurningTime(Item item) {
		if(item == Item.getItemFromBlock(Blocks.cobblestone) ){
			return TecDATA.CRACKER_BURNING_TIME[TecDATA.CRACKER_TO_SAND];
		}
		if(item == Item.getItemFromBlock(Blocks.stone) ){
			return TecDATA.CRACKER_BURNING_TIME[TecDATA.CRACKER_TO_CUBBLE];
		}
		if(item == Item.getItemFromBlock(Blocks.sand) ){
			return TecDATA.CRACKER_BURNING_TIME[TecDATA.CRACKER_TO_DIRT];
		}
		return -1;
	}
	
	@Override
	public List<ItemStack> getResult(Item item) {
		List<ItemStack> reStack = new ArrayList<ItemStack>();
		if(isUseable(item)){
			if(item == Item.getItemFromBlock(Blocks.cobblestone) ){
				reStack.add(new ItemStack(Blocks.sand, 2));
				return reStack;	
			}
			if(item == Item.getItemFromBlock(Blocks.stone) ){
				reStack.add(new ItemStack(Blocks.cobblestone, 1));
				return reStack;	
			}
			if(item == Item.getItemFromBlock(Blocks.sand) ){
				reStack.add(new ItemStack(Blocks.dirt, 2));
				return reStack;	
			}
		}
		return reStack;
	}
	
}
