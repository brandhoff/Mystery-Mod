package com.CiD.MysteryMod.TecEvolution;

import net.minecraft.block.material.Material;

import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallCable;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSmallEnergyBank;
import com.CiD.MysteryMod.TecEvolution.Blocks.BlockSolarGenerator;
import com.CiD.MysteryMod.TecEvolution.Items.ItemWrench;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

import cpw.mods.fml.common.registry.GameRegistry;

public class TecEvolutionMain {

	public static BlockSolarGenerator solar_generator;
	public static BlockSmallEnergyBank small_energy_bank;
	public static BlockSmallCable small_cable; 
	
	public static ItemWrench tec_wrench;
	
	public static void preIni(){
		solar_generator = new BlockSolarGenerator(Material.iron, 2.0F, "solar_generator");
		small_energy_bank = new BlockSmallEnergyBank(Material.iron, 2.0F, "small_energy_bank");
		small_cable = new BlockSmallCable(Material.cloth, 0.2F, "small_cable");
		
		
		tec_wrench = (ItemWrench) new ItemWrench("Set outputs", "tec_wrench").setUnlocalizedName("tec_wrench");
		
		GameRegistry.registerTileEntity(TileEntityEnergy.class, "MysteryMod_TileEntityEnergy");
		GameRegistry.registerTileEntity(TileEnergyProducer.class, "MysteryMod_TileEnergyProducer");
		GameRegistry.registerTileEntity(TileEntityCable.class, "MysteryMod_TileEntityCable");

	}
	
	public static void Ini(){
		
	}
	
	public static void PostIni(){
		
	}
}
