package com.corejavahw.q18;

/*
 * Write a program having a concrete subclass that inherits three abstract methods
 * from a superclass. Provide the following three implementations in the subclass
 * corresponding to the abstract methods in the superclass:
 * 
 * 	1. Check for upper case characters in a string, and return ‘true’ or ‘false’ depending
 * 		if any are found.
 * 	2. Convert all of the lower case characters to upper case in the input string, and
 * 		return the result.
 * 	3. Convert the input string to integer and add 10, output the result to the console.
 * Create an appropriate class having a main method to test the above setup.
 */


//subclass to implement the abstract methods in the superclass
public class Q18 extends Super {

	public static void main(String[] args) {

	}

	//Override abstract method to check for upperCase letters in string
	@Override
	public boolean upperCaseCheck(String s) {
		boolean upperCaseExists = !s.equals(s.toLowerCase());
		if(upperCaseExists == true)
			return true;
		else
			return false;
	}

	//Override abstract method to change the lowerCase letters in the string to upperCase
	@Override
	public String lowToUp(String s) {
		String str = s.toUpperCase();
		return str;
	}

	//Override abstract methods to change the string into an integer and add 10
	@Override
	public int stringToInt(String s) {
		
		int x = Integer.parseInt(s);
		x= x + 10;
		return x;
	}

}
