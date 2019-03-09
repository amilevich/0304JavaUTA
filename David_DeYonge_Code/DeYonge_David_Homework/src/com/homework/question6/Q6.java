package com.homework.question6;

public class Q6 
{

	public static boolean evenCheck(int i)
	{
		//checks the farthest right bit
		//if the bit is 1 it's odd
		//if the bit is 0 it's even
		if((i & 1) == 1)
			return false;
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		int[] i = {7,8,5,74,9,6,3,1,7,1,2,8,69,420};
		for (int j = 0; j < i.length; j++) 
		{
			System.out.println(evenCheck(i[j]));
		}
	}

}
