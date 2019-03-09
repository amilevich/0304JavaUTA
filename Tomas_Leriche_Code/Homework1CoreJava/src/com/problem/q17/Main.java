package com.problem.q17;

import java.util.Scanner;

public class Main {

	// pretty basic
	public static double calcInterest(double a, double b, double c) {

		return a * b * c;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the priciple payment: ");
		double princip = scan.nextDouble();

		System.out.println("Enter the rate (as decimal): ");
		double rate = scan.nextDouble();

		System.out.println("Enter the time period (over which your rate applies: ");
		double time = scan.nextDouble();

		System.out.println(calcInterest(princip, rate, time));

	}

}
