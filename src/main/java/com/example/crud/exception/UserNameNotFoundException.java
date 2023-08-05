package com.example.crud.exception;

public class UserNameNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameNotFoundException(final String message) {
		super(message);
	}
}
