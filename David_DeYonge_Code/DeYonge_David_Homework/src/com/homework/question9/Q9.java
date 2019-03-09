package com.homework.question9;

import java.util.ArrayList;

public class Q9
{

	public static boolean checkPrime(Integer i)
	{
		for (int j = 2; j < i; j++)
		{
			//checks if i is divisible by anything up to itself 
			if (i%j == 0)
				return false;
		}
		
		return true;
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) 
			intList.add(i);
		
		for (int i = 0; i < intList.size(); i++) 
		{
			if (checkPrime(intList.get(i))) 
			System.out.println(intList.get(i));
		}
	}

}
