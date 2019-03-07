package com.corejava.q12;

public class PrintEven
{

	public static void main(String[] args)
	{
		
		// Initialise array of target data
		int[] data = new int[100];
		for (int i = 0; i < data.length; i ++)
			data[i] = i+1;

		for (int i : data)
		{
			if (i % 2 == 0)
				System.out.println(i);
		}	
	}
}
