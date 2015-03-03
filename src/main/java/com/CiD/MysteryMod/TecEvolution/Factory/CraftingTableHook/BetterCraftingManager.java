package com.CiD.MysteryMod.TecEvolution.Factory.CraftingTableHook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class BetterCraftingManager
{
public static final int WILDCARD_VALUE = Short.MAX_VALUE;
private static final BetterCraftingManager instance = new BetterCraftingManager();
private List recipes = new ArrayList();

public static final BetterCraftingManager getInstance()
{
         return instance;
}
/*
 * Erstellt ein 5x5 crafting rezept 
 */
private BetterCraftingManager()
{
	

	
	
	
recipes = new ArrayList();
//func_92051_a(new ItemStack(Basis.PCSupgradecoreblock,1), 
//
// 		  new Object[]{
// 	   "ccccc",
// 	   "ccccc",
// 	   "ccfcc",
// 	   "ccccc",
// 	   "ccccc",
// 	  'c',Basis.Blockhardcobble,'f',Basis.PCSupgradecoreempty
//    });
//func_92051_a(new ItemStack(Basis.PCSupgradecorezombie,1), 
//
//		  new Object[]{
//	   "ddddd",
//	   "ddddd",
//	   "ddfdd",
//	   "ddddd",
//	   "ddddd",
//	  'd',Item.rottenFlesh,'f',Basis.PCSupgradecoreempty
//  });
////func_92051_a(new ItemStack(Basis.PCSupgradecorewonder,64), 
////
////		  new Object[]{
////	   "ddddd",
////	   "ddddd",
////	   "ddfdd",
////	   "ddddd",
////	   "ddddd",
////	  'c',Basis.Blockhardcobble,'f',Basis.PCSupgradecoreempty
////  });
//
//func_92051_a(new ItemStack(Basis.PCSingot,1), 
//
//		  new Object[]{
//	   "ggggg",
//	   "dhhhd",
//	   "ddfdd",
//	   "dhhhd",
//	   "ggggg",
//	  'd',Item.blazePowder,'f',Item.diamond,'g',Item.glowstone,'h',Basis.Blockhardcobble
//});
//
//func_92051_a(new ItemStack(Basis.PCSpick,1), 
//
//		  new Object[]{
//	   "ggggg",
//	   "ttitt",
//	   "ttitt",
//	   "ttitt",
//	   "ttitt",
//	  'd',Item.blazePowder,'i',Block.blockDiamond,'g',Basis.PCSingot,'h',Basis.Blockhardcobble
//});
//
//func_92051_a(new ItemStack(Basis.PCSupgradecore,1), 
//
//		  new Object[]{
//	   "eeeee",
//	   "etrte",
//	   "erdre",
//	   "etrte",
//	   "eeeee",
//	  'd',Block.blockDiamond,'e',Item.emerald,'r',Item.redstone,'h',Basis.Blockhardcobble
//});
//
//func_92051_a(new ItemStack(Basis.PCSupgradecoretransformer,1), 
//
//		  new Object[]{
//	   "eeeee",
//	   "etrte",
//	   "erdre",
//	   "etrte",
//	   "eeeee",
//	  'd',Item.eyeOfEnder,'e',Block.glowStone,'t',Item.redstone,'h',Basis.Blockhardcobble
//});
//
//func_92051_a(new ItemStack(Basis.Objektcompressoraus,1), 
//
//		  new Object[]{
//	   "iiiii",
//	   "igggi",
//	   "igbgi",
//	   "igggi",
//	   "iiiii",
//	  'i',Item.ingotIron,'b',Basis.nucleusore,'g',Block.fenceIron,
//});




Collections.sort(this.recipes, new BetterRecipeSorter(this));
         System.out.println(this.recipes.size() + " recipes");
}

public BetterShapedRecipes func_92051_a(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
{
         String var3 = "";
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;

         if (par2ArrayOfObj[var4] instanceof String[])
         {
                 String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

                 for (int var8 = 0; var8 < var7.length; ++var8)
                 {
                         String var9 = var7[var8];
                         ++var6;
                         var5 = var9.length();
                         var3 = var3 + var9;
                 }
         }
         else
         {
                 while (par2ArrayOfObj[var4] instanceof String)
                 {
                         String var11 = (String)par2ArrayOfObj[var4++];
                         ++var6;
                         var5 = var11.length();
                         var3 = var3 + var11;
                 }
         }

         HashMap var12;

         for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
         {
                 Character var13 = (Character)par2ArrayOfObj[var4];
                 ItemStack var14 = null;

                 if (par2ArrayOfObj[var4 + 1] instanceof Item)
                 {
                         var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
                 }
                 else if (par2ArrayOfObj[var4 + 1] instanceof Block)
                 {
                         var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
                 }
                 else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
                 {
                         var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
                 }

                 var12.put(var13, var14);
         }

         ItemStack[] var15 = new ItemStack[var5 * var6];

         for (int var16 = 0; var16 < var5 * var6; ++var16)
         {
                 char var10 = var3.charAt(var16);

                 if (var12.containsKey(Character.valueOf(var10)))
                 {
                         var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
                 }
                 else
                 {
                         var15[var16] = null;
                 }
         }

         BetterShapedRecipes var17 = new BetterShapedRecipes(var5, var6, var15, par1ItemStack);
         this.recipes.add(var17);
         return var17;
}

public void addBuilderShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
{
         ArrayList var3 = new ArrayList();
         Object[] var4 = par2ArrayOfObj;
         int var5 = par2ArrayOfObj.length;

         for (int var6 = 0; var6 < var5; ++var6)
         {
                 Object var7 = var4[var6];

                 if (var7 instanceof ItemStack)
                 {
                         var3.add(((ItemStack)var7).copy());
                 }
                 else if (var7 instanceof Item)
                 {
                         var3.add(new ItemStack((Item)var7));
                 }
                 else
                 {
                         if (!(var7 instanceof Block))
                         {
                                 throw new RuntimeException("Invalid shapeless recipy!");
                         }

                         var3.add(new ItemStack((Block)var7));
                 }
         }

         this.recipes.add(new BetterShapelessRecipes(par1ItemStack, var3));
}

public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
{
         int var3 = 0;
         ItemStack var4 = null;
         ItemStack var5 = null;
         int var6;

         for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
         {
                 ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

                 if (var7 != null)
                 {
                         if (var3 == 0)
                         {
                                 var4 = var7;
                         }

                         if (var3 == 1)
                         {
                                 var5 = var7;
                         }

                         ++var3;
                 }
         }

         if (var3 == 2 && var4.getItem() == var5.getItem() && var4.stackSize == 1 && var5.stackSize == 1 && var4.getItem().isRepairable())
         {
                 Item var11 = var4.getItem();
                 int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
                 int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
                 int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
                 int var10 = var11.getMaxDamage() - var9;

                 if (var10 < 0)
                 {
                         var10 = 0;
                 }

                 return new ItemStack(var4.getItem(), 1, var10);
         }
         else
         {
                 for (var6 = 0; var6 < this.recipes.size(); ++var6)
                 {
                         IRecipe var12 = (IRecipe)this.recipes.get(var6);

                         if (var12.matches(par1InventoryCrafting, par2World))
                         {
                                 return var12.getCraftingResult(par1InventoryCrafting);
                         }
                 }

                 return null;
         }
}

/**
         * returns the List<> of all recipes
         */
public List getRecipeList()
{
         return this.recipes;
}
}