package com.CiD.MysteryMod.CodeAble;

import java.util.ArrayList;
import java.util.List;

public class CScriptToJava {
private final String[] program;
	
	public CScriptToJava(String[] code) {
		this.program = code;
	}

//	public String[] getArguments(int line){
//		String lineCode = getLineCode(line);
//		for(int i = 0 ; i < lineCode.length(); i++){
//			if(lineCode.charAt(i) == '('){
//				List <String> args = new ArrayList<String>();
//				for(int x = lineCode.length() - i-1; x < lineCode.length(); x++){
//					if(lineCode.charAt(x) != ' '){
//						for(int z = x; z< lineCode.length(); z++){
//							if(lineCode.charAt(z) != ' ' && lineCode.charAt(z) != ')'){
//							}else{
//								String halfArg = lineCode.substring(x, z+1);
//								args.add(halfArg);
//								break;
//							}
//						}
//					}
//					
//				}
//				String[] returnString = new String[args.size()];
//				for(int s = 0; s < returnString.length ; s++){
//					returnString[s] = args.get(s);
//				}
//				return returnString;
//			}
//		}
//		return null;
//	}
	
	
	
	
	
	
	
	
	
	
	public String[] getArguments(int line){
		String lineCode = getLineCode(line);
		for(int i = 0 ; i < lineCode.length(); i++){
			if(lineCode.charAt(i) == '('){
				List <String> args = new ArrayList<String>();
			
				
				
				
				
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
