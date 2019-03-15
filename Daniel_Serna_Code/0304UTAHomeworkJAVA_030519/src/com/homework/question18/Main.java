package com.homework.question18;

// create abstract class
abstract class AbstractClass
{
	abstract boolean checkUppercase(String a); 
	
	abstract String convertToUpperCase(String b); 
	
	abstract int stringToInteger(String c); 
}

public class Main extends AbstractClass {

	// call abstract class functions
	public Main(String string, String string2, String string3) {
		System.out.println(checkUppercase(string));
		System.out.println(convertToUpperCase(string2));
		System.out.println(stringToInteger(string3));
	}

	public static void main(String[] args) {

		// Q18. Write a program having a concrete subclass 
		// that inherits three abstract methods from a 
		// superclass.  Provide the following three 
		// implementations in the subclass corresponding 
		// to the abstract methods in the superclass: 
		// 
		// 1. Check for uppercase characters in a string, 
		// and return ‘true’ or ‘false’ depending if any 
		// are found. 
		//
		// 2. Convert all of the lower case characters to 
		// uppercase in the input string, and return the 
		// result.  
		// 
		// 3. Convert the input string to integer and add 
		// 10, output the result to the console. 
		//
		// Create an appropriate class having a main 
		// method to test the above setup.
		
		// create main object
		Main m = new Main("apple", "Fishing", "909");
		
		
	}

	// save converted string to a temp string
	// convert to all lowercase in temp
	// if strings equal each other then there is 
	// no uppercase letters
	@Override
	boolean checkUppercase(String a) {
		
		String x = a.toLowerCase(); 
		
		if(x.equals(a) == true)
		{
			return false;
		}
		else
		{
			return true; 
		}
	}

	// use function toUpperCase on passed in string
	@Override
	String convertToUpperCase(String b) {
			return b.toUpperCase(); 	
	}

	// to convert string to int
	@Override
	int stringToInteger(String c) {
		int temp = Integer.parseInt(c); 
		return temp; 
	}

}
