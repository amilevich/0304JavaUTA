package com.problem.q10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		scanIn();
	}

	// pretty standard
	public static float numFor11 = 5f;

	public static float secondNumFor11 = 6.5f;

	private double num1;

	private double num2;

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {

		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public static void scanIn() {
		Scanner scan = new Scanner(System.in);

		Main main = new Main();

		System.out.println("Enter a number: ");
		main.setNum1(scan.nextDouble());

		System.out.println("Enter a second number: ");
		main.setNum2(scan.nextDouble());

		scan.close();

		// here is the ternary operator being used

		System.out.println(
				"The larger number is: " + ((main.getNum1() < main.getNum2()) ? main.getNum2() : main.getNum1()));

	}

}
