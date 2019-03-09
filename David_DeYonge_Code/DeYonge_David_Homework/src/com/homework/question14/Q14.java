package com.homework.question14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Q14
{

	public static void main(String[] args) 
	{
		int switchCase = 0;
		Scanner input = new Scanner(System.in);//scanner for input
		DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("yyyy/MM/dd");//format for date
		LocalDate date = LocalDate.now();//gets todays date
		String[] stringArray = new String[5];
		String splittingString = "I am learning Core Java";
		System.out.println("Enter a number 1-3");
		
		switchCase = input.nextInt();
		
		switch (switchCase)
		{
		case 1:
			System.out.println("enter a number");
			double squareroot = 0.0;
			squareroot = input.nextDouble();
			System.out.println(Math.sqrt(squareroot));
			break;
		case 2:
			System.out.println(dateFormat.format(date));
			break;
		case 3:
				stringArray = splittingString.split(" ");
				for (int i = 0; i < stringArray.length; i++)
				System.out.println(stringArray[i]);
			break;

		default:
			break;
		}
		input.close();
	}

}
