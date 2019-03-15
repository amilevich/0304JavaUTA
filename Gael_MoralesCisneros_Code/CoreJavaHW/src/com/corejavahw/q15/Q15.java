package com.corejavahw.q15;

/*
 * Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division. Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations. Hard code
 * two operands in a test class having a main method that calls the implementing class.
 */

//class that implements interface with functionality
public class Q15 implements MyMath{
	
	//Every interface method overridden and provided appropriate functionality
	@Override
	public int addition(int x, int y) {
		int temp = x+y;
		return temp;
	}

	@Override
	public int subtraction(int x, int y) {
		int temp = x-y;
		return temp;
		
	}

	@Override
	public int multiplication(int x, int y) {
		int temp = x*y;
		return temp;
		
	}

	//made float to accommodate decimals
	@Override
	public float division(int x, int y) {
		float temp = x/y;
		return temp;
		
	}


}
