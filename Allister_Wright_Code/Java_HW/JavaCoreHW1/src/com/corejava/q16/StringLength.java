package com.corejava.q16;

public class StringLength
{

	public static void main(String[] args)
	{
		// Make sure at least one String was provided
		if (args.length < 1)
		{
			// Otherwise, display the usage (and terminate)
			System.out.println("Usage:\tjava -jar <thisRunnableBuild.jar> string1 [string2 ...]");
		}
		else
		{
			// Iterate over all Strings provided
			for (int i = 0; i < args.length; i++)
				System.out.println(	args[i] + " contains " + 
									args[i].length() + " characters");
		}
	}
}
