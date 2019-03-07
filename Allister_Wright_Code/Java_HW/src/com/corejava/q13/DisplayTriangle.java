package com.corejava.q13;

public class DisplayTriangle
{

	public static void main(String[] args)
	{
	
		int toPrint = 0;
		
		// Iterate over each line in the triangle
		for (int level = 1; level <= 4; level++)
		{
			// Iterate over tokens in each line
			for (int pos = 0; pos < level; pos ++)
			{
				System.out.print(toPrint + " ");
				// Flip token to be printed between 0 and 1
				toPrint = Math.abs(--toPrint);
			}
			System.out.println();
		}

	}

}
