package com.homework.question4;

public class Q4
{

	static long Factorial(long start)
	{
		//return variable
		long ret = 1;
		//starts at the number entered and decrements until it reaches 0
		for(long i = start; i > 0; i--) 
		{
			//multiplies the values of the factorial
			ret *= i;
		}
		return ret;
	}
	public static void main(String[] args) 
	{

		System.out.println(Factorial(7));

	}

}
