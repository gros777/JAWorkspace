package me.victorhernandez.hellospring.exception;

public class EntityNotFoundException extends Exception {
	
	public EntityNotFoundException(String reason){
		super(reason);
	}
	
}
