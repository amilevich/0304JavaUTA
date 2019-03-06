package com.example.problem17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double principle,rate,time, interest;
		
		
		System.out.println("What is the princepal ammount");
		principle = input.nextDouble();
		
		System.out.println("What is the interest rate");
		rate = input.nextDouble();
		
		System.out.println("How many years will it take for the asset to mature");
		time = input.nextDouble();
		
		interest = principle*rate*time;
		
		System.out.println("Your investment will be worth $" + interest + " in " + time + " years");
		
		input.close();
	}

}
