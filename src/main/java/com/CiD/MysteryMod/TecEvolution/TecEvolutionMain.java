package com.CiD.MysteryMod.TecEvolution;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.Items.BaseItem;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockBender;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockCablePanel;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockCracker;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockMiner;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockPressureFurnace;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallCable;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallEnergyBank;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSolarGenerator;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockTank;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockThoriumPipe;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockWindGenerator;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBattery;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBatteryBundle;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBundeledUranium;
import com.CiD.MysteryMod.TecEvolution.Items.ItemDroid;
import com.CiD.MysteryMod.TecEvolution.Items.ItemGenerator;
import com.CiD.MysteryMod.TecEvolution.Items.ItemHull;
import com.CiD.MysteryMod.TecEvolution.Items.ItemWrench;
import com.CiD.MysteryMod.TecEvolution.Recipes.RecipRegister;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileBaseInventoryMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityBender;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCablePanel;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCracker;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMiner;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityPressureFurnace;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityTank;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityThoriumPipe;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityWindTurbine;

import cpw.mods.fml.common.registry.GameRegistry;

public class TecEvolutionMain {

	public static BlockSolarGenerator solar_generator;
	public static BlockSmallEnergyBank small_energy_bank;
	public static BlockSmallCable small_cable; 
	public static BlockCablePanel cable_panel; 
	public static BlockWindGenerator wind_generator;
	public static BlockNuclearReactor nuclear_reactor;
	public static BlockMiner block_miner;
	public static BlockBender iron_bender;
	public static BlockPressureFurnace pressure_furnace;
	public static BlockCracker stone_cracker;

	
	public static BlockThoriumPipe thorium_pipe;
	
	public static BlockBase tungsten_ore;
	
	public static BlockTank iron_tank;
	
//	public static BlockMachineBase base_machine;
	
	public static ItemWrench tec_wrench;
	public static ItemBundeledUranium bundled_uranium;
	public static BaseItem iron_plate;
	public static BaseItem tungsten_ingot;
	public static ItemDroid security_droid;
	public static ItemBattery battery;
	public static ItemBatteryBundle battery_bundle;
	public static ItemGenerator generator;
	public static ItemHull hull;
	
	
	public static void preIni(){
		solar_generator = new BlockSolarGenerator(Material.iron, 2.0F, "solar_generator");
		small_energy_bank = new BlockSmallEnergyBank(Material.iron, 2.0F, "small_energy_bank");
		small_cable = new BlockSmallCable(Material.cloth, 0.2F, "small_cable");
		cable_panel = new BlockCablePanel(Material.cloth, 0.2F, "cable_panel");
		wind_generator = new BlockWindGenerator(Material.iron, 1.0F, "wind_generator");
		nuclear_reactor = new BlockNuclearReactor(Material.rock, 4.0F, null, "nuclear_reactor");
//		base_machine = new BlockMachineBase(Material.iron, 4.0F, TileEntityMachine.class, "base_machine");
		block_miner = new BlockMiner("block_miner");
		iron_bender = new BlockBender("iron_bender");
		pressure_furnace = new BlockPressureFurnace("pressure_furnace");
		stone_cracker = new BlockCracker("stone_cracker");
		
		thorium_pipe = new BlockThoriumPipe("thorium_pipe");
		
		tungsten_ore = (BlockBase) new BlockBase(Material.rock, 50.0F, TileEntity.class, "tungsten_ore");
		
		iron_tank = (BlockTank) new BlockTank(Material.glass, 1.0F, TileEntityTank.class, "iron_tank");
		
		tec_wrench = (ItemWrench) new ItemWrench("Set outputs", "tec_wrench").setUnlocalizedName("tec_wrench");
		bundled_uranium = (ItemBundeledUranium) new ItemBundeledUranium("", "bundled_uranium").setUnlocalizedName("bundled_uranium");
		iron_plate = (BaseItem) new BaseItem("A usefull plate", "iron_plate").setUnlocalizedName("iron_plate");
		tungsten_ingot = (BaseItem) new BaseItem("Took a while smelting this bad boy", "tungsten_ingot").setUnlocalizedName("tungsten_ingot");
		security_droid = (ItemDroid) new ItemDroid("", "security_droid").setUnlocalizedName("security_droid");
		battery = (ItemBattery) new ItemBattery("battery").setUnlocalizedName("battery");
		battery_bundle = (ItemBatteryBundle) new ItemBatteryBundle("battery_bundle").setUnlocalizedName("battery_bundle");
		generator = (ItemGenerator) new ItemGenerator("generator").setUnlocalizedName("generator");
		hull = (ItemHull) new ItemHull("hull").setUnlocalizedName("hull");

		
		GameRegistry.registerTileEntity(TileEntityEnergy.class, "MysteryMod_TileEntityEnergy");
		GameRegistry.registerTileEntity(TileEnergyProducer.class, "MysteryMod_TileEnergyProducer");
		GameRegistry.registerTileEntity(TileEntityCable.class, "MysteryMod_TileEntityCable");
		GameRegistry.registerTileEntity(TileEntityStorage.class, "MysteryMod_TileEntityStorage");
		GameRegistry.registerTileEntity(TileEntityCablePanel.class, "MysteryMod_TileEntityCablePanel");
		GameRegistry.registerTileEntity(TileEntityNuclearReactor.class, "MysteryMod_TileEntityNuclearReactor");
		GameRegistry.registerTileEntity(TileEntityMachine.class, "MysteryMod_TileEntityMachine");
		GameRegistry.registerTileEntity(TileEntityWindTurbine.class, "MysteryMod_TileEntityWindTurbine");
		GameRegistry.registerTileEntity(TileEntityMiner.class, "MysteryMod_TileEntityMiner");
		GameRegistry.registerTileEntity(TileBaseInventoryMachine.class, "MysteryMod_TileBaseInventoryMachine");
		GameRegistry.registerTileEntity(TileEntityBender.class, "MysteryMod_TileEntityBender");
		GameRegistry.registerTileEntity(TileEntityPressureFurnace.class, "MysteryMod_TileEntityPressureFurnace");
		GameRegistry.registerTileEntity(TileEntityCracker.class, "MysteryMod_TileEntityCracker");
		GameRegistry.registerTileEntity(TileEntityThoriumPipe.class, "MysteryMod_TileEntityThoriumPipe");
		GameRegistry.registerTileEntity(TileEntityTank.class, "MysteryMod_TileEntityTank");

	}
	
	public static void Ini(){
		RecipRegister.registerAllCraftingRecipies();
	}
	
	public static void PostIni(){
		
	}
}
