package com.homework.question17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Q17. Write a program that calculates the 
		// simple interest on the principal, rate of 
		// interest and number of years provided by the 
		// user. Enter principal, rate and time through 
		// the console using the Scanner class. 
		//
		// Interest = Principal* Rate* Time
		
		// use doubles to get around decimal numbers
		double principal = 0; 
		double rate = 0; 
		double time = 0; 
		double interest = 0; 
		
		Scanner s = new Scanner(System.in); // create a new scanner
		
		// ask for user input
		System.out.println("Enter your principal: ");
		principal = s.nextDouble(); 
		
		System.out.println("Enter your rate (out of 100%): ");
		rate = s.nextDouble() / 100;
		rate = rate + 1; 
		
		System.out.println("Enter your preferred time. '1' - yearly, '2' - bi_yearly, '4' - quarterly: ");
		time = s.nextDouble(); 
		
		// switch to have default time because the user is unpredictable
		switch((int) time)
		{
		case 1: 
			time = 1; 
			break;
		case 2: 
			time = 0.5; 
			break; 
		case 4: 
			time = 0.25;
			break; 
		default:
			time = 1; 				
		}
		
		System.out.println("Interest: "+ (time*rate*principal));
	}

}
