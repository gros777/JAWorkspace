package me.victorhernandez.struts2.pra.actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserGreetingAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8613511495476383764L;
	private String userName;
	private int luckyNumber;
	private String message;
	//setters and getters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getLuckyNumber() {
		return luckyNumber;
	}
	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
	public String getMessage() {
		return message;
	}
	
	@Override
	public String execute() throws Exception {
		message = "Greetings Terricola: " + getUserName() + " Your lucky numbers is: " + getLuckyNumber();
		return SUCCESS;
	}

}
