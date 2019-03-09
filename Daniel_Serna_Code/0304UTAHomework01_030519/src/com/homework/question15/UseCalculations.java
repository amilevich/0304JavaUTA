package com.homework.question15;

public class UseCalculations implements CalculationsInterface {
	
	public void addition(int a, int b)
	{
		int temp = a+b; 
		System.out.println("Addition of: "+a+" & "+b+" equals: "+temp);
	}
	
	public void subtraction(int a, int b)
	{
		int temp = a-b; 
		System.out.println("Subtraction of: "+a+" & "+b+" equals: "+temp);
	}
	
	public void multiplication(int a, int b)
	{
		int temp = a*b; 
		System.out.println("Multiplication of: "+a+" & "+b+" equals: "+temp);
	}
	
	public void division(int a, int b)
	{
		int temp = a/b; 
		System.out.println("Division of: "+a+" & "+b+" equals: "+temp);
	}

}
