package me.victorhernandez.hellojsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="hello")
@SessionScoped
public class HelloBean {
	
	private String greeting = "Hello JSF World!";

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
