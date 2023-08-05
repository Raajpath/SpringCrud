package com.example.crud.exception;

public class UserIdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserIdNotFoundException(String message) {
		super(message);
	}

}
