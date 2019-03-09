package com.homework.question13;

public class Q13 
{

	public static void main(String[] args) 
	{
		int x = 0;
		int y = 1;
		//bool to alternate int's
		boolean zero = true;
		//loop for each row
		for (int i = 1; i <= 4; i++)
		{	//loop for each column
			for (int j = 0; j < i; j++) 
			{
				if (zero)
					System.out.print(x+" ");
				else
					System.out.print(y+" ");
				
				zero = !zero;
			}
			System.out.println();
		}

	}

}
