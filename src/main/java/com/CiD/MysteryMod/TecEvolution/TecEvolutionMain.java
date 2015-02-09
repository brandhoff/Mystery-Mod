package com.CiD.MysteryMod.TecEvolution;

import net.minecraft.block.material.Material;

import com.CiD.MysteryMod.TecEvolution.Blocks.BlockCablePanel;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallCable;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallEnergyBank;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSolarGenerator;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockWindGenerator;
import com.CiD.MysteryMod.TecEvolution.Items.ItemBundeledUranium;
import com.CiD.MysteryMod.TecEvolution.Items.ItemWrench;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCablePanel;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

import cpw.mods.fml.common.registry.GameRegistry;

public class TecEvolutionMain {

	public static BlockSolarGenerator solar_generator;
	public static BlockSmallEnergyBank small_energy_bank;
	public static BlockSmallCable small_cable; 
	public static BlockCablePanel cable_panel; 
	public static BlockWindGenerator wind_generator;
	public static BlockNuclearReactor nuclear_reactor;

	
	public static ItemWrench tec_wrench;
	public static ItemBundeledUranium bundled_uranium;
	
	public static void preIni(){
		solar_generator = new BlockSolarGenerator(Material.iron, 2.0F, "solar_generator");
		small_energy_bank = new BlockSmallEnergyBank(Material.iron, 2.0F, "small_energy_bank");
		small_cable = new BlockSmallCable(Material.cloth, 0.2F, "small_cable");
		cable_panel = new BlockCablePanel(Material.cloth, 0.2F, "cable_panel");
		wind_generator = new BlockWindGenerator(Material.iron, 1.0F, "wind_generator");
		nuclear_reactor = new BlockNuclearReactor(Material.rock, 4.0F, null, "nuclear_reactor");
		
		
		tec_wrench = (ItemWrench) new ItemWrench("Set outputs", "tec_wrench").setUnlocalizedName("tec_wrench");
		bundled_uranium = (ItemBundeledUranium) new ItemBundeledUranium("", "bundled_uranium").setUnlocalizedName("bundled_uranium");
		
		
		GameRegistry.registerTileEntity(TileEntityEnergy.class, "MysteryMod_TileEntityEnergy");
		GameRegistry.registerTileEntity(TileEnergyProducer.class, "MysteryMod_TileEnergyProducer");
		GameRegistry.registerTileEntity(TileEntityCable.class, "MysteryMod_TileEntityCable");
		GameRegistry.registerTileEntity(TileEntityStorage.class, "MysteryMod_TileEntityStorage");
		GameRegistry.registerTileEntity(TileEntityCablePanel.class, "MysteryMod_TileEntityCablePanel");
		GameRegistry.registerTileEntity(TileEntityNuclearReactor.class, "MysteryMod_TileEntityNuclearReactor");

	}
	
	public static void Ini(){
		
	}
	
	public static void PostIni(){
		
	}
}
