package com.workspacemongodbcs.services.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//Constructor
	public NotFoundException(String msg) {
		
		super(msg);
		
	}

}
