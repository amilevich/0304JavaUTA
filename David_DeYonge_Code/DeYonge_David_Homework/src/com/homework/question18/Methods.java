package com.homework.question18;

public class Methods extends AbstractClass
{

	@Override
	public boolean checkUppercase(String string)
	{
		String compare = string.toUpperCase();//string changed to all uppercase
		
		for (int i = 0; i < string.length(); i++) 
		{
			//checks to see if the character in the original string is uppercase
			if (compare.charAt(i) == string.charAt(i))
				return true;
		}
		return false;
	}

	@Override
	public String myToUpperCase(String string) 
	{
		return string.toUpperCase();////string changed to all uppercase
	}

	@Override
	public int toIntplus10(String string)
	{
		try
		{
			return Integer.parseInt(string);//change string to an integer
		}
		catch(NumberFormatException e)
		{
			System.out.println("Not an integer");//if the string doesn't contain a string don't change it
			return 0;
		}
				
	}
	
}
