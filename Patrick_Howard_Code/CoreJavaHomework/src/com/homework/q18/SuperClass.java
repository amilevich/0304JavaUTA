package com.homework.q18;

public abstract class SuperClass {

	public static boolean upperCaseCheck(String str) {			// a method to check if there are any upperCase letters
		for (int i = str.length() - 1; i >= 0; i--) {
			if (Character.isUpperCase(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static String changeCase(String str) {		// a method to change all the characaters to upperCase
		return str.toUpperCase();
	}
	
	public static int changeNumber(String str) {		// converts number string into an integer value
		return Integer.parseInt(str);
	}
}
