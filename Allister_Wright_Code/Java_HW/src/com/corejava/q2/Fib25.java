package com.corejava.q2;

public class Fib25 {

	public static void main(String[] args) {

		for (int i = 0; i < 25; i++)
			System.out.println("F_" + i + " = " + getFib(i));
	}
	
	private static int getFib(int index)
	{
		// establish base cases for F_0 and F_1
		if (index < 2)
		{
			return index;
		}
		else
		{
			// recursively solve for request F_index
			return getFib(index - 2) + getFib(index - 1);
		}
	}
}
