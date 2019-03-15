package com.Homework1.Problem18;

public class Concreteo extends Abstracto {	// concrete class Concreteo

	@Override
	boolean anyUppersHere(String str) {
		if (str.toLowerCase() != str) // If there are uppercase characters, toLowerCase should change str
			return true;
		return false;
	}

	@Override
	String noLowersAllowed(String str) {
		return str.toUpperCase();		// converting to uppercase and returning result
	}

	@Override
	int strToIntPlusTen(String str) {
		int result;
		try {
			result = Integer.parseInt(str);		// using parseInt to convert str to Integer
		} catch (NumberFormatException e) {		// Might throw a NumberFormatException so I return -1 in this case 
			return -1;
		}
		return result + 10;						// else I add 10 to parsed string and return that value
	}

}
