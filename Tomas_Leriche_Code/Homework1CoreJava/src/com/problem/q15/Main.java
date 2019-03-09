package com.problem.q15;

interface Interbase {

	// just testing the access modifiers and such, all function the same.
	// for this purpose.
	public abstract double addition(double a, double b);

	public double subtraction(double a, double b);

	double multiplication(double a, double b);

	public double division(double a, double b);

}

// Made this extra class just for fun not really needed
// but doesn't change the output.
class Test implements Interbase {

	@Override
	public double addition(double a, double b) {

		return a + b;
	}

	@Override
	public double subtraction(double a, double b) {

		return a - b;
	}

	@Override
	public double multiplication(double a, double b) {

		return a * b;
	}

	@Override
	public double division(double a, double b) {

		return a / b;
	}
}

public class Main extends Test {

	static double num1 = 5.0;
	static double num2 = 7.0;

	public static void main(String[] args) {

		Test test = new Test();

		System.out.println("Addition: " + test.addition(num1, num2) + "\nSubtraction: " + test.subtraction(num1, num2)
				+ "\nMultiplication: " + test.multiplication(num1, num2) + "\nDivision: " + test.division(num1, num2));
	}

}
