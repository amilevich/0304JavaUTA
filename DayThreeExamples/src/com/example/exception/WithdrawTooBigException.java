package com.example.exception;

public class WithdrawTooBigException extends Exception{
	// why are we required a SerialVersionID?

	public WithdrawTooBigException() {
	}
	
	public WithdrawTooBigException(String message) {
		super(message);
	}
	
	public WithdrawTooBigException(String message, Throwable cause) {
		super(message, cause);
	}
}
