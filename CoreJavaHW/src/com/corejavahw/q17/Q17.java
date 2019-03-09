package com.corejavahw.q17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, rate of interest
 * and number of years provided by the user. Enter principal, rate and time through the
 * console using the Scanner class.
 * 
 * Interest = Principal* Rate* Time
 */

public class Q17 {
	
	//method to calculate interest on principal
	public static float IntPrinc(float prcpl, float rt, int yrs) {
		//Interest = Principal* Rate* Time
		float intOnPrinc = prcpl*rt*yrs ;
		//return answer
		return intOnPrinc;
		
	}

	//program driver
	public static void main(String[] args) {

		//Instantiate Scanner class
		Scanner scan = new Scanner(System.in);
		
		//get principal from user
		System.out.println("Input principal: ");
		//Change user provided String to float 
		float principal = Float.parseFloat(scan.nextLine());
		
		//get interest rate form user
		System.out.println("Input rate: ");
		//Change user provided String to float 
		float rate = Float.parseFloat(scan.nextLine());
		
		//get time in years from user
		System.out.println("Input time in years: ");
		//Change user provided String to int 
		int time = Integer.parseInt(scan.nextLine());
		
		//call and print interest on principal over time
		System.out.println("Your interest on principal is: " + IntPrinc(principal, rate, time));
		
	}

}
