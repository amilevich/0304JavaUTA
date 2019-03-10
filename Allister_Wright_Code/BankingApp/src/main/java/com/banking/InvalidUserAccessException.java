package com.banking;

public class InvalidUserAccessException extends Exception
{
	public InvalidUserAccessException()
	{	}
	
	public InvalidUserAccessException(String message)
	{
		super(message);
	}
	
	public InvalidUserAccessException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
