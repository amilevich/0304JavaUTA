package com.corejava.q16;

public class StringLength
{

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Usage:\tjava -jar string1 [string2 ...]");
		}
		else
		{
			for (int i = 0; i < args.length; i++)
				System.out.println(	args[i] + " contains " + 
									args[i].length() + " characters");
		}
	}
}
