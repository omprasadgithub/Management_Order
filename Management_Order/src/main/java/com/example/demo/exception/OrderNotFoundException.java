package com.example.demo.exception;

public class OrderNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7010891170523976904L;
	public String message;
	public OrderNotFoundException(String message) {
		super();
		this.message = message;
	}
	public OrderNotFoundException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
