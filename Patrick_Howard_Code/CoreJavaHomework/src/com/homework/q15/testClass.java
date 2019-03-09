package com.homework.q15;

class testClass implements Calculator {
	public int addition(int a, int b) {			// returns the addition
		return a + b;
	}

	public int subtraction(int a, int b) {		// returns the subtraction
		return a - b;
	}

	public int multiplication(int a, int b) {	// returns the multiplication
		return a * b;
	}

	public int division(int a, int b) {			// returns the division
		return a / b;
	}

	public static void main(String[] args) {				//main Driver method
		testClass t = new testClass();						
		System.out.println(t.addition(5, 11));				//implements the calculator interface
		System.out.println(t.division(55, 11));
	}
}
