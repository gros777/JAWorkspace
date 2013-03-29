package me.victorhernandez.struts2.pra.exceptions;

public class EntityNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8971605221009310943L;

	public EntityNotFoundException(String reason){
		super(reason);
	}
	
}
