package com.homework.question16;

public class Q16 
{

	public static void main(String[] args) 
	{
		for (int i = 0; i < args.length; i++)
			{
				System.out.println("Number of characters in args " + (i+1) + " is " + args[i].length());
			}
	}
}
//compile by javac Q16.java;
//run java Q16 testString;