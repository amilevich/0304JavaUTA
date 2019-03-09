
package com.homework.question12;

public class Q12
{

	
	public static void main(String[] args)
	{
		int[] intArray = new int[100];
		
		//populate array
		for (int i = 0; i < intArray.length; i++) 
		{
			intArray[i] = i+1;
		}
		
		for(int i : intArray)
		{
			//checks if the value is even
			if (intArray[i-1]%2 == 0)
				System.out.println(intArray[i-1]);
		}
	}

}
