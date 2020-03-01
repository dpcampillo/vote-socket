package com.example.vote.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public BusinessException(String code, String description) {
		super(code);
		this.description = description;
	}
	
	public BusinessException(String code, String description, Throwable exception) {
		super(code, exception);
		this.description = description;
	}

}
