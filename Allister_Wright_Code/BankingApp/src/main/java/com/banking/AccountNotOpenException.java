package com.banking;

public class AccountNotOpenException extends Exception
{
	public AccountNotOpenException()
	{	}
	
	public AccountNotOpenException(String message)
	{
		super(message);
	}
	
	public AccountNotOpenException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
