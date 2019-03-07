package com.corejava.q6;

public class IsEven {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++)
			System.out.println(i + ": " + isEven(i));
	}

	private static boolean isEven(int n)
	{
		// Mask Least Significant Bit using Bitwise &
		// 		ODD  => 0x01
		// 		EVEN => 0x00
		// Return result's comparison to 0
		return (n & 0x01) == 0;
	}
}
