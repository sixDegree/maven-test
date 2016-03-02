package com.cj.ebike.entity;

@SuppressWarnings("serial")
public class ProductException extends RuntimeException{

	public ProductException() {
		super();
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductException(String message) {
		super(message);
	}

	public ProductException(Throwable cause) {
		super(cause);
	}

}
