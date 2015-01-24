package com.CiD.MysteryMod.Pages;

public class BasePage {
	
public String mystery;
public String correctAnswer;
public String title;

public int pageNum;

/** whether the mystery is solved*/
public boolean done;

	public BasePage(){
		
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	/** This will be on the page word for word*/
	public void setMystery(String mystery){
		this.mystery = mystery;
	}
	
	public void setCorrectAnswer(String aw){
		this.correctAnswer = aw;
	}
	
	
}
