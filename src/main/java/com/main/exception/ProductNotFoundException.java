package com.main.exception;

public class ProductNotFoundException extends RuntimeException {

	private String msg;

	public ProductNotFoundException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
