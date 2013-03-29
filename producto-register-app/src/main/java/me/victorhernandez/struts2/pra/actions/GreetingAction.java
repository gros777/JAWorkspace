package me.victorhernandez.struts2.pra.actions;

import static com.opensymphony.xwork2.Action.*;

public class GreetingAction{

	public String getMessage(){
		return "Greetings  Terricolas";
	}
	
	public String execute(){
		
		return SUCCESS;
	}
}
