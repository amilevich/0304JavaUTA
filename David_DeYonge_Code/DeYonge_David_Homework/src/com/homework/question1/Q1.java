package com.homework.question1;

public class Q1
{
	static int[] bubblesort(int array[])
	{
		//Runs through the array
		for (int i = 0; i < array.length; i++)
		{
			//Runs through the array for everything after i
			for (int j = i; j < array.length; j++) 
			{
				//if [j] is less than [i] it swaps the values
				if ( array[j] < array[i]) 
				{
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	static void print(int array[])
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args)
	{
		int array[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		array = bubblesort(array);
		print(array);
	}
}
