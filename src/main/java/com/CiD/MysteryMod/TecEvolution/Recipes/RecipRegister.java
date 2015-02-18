package com.CiD.MysteryMod.TecEvolution.Recipes;

import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipRegister {

	
	public static void registerAllCraftingRecipies(){

	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.small_cable, 9), new Object[] {"###", "#X#", "###", '#', Blocks.wool, 'X', Items.iron_ingot});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.generator, 1), new Object[] {"#X#", "XXX", "#X#", '#', Items.diamond, '#', TecEvolutionMain.iron_plate});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.battery, 1), new Object[] {"eXe", "e#e", "eXe", '#', TecEvolutionMain.hull, 'X', Items.redstone});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.hull, 1), new Object[] {"XXX", "XXX", "XXX", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.iron_plate});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.solar_generator, 2), new Object[] {"###", "#X#", "###", '#', Blocks.iron_block, 'X', Items.redstone});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.solar_generator, 4), new Object[] {"###", "#X#", "###", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.generator});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.wind_generator, 1), new Object[] {"#X#", "XXX", "#X#", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.generator});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.battery_bundle, 1), new Object[] {"#X#", "#X#", "#X#", '#', TecEvolutionMain.iron_plate, 'X', TecEvolutionMain.battery});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.block_miner, 1), new Object[] {"###", "#X#", "###", '#', TecEvolutionMain.iron_plate, 'X', TecEvolutionMain.bundled_uranium});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.bundled_uranium, 1), new Object[] {"###", "#X#", "###", '#', TecEvolutionMain.hull, 'X', Blocks.diamond_block});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.cable_panel, 1), new Object[] {"###", "#X#", "###", 'o', TecEvolutionMain.hull, 'X', TecEvolutionMain.small_cable});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.small_energy_bank, 1), new Object[] {"###", "#X#", "###", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.battery_bundle});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.nuclear_reactor, 1), new Object[] {"X#X", "#A#", "X##", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.bundled_uranium, 'A', Blocks.diamond_block});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.thorium_pipe, 1), new Object[] {"#X#", "X#X", "#X#", '#', TecEvolutionMain.small_cable, 'X', Blocks.hopper, 'A', Blocks.diamond_block});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.iron_bender, 1), new Object[] {"###", "#X#", "###", '#', Blocks.iron_bars, 'X', Items.diamond_pickaxe, 'A', Blocks.diamond_block});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.pressure_furnace, 1), new Object[] {"###", "#X#", "###", '#', TecEvolutionMain.hull, 'X', TecEvolutionMain.iron_bender, 'A', Blocks.diamond_block});
	CraftingManager.getInstance().addRecipe(new ItemStack(TecEvolutionMain.tec_wrench, 1), new Object[] {"#0#", "0#0", "0#0", '#', TecEvolutionMain.iron_plate, 'X', TecEvolutionMain.iron_bender, 'A', Blocks.diamond_block});

	
	
	}
	
}
