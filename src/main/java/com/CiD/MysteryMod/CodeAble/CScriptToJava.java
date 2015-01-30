package com.CiD.MysteryMod.CodeAble;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.World;

public class CScriptToJava {
private String[] program;
private int totalLinesOfCode;
private World world;
	public CScriptToJava(String[] code, World world) {
		this.program = code;
		this.totalLinesOfCode = code.length;
		if(world.isRemote){
			
		}else{
		this.world = world;
		}
	}


	public void runProgram(){
		try {
			for(int i = 0; i<totalLinesOfCode; i++){
					if(getCommandName(i) != null){
				CScriptCommands.TryRunCommand(getCommandName(i), getArguments(i), world);
				}else{
					new CommandNotFoundException("the Line "+i+" has no Command");
				}
			}
		} catch (CommandNotFoundException e) {
			System.err.println("error on running the program");
		}
	}
	
	public String getCommandName(int line){
		String name = null;
		String lineCode = getLineCode(line);
		for(int i = 0 ; i < lineCode.length(); i++){
			if(lineCode.charAt(i) == '('){
				name = lineCode.substring(0, i);
				break;
			}

		}
			
		
		return name;
	}
	/** gets the command lines args */
	public String[] getArguments(int line){
		String lineCode = getLineCode(line);
		for(int i = 0 ; i < lineCode.length(); i++){
			if(lineCode.charAt(i) == '('){
				List <String> args = new ArrayList<String>();
			
				for(int x = i+1; x < lineCode.length(); x++){
					if(lineCode.charAt(x) != ' '){
						for(int z = x; z < lineCode.length(); z++){
							if(lineCode.charAt(z) == ' ' || lineCode.charAt(z) == ')'){
								String arg = lineCode.substring(x, z);
								x = z;
								args.add(arg);
								break;
							}else{
								
							}
							if(lineCode.charAt(x) == ')'){
								break;
							}
						}
					}
				}
							
				
				String[] returnString = new String[args.size()];
				for(int s = 0; s < returnString.length ; s++){
					returnString[s] = args.get(s);
				}
				return returnString;
			}
		}
		return null;
	}
	
	
	
	
	
	
	public String getLineCode(int line){
		if(program.length >= line){
			return program[line];
		}else{
		 new LineNotFoundException("Tryed to get Code of Line "+line);
			return "NO LINE FOUND";
		}
	}

}
