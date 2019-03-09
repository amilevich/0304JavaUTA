package com.homework.q18;

public class Inheritance extends SuperClass {

	public static void main(String[] args) {

		if (upperCaseCheck("Patrick")) {					// uses method from superclass
			System.out.println("Has an UpperCase Character");
		} else {
			System.out.println("Does not have an UpperCase Character");
		}

		System.out.println(changeCase("barbeque"));			// uses method from superclass
		
		System.out.println(changeNumber("27") + 10);		// uses method from superclass and also add 10 after it is converted
	}

}
