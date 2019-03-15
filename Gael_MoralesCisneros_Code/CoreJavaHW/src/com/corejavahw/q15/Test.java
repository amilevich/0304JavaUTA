package com.corejavahw.q15;

public class Test extends Q15 {

	public static void main(String[] args) {

		//Instantiated object of implementing class
		MyMath myMath = new Q15();
		//Initialized two integers
		int x = 2, y = 3;
		
		//tested the addition() method, expected value is 5
		System.out.println("Testing myMath.addition(2,3): " + myMath.addition(x,y));
		//tested the multiplication() method, expected value is 6
		System.out.println("Testing myMath.multiplication(2,3): " + myMath.multiplication(x,y));
	}

}
