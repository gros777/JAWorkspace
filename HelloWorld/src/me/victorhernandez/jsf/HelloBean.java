package me.victorhernandez.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("hello")
@SessionScoped
public class HelloBean implements Serializable {
	private String world = "Hello World!";
	
	private String name="";
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGretting() {
		if(name.length() == 0) return "";
		else 
			return "Welcome to the jungle: " + name;
	}


	public String getWorld() {
		return world;
	}
	
}
