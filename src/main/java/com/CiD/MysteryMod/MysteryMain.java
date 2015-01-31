package com.CiD.MysteryMod;



import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.CiD.MysteryMod.Blocks.BlockGreenCrystal;
import com.CiD.MysteryMod.Blocks.BlockLift;
import com.CiD.MysteryMod.Blocks.BlockSwiftStone;
import com.CiD.MysteryMod.Items.ItemChiSword;
import com.CiD.MysteryMod.Items.ItemDebug;
import com.CiD.MysteryMod.Items.ItemMystBook;
import com.CiD.MysteryMod.Items.ItemPageSword;
import com.CiD.MysteryMod.Mobs.EntityChiGuard;
import com.CiD.MysteryMod.Network.PacketDispatcher;
import com.CiD.MysteryMod.Network.packet.PacketPipeline;
import com.CiD.MysteryMod.Pages.EnumBookType;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;
import com.CiD.MysteryMod.TileEntity.TileEntityLift;
import com.CiD.MysteryMod.TileEntity.TileSwiftStone;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = MysteryMain.MODID, version = MysteryMain.VERSION)




public class MysteryMain
{
	@SidedProxy(clientSide="com.CiD.MysteryMod.client" , serverSide="com.CiD.MysteryMod.common")
	public static common proxy;
public static final PacketPipeline packetPipeline = new PacketPipeline();
public static final String MODID = "MysteryMod";
public static final String VERSION = "0.1";
public static final String CHANNEL = "MysteryMod";



@Instance
public static MysteryMain instance = new MysteryMain();
public static ChannelHandler channelHandler;



public static CreativeTabs block_tab = new CreativeTabs(14,"MysteryMod Blocks") {
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {

		return Items.apple;
	}
};
public static CreativeTabs item_tab = new CreativeTabs(13,"MysteryMod Items") {
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {

		return Items.apple;
	}
};

//Blocks
public static BlockGreenCrystal green_crystal;
public static BlockLift block_lift;
public static BlockSwiftStone swift_stone;

//ITEMS
public static ItemChiSword chi_sword;

public static ItemMystBook book_mystery;



public static ItemPageSword page_sword;


public static ItemDebug debug_item;


@EventHandler
public void preInit(FMLPreInitializationEvent event){    
	green_crystal = (BlockGreenCrystal) new BlockGreenCrystal(Material.iron, 1.0F, TileEntityGreenCrystal.class, "Green_crystal").setLightOpacity(10).setResistance(1).setLightLevel(1);


	block_lift = (BlockLift) new BlockLift(TileEntityLift.class, "block_lift");
	
	swift_stone = (BlockSwiftStone) new BlockSwiftStone(Material.iron, 0.8F, TileSwiftStone.class, "swift_stone");
	
	
	chi_sword = (ItemChiSword) new ItemChiSword("chi_sword").setUnlocalizedName("chi_sword");
	
	book_mystery = (ItemMystBook) new ItemMystBook("","book_mystery").setUnlocalizedName("book_mystery");
	
	
	page_sword = (ItemPageSword) new ItemPageSword("", EnumBookType.Mystery, 1, "", "Page_sword").setUnlocalizedName("Page_sword");
	
	
	
	
	
	
	
	
	debug_item = (ItemDebug) new ItemDebug("Plz dont use", "debug_item").setUnlocalizedName("debug_item");
	
	
	
	
	
	
	TecEvolutionMain.preIni();
	int ChiGuardentityID = EntityRegistry.findGlobalUniqueEntityId();

	EntityRegistry.registerGlobalEntityID(EntityChiGuard.class, "EntityChiGuard", ChiGuardentityID);
	EntityRegistry.registerModEntity(EntityChiGuard.class, "EntityChiGuard", ChiGuardentityID, instance, 64, 1, true);
	FMLCommonHandler.instance().bus().register(new TickHandler());
	MinecraftForge.EVENT_BUS.register(new SecondaryBusTickHandler());
	GameRegistry.registerTileEntity(TileEntityGreenCrystal.class, "MysteryMod_TileEntityGreenCrystal");
	PacketDispatcher.registerPackets();
}



@EventHandler
public void init(FMLInitializationEvent event){

channelHandler = new com.CiD.MysteryMod.ChannelHandler(this.MODID, this.CHANNEL);
proxy.registerRenderThings();
packetPipeline.initialise();
	

	
	//rezepte









TecEvolutionMain.Ini();


}




@EventHandler
public void postInit(FMLPostInitializationEvent event){


	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
	packetPipeline.postInitialise();



	TecEvolutionMain.PostIni();

}
public static void registerEntity(Class entityClass, String name){
int entityID = EntityRegistry.findGlobalUniqueEntityId();



EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
}




}


