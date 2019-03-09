package com.homework.question17;

import java.util.Scanner;

public class Q17 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		float principal,rate,time;
		
		System.out.println("Enter the Principal: ");
		principal = scanner.nextFloat();
		
		System.out.println("Enter the Rate: ");
		rate = scanner.nextFloat();
		
		System.out.println("Enter the Time: ");
		time = scanner.nextFloat();
		
		
		System.out.println("Interest = "+(principal*rate*time));
		scanner.close();
	}
}
