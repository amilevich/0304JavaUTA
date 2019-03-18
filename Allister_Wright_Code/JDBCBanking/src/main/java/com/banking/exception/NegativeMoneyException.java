package com.banking.exception;

public class NegativeMoneyException extends Exception
{
	private static final long serialVersionUID = -2277491948236405331L;

	public NegativeMoneyException()
	{	}
	
	public NegativeMoneyException(String message)
	{
		super(message);
	}
	
	public NegativeMoneyException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
