package com.corejava.q18;

public class Main
{

	public static void main(String[] args)
	{
		// setup Strings to test class
		String test1 = "a string with no uppercase characters";
		String test2 = "A String Object with some UPPERCASE characters";
		String test3 = "1917";
	
		// initialise test class
		Concrete concrete = new Concrete();
		
		// run tests for each method
		boolean result0 = concrete.containsUpper(test1);
		boolean result1 = concrete.containsUpper(test2);
		String result2 = concrete.lowerToUpper(test2);
		String result3 = concrete.lowerToUpper(test3);
		concrete.convertAndAdd(test2);
		concrete.convertAndAdd(test3);		
	}

}
