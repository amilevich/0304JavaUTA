package com.banking;

public class InvalidUserAccessException extends Exception
{
	private static final long serialVersionUID = 5145764550928019203L;

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
