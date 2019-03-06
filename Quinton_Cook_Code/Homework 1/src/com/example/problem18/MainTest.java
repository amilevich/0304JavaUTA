package com.example.problem18;

public class MainTest {

	public static void main(String[] args) {
		String test = new String("conTains a cap");
		
		ChildClass pete = new ChildClass();
		
		if(pete.checkUpper(test)) {
			System.out.println("String \"" + test + "\" has capital letters");
		}
		
		System.out.println("all the lowercase letters changed to upper " + pete.lowerToUpper(test));
		
		System.out.println("integer representation of the string \"" + test + "\" is " + pete.toInteger(test));
		
	}

}
