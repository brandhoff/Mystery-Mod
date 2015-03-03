package com.CiD.MysteryMod.TecEvolution.Factory.CraftingTableHook;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class BetterRecipeSorter implements Comparator
{
final BetterCraftingManager betterCraftingManager;

public BetterRecipeSorter(BetterCraftingManager par1BetterCraftingManager)
{
         this.betterCraftingManager = par1BetterCraftingManager;
}

public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
{
         return par1IRecipe instanceof BetterShapelessRecipes && par2IRecipe instanceof BetterShapedRecipes ? 1 : (par2IRecipe instanceof BetterShapelessRecipes && par1IRecipe instanceof BetterShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
}

public int compare(Object par1Obj, Object par2Obj)
{
         return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
}
}