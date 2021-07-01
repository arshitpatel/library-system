package com.library.lending.exception;

public class OperationNotAllowed extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String userMessage;

	public OperationNotAllowed(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}
}
