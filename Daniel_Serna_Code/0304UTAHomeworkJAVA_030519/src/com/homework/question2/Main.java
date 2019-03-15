package com.homework.question2;

public class Main {
	public static void main(String[] args)
	{
		// Q2. Write a program to display the first 25 
		// Fibonacci numbers beginning at 0. 
		
		int i = 1; // first two numbers
		int j = 1; 
		int currentTotal = 0;  // display the number
		int count = 3; // keep track of numbers displayed
		
		// first numbers are 0, 1, 1
		System.out.print(currentTotal+" "+i+" "+j+" ");
		
		while(count < 25)
		{
			currentTotal = i + j; 
			System.out.print(currentTotal+" ");
			i = j; 
			j = currentTotal;
			count = count + 1; 
		}
	}
}
