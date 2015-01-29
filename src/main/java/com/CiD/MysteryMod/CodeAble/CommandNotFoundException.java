package com.CiD.MysteryMod.CodeAble;

public class CommandNotFoundException extends Exception{

	  public CommandNotFoundException(String message){
		  super(message);
		 }
	  public CommandNotFoundException(String message, Throwable cause) {
		  super(message, cause);
		 }
	  public CommandNotFoundException(Throwable cause) {
		  super(cause); 
		  }
	
}
