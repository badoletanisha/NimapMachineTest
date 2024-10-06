package com.main.exception;

public class CategoryNotFoundException extends RuntimeException {
	
	private String msg;

	public CategoryNotFoundException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}