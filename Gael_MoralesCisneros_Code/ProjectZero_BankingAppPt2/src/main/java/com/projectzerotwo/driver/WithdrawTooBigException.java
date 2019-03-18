package com.projectzerotwo.driver;

//custom exception handler for attempting to withdraw more than account balance
public class WithdrawTooBigException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WithdrawTooBigException() {

	}

	public WithdrawTooBigException(String message) {
		super(message);
	}

	public WithdrawTooBigException(String message, Throwable cause) {
		super(message, cause);
	}
}
