package com.banking.exception;

public class InvalidBalanceException extends Exception
{
	private static final long serialVersionUID = 2903270240845989773L;

	public InvalidBalanceException()
	{	}
	
	public InvalidBalanceException(String message)
	{
		super(message);
	}
	
	public InvalidBalanceException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
