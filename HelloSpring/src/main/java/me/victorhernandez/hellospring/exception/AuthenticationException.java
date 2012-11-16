package me.victorhernandez.hellospring.exception;

public class AuthenticationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7770755152030856337L;
	
	public AuthenticationException(String reason){
		super(reason);
	}
}
