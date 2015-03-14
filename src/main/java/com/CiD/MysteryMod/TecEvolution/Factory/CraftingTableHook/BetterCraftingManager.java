package com.CiD.MysteryMod.TecEvolution.Factory.CraftingTableHook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;

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
addCraftingRe(new ItemStack(TecEvolutionMain.fusion_reactor,1), 

 		  new Object[]{
 	   "gdtdg",
 	   "gdtdg",
 	   "gdadg",
 	   "gdtdg",
 	   "gdtdg",
 	  'a',TecEvolutionMain.nuclear_reactor,'g',TecEvolutionMain.atomic_miner,'d',TecEvolutionMain.diamond_hull,'t',TecEvolutionMain.bundled_uranium
    });

addCraftingRe(new ItemStack(TecEvolutionMain.diamond_hull,2), 

		  new Object[]{
	   "ccicc",
	   "ccicc",
	   "iifii",
	   "ccicc",
	   "ccicc",
	  'c',TecEvolutionMain.tungsten_ingot, 'f',Blocks.diamond_block,'i',Items.iron_ingot
  });
addCraftingRe(new ItemStack(TecEvolutionMain.small_cable, 9), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', Blocks.wool, 'X', Items.iron_ingot});
addCraftingRe(new ItemStack(TecEvolutionMain.generator, 1), new Object[] {"00000","0#X#0", "0XXX0", "0#X#0","00000", 'X', Items.redstone, '#', TecEvolutionMain.iron_plate});
addCraftingRe(new ItemStack(TecEvolutionMain.battery, 1), new Object[] {"00000","0eXe0", "0e#e0", "0eXe0","00000", '#', TecEvolutionMain.hull, 'X', Items.redstone});
addCraftingRe(new ItemStack(TecEvolutionMain.hull, 1), new Object[] {"00000","0XXX0", "0XXX0", "0XXX0","00000", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.iron_plate});
addCraftingRe(new ItemStack(TecEvolutionMain.solar_generator, 2), new Object[] {"00000","0###0", "0AXA0", "0AAA0","00000", '#', Blocks.iron_bars, 'X', Items.redstone, 'A', Items.iron_ingot});
addCraftingRe(new ItemStack(TecEvolutionMain.solar_generator, 4), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.generator});
addCraftingRe(new ItemStack(TecEvolutionMain.wind_generator, 1), new Object[] {"00000","0#X#0", "0XXX0", "0#X#0","00000", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.generator});
addCraftingRe(new ItemStack(TecEvolutionMain.battery_bundle, 1), new Object[] {"00000","0#X#0", "0#X#0", "0#X#0","00000", '#', TecEvolutionMain.iron_plate, 'X', TecEvolutionMain.battery});
addCraftingRe(new ItemStack(TecEvolutionMain.block_miner, 1), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', TecEvolutionMain.iron_plate, 'X', TecEvolutionMain.bundled_uranium});
addCraftingRe(new ItemStack(TecEvolutionMain.bundled_uranium, 1), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', TecEvolutionMain.hull, 'X', Blocks.diamond_block});
addCraftingRe(new ItemStack(TecEvolutionMain.cable_panel, 1), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", 'o', TecEvolutionMain.hull, 'X', TecEvolutionMain.small_cable});
addCraftingRe(new ItemStack(TecEvolutionMain.small_energy_bank, 1), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.battery_bundle});
addCraftingRe(new ItemStack(TecEvolutionMain.nuclear_reactor, 1), new Object[] {"00000","0X#X0", "0#A#0", "0X##0","00000", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.bundled_uranium, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(TecEvolutionMain.thorium_pipe, 1), new Object[] {"00000","0#X#0", "0X#X0", "0#X#0","00000", '#', TecEvolutionMain.small_cable, 'X', Blocks.hopper, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(TecEvolutionMain.iron_bender, 1), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', Blocks.iron_bars, 'X', Items.diamond_pickaxe, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(TecEvolutionMain.pressure_furnace, 1), new Object[] {"00000","0###0", "0#X#0", "0###0","00000", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.iron_bender, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(TecEvolutionMain.tec_wrench, 1), new Object[] {"00000","0#0#0", "00#00", "00#00","00000", '#', TecEvolutionMain.iron_plate, 'X', TecEvolutionMain.iron_bender, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(MysteryMain.block_lift, 1), new Object[] {"00000","0###0", "0Z#Z0", "0###0","00000", '#', Blocks.piston, 'Z', TecEvolutionMain.iron_plate, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(MysteryMain.swift_stone, 32), new Object[] {"00000","0###0", "0#Z#0", "0###0","00000", '#', Blocks.stone, 'Z', TecEvolutionMain.hull, 'A', Blocks.diamond_block});
addCraftingRe(new ItemStack(TecEvolutionMain.ripped_quartz,16), 
		  new Object[]{
	   "00000",
	   "00q00",
	   "0qdq0",
	   "00q00",
	   "00000",
	  'd',Items.dye, 'q',Blocks.quartz_block,'i',Items.iron_ingot
});
addCraftingRe(new ItemStack(TecEvolutionMain.blue_ink,1), 
		  new Object[]{
	   "00i00",
	   "00q00",
	   "iqdqi",
	   "00q00",
	   "00i00",
	  'd',Items.water_bucket, 'q',Items.dye,'i',Items.fish
});
addCraftingRe(new ItemStack(TecEvolutionMain.red_ink,1), 
		  new Object[]{
	   "00i00",
	   "00q00",
	   "iqdqi",
	   "00q00",
	   "00i00",
	  'd',Items.water_bucket, 'q',Items.dye,'i',Items.carrot
});
addCraftingRe(new ItemStack(TecEvolutionMain.green_ink,1), 
		  new Object[]{
	   "00i00",
	   "00q00",
	   "iqdqi",
	   "00q00",
	   "00i00",
	  'd',Items.water_bucket, 'q',Items.dye,'i',Blocks.cactus
});
addCraftingRe(new ItemStack(TecEvolutionMain.blue_ink,1), 
		  new Object[]{
	   "00i00",
	   "00q00",
	   "iqdqi",
	   "00q00",
	   "00i00",
	  'd',Items.water_bucket, 'q',Items.dye,'i',Items.fish
});
addCraftingRe(new ItemStack(TecEvolutionMain.ink_scanner,1), 
		  new Object[]{
	   "00i00",
	   "0ggg0",
	   "igggi",
	   "0ggg0",
	   "00i00",
	  'g',Blocks.glass, 'i',Items.iron_ingot,'l',Items.fish
});

addCraftingRe(new ItemStack(TecEvolutionMain.atomic_miner,1), 
		  new Object[]{
	   "00i00",
	   "0g0g0",
	   "i000i",
	   "ddddd",
	   "mmmmm",
	  'g',Blocks.glass, 'i',Items.iron_ingot,'d',TecEvolutionMain.diamond_hull,'m',TecEvolutionMain.block_miner
});

Collections.sort(this.recipes, new BetterRecipeSorter(this));
         System.out.println(this.recipes.size() + " recipes");
}

public BetterShapedRecipes addCraftingRe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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