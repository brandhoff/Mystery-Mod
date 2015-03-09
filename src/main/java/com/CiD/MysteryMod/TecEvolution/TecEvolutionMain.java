package com.CiD.MysteryMod.TecEvolution;

import net.minecraft.block.BlockMushroom;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.Items.BaseItem;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockAtomicMiner;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockBender;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockCablePanel;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockColorAble;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockColorTexture;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockCracker;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockDeepBrick;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockMiner;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockPressureFurnace;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallCable;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallEnergyBank;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSolarGenerator;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockTank;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockThoriumPipe;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockWindGenerator;
import com.CiD.MysteryMod.TecEvolution.Factory.Blocks.MultiBlockCraftingStationInterface;
import com.CiD.MysteryMod.TecEvolution.Factory.Blocks.MultiBlockEnergyAcceptor;
import com.CiD.MysteryMod.TecEvolution.Factory.Blocks.MultiBlockFusionReactor;
import com.CiD.MysteryMod.TecEvolution.Factory.Blocks.MultiBlockHull;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFactoryHull;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFusionReactor;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityMultiBlockCraftingStation;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBattery;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBatteryBundle;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBundeledUranium;
import com.CiD.MysteryMod.TecEvolution.Items.ItemDroid;
import com.CiD.MysteryMod.TecEvolution.Items.ItemGenerator;
import com.CiD.MysteryMod.TecEvolution.Items.ItemHull;
import com.CiD.MysteryMod.TecEvolution.Items.ItemInkScanner;
import com.CiD.MysteryMod.TecEvolution.Items.ItemWrench;
import com.CiD.MysteryMod.TecEvolution.Recipes.RecipRegister;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileBaseInventoryMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityAtomicMiner;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityBender;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCablePanel;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColorTexture;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColored;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCracker;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityDeepBrick;
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
//TODO IN DEN CRAFTING HOOK DIE NORMALEN REZP. EINFUEGEN
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
	public static BlockAtomicMiner atomic_miner;
	
	public static BlockThoriumPipe thorium_pipe;
	public static BlockColorAble paint_model;
	public static BlockBase tungsten_ore;
	public static BlockDeepBrick deep_brick;
	public static BlockDeepBrick ripped_quartz;
	public static BlockColorTexture stone_wall;
	public static BlockTank iron_tank;
	
	public static MultiBlockCraftingStationInterface crafting_station;
	public static MultiBlockHull diamond_hull;
	public static MultiBlockHull iron_hull;
	public static MultiBlockEnergyAcceptor great_energy_acceptor;
	public static MultiBlockFusionReactor fusion_reactor;
	
	public static ItemWrench tec_wrench;
	public static ItemBundeledUranium bundled_uranium;
	public static BaseItem iron_plate;
	public static BaseItem tungsten_ingot;
	public static ItemDroid security_droid;
	public static ItemBattery battery;
	public static ItemBatteryBundle battery_bundle;
	public static ItemGenerator generator;
	public static ItemHull hull;
	public static ItemInkScanner ink_scanner;
	
	public static BaseItem red_ink;
	public static BaseItem green_ink;
	public static BaseItem blue_ink;

	public static void preIni(){
		solar_generator = new BlockSolarGenerator(Material.iron, 2.0F, "solar_generator");
		small_energy_bank = new BlockSmallEnergyBank(Material.iron, 2.0F, "small_energy_bank");
		small_cable = new BlockSmallCable(Material.cloth, 0.2F, "small_cable");
		cable_panel = new BlockCablePanel(Material.cloth, 0.2F, "cable_panel");
		wind_generator = new BlockWindGenerator(Material.iron, 1.0F, "wind_generator");
		nuclear_reactor = new BlockNuclearReactor(Material.rock, 4.0F, null, "nuclear_reactor");
		block_miner = new BlockMiner("block_miner");
		iron_bender = new BlockBender("iron_bender");
		pressure_furnace = new BlockPressureFurnace("pressure_furnace");
		stone_cracker = new BlockCracker("stone_cracker");
		atomic_miner = new BlockAtomicMiner("atomic_miner");
		
		thorium_pipe = new BlockThoriumPipe("thorium_pipe");
		paint_model = new BlockColorAble(Material.rock, 1.0F, TileEntityColored.class, "paint_model");
		tungsten_ore = (BlockBase) new BlockBase(Material.rock, 50.0F, TileEntity.class, "tungsten_ore");
		deep_brick = new BlockDeepBrick(Material.glass, 1.0F, TileEntityDeepBrick.class, "deep_brick");
		ripped_quartz = new BlockDeepBrick(Material.glass, 1.0F, TileEntityDeepBrick.class, "ripped_quartz");

		stone_wall = new BlockColorTexture(Material.rock, 58.0F, TileEntityColorTexture.class, "stone_wall");
		iron_tank = (BlockTank) new BlockTank(Material.glass, 1.0F, TileEntityTank.class, "iron_tank");
		
		
		
		crafting_station = new MultiBlockCraftingStationInterface(Material.wood, 1.0F, TileEntityMultiBlockCraftingStation.class, "crafting_station");
		diamond_hull = new MultiBlockHull(Material.iron, 90.0F, TileEntityFactoryHull.class, "diamond_hull");
		iron_hull = new MultiBlockHull(Material.iron, 90.0F, TileEntityFactoryHull.class, "iron_hull");
		great_energy_acceptor = new MultiBlockEnergyAcceptor(Material.iron, 10.0F, TileEntity.class, "great_energy_acceptor");
		fusion_reactor = new MultiBlockFusionReactor(Material.iron, 10.0F, TileEntityFusionReactor.class, "fusion_reactor");

		
		tec_wrench = (ItemWrench) new ItemWrench("Set outputs", "tec_wrench").setUnlocalizedName("tec_wrench");
		bundled_uranium = (ItemBundeledUranium) new ItemBundeledUranium("", "bundled_uranium").setUnlocalizedName("bundled_uranium");
		iron_plate = (BaseItem) new BaseItem("A usefull plate", "iron_plate").setUnlocalizedName("iron_plate");
		tungsten_ingot = (BaseItem) new BaseItem("Took a while smelting this bad boy", "tungsten_ingot").setUnlocalizedName("tungsten_ingot");
		security_droid = (ItemDroid) new ItemDroid("", "security_droid").setUnlocalizedName("security_droid");
		battery = (ItemBattery) new ItemBattery("battery").setUnlocalizedName("battery");
		battery_bundle = (ItemBatteryBundle) new ItemBatteryBundle("battery_bundle").setUnlocalizedName("battery_bundle");
		generator = (ItemGenerator) new ItemGenerator("generator").setUnlocalizedName("generator");
		hull = (ItemHull) new ItemHull("hull").setUnlocalizedName("hull");
		ink_scanner = (ItemInkScanner) new ItemInkScanner("ink_scanner").setUnlocalizedName("ink_scanner");
		
		red_ink = (BaseItem) new BaseItem("typical red ink", "red_ink").setUnlocalizedName("red_ink").setFull3D();
		green_ink = (BaseItem) new BaseItem("typical green ink", "green_ink").setUnlocalizedName("green_ink").setFull3D();
		blue_ink = (BaseItem) new BaseItem("typical blue ink", "blue_ink").setUnlocalizedName("blue_ink").setFull3D();

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
		GameRegistry.registerTileEntity(TileEntityAtomicMiner.class, "MysteryMod_TileEntityAtomicMiner");
		GameRegistry.registerTileEntity(TileEntityColored.class, "MysteryMod_TileEntityColored");
		GameRegistry.registerTileEntity(TileEntityDeepBrick.class, "MysteryMod_TileEntityDeepBrick");
		GameRegistry.registerTileEntity(TileEntityColorTexture.class, "MysteryMod_TileEntityColorTexture");
		GameRegistry.registerTileEntity(TileEntityMultiBlockCraftingStation.class, "MysteryMod_TileEntityMultiBlockCraftingStation");
		GameRegistry.registerTileEntity(TileEntityFactoryHull.class, "MysteryMod_TileEntityFactoryHull");
		GameRegistry.registerTileEntity(TileEntityFusionReactor.class, "MysteryMod_TileEntityFusionReactor");

	}
	
	public static void Ini(){
		RecipRegister.registerAllCraftingRecipies();
	}
	
	public static void PostIni(){
		
	}
}
