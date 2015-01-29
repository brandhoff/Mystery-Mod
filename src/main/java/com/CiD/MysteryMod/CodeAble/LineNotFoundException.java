package com.CiD.MysteryMod.CodeAble;

public class LineNotFoundException extends Exception{

	public LineNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	  public LineNotFoundException(String message){
		  super(message);
		 }
	  public LineNotFoundException(String message, Throwable cause) {
		  super(message, cause);
		 }
	  public LineNotFoundException(Throwable cause) {
		  super(cause); 
		  }
}
