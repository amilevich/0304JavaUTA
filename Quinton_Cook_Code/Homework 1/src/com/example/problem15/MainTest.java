package com.example.problem15;

public class MainTest {
	public static void main(String[] args) {
		FourFunction calc = new FourFunction();
		
		double x1 = 2;
		double x2 = 3;
		
		System.out.println("n1 plus n2 is " + calc.add(x1, x2));
		System.out.println("n1 minus n2 is "+ calc.subtract(x1, x2));
		System.out.println("n1 times n2 is " + calc.multiply(x1, x2));
		System.out.println("n1 divided by n2 is " + calc.divide(x1, x2));
	}
}
