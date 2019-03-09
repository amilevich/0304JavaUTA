package com.homework.question6;

import java.util.Scanner;

public class EvenorNot {
	public static void main(String[] args) {
		System.out.println("Enter Number"); //Print instruction to user.
		Scanner scanner = new Scanner(System.in);//Reads input from the command line.
		int x=scanner.nextInt();//stores input value in to x.
		
		int result = (x/2)*2;//divides input number by 2 and then multiplies by two.
		if (result==x) //compares result to initial input value and defines message to print.
						
			System.out.println("Number is even.");
		

	else //if if condition is not met, defines alternate message to print.
		System.out.println("Number is not.");
	}

}
