package com.example.demo.exception;

public class OrderAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 916139032395304470L;
	private String message;

	public OrderAlreadyExistException(String message) {
		super();
		this.message = message;
	}

	public OrderAlreadyExistException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
