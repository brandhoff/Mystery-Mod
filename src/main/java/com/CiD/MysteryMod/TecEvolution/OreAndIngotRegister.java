package com.CiD.MysteryMod.TecEvolution;

import net.minecraftforge.oredict.OreDictionary;

public class OreAndIngotRegister {

	public static void applyOredic(){
		OreDictionary.registerOre("oreTungsten", TecEvolutionMain.tungsten_ore);
		OreDictionary.registerOre("ingotTungsten", TecEvolutionMain.tungsten_ingot);
		OreDictionary.registerOre("materialBatteryRedstone", TecEvolutionMain.battery);
		OreDictionary.registerOre("materialBatteryGlowstone", TecEvolutionMain.battery_bundle);

	}
	
	
}
