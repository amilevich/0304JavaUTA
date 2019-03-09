
package com.homework.question10;

public class Q10 
{

	public static int findMin(int x,int y){return x > y ? y : x;}
	public static void main(String[] args)
	{
		int[] x = {21,7,5,9,6,4,2,3,6,8,2,1,4,5,96,421};
		int[] y = {7,9,5,6,4,1,3,7,564,9,8,1,8,9,69,420};
		for (int i = 0; i < (x.length >  y.length?y.length:x.length); i++)
		{
			System.out.println(findMin(x[i],y[i]));
		}
	}

}
