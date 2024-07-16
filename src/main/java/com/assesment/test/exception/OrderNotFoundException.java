package com.assesment.test.exception;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String message) {
		super(message); 
	}

}
