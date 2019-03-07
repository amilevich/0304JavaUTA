package com.corejava.q18;

public class Concrete extends Super
{

	@Override
	public boolean containsUpper(String s)
	{
		// Search the string for any uppercase character using regular expression
		// return true if any were found
		return s.matches("[A-Z]");
	}

	@Override
	public String lowerToUpper(String s)
	{
		// transform all lowercase characters to uppercase and return result
		return s.toUpperCase();
	}

	@Override
	public void convertAndAdd(String s)
	{
		try
		{
			// Attempt to convert input string to an integer
			int result = Integer.valueOf(s);
			// display the Desired transformed result if above succeeds
			System.out.println(result + 10);
		}
		catch (NumberFormatException e)
		{
			// If invalid input string, print trace and return
			e.printStackTrace();
		}
	}

}
