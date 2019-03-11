package com.banking;

public class AccountNotOpenException extends Exception
{
	private static final long serialVersionUID = -3517484141474584431L;

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
