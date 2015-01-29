package com.CiD.MysteryMod.CodeAble.Commands;

import com.CiD.MysteryMod.CodeAble.ICodeAble;

import net.minecraft.world.World;
/** IMPLEMENTS ICODEABLE */
public class CCommand{// implements ICodeAble{
protected final String[] arguments;
protected final World world;
	public CCommand(String[] args, World world) {
		this.arguments = args;
		this.world = world;
	}
	
	public void Run() {
	
		
	}
	
	
	
	
}
