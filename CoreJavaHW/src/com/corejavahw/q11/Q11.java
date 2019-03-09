package com.corejavahw.q11;

/*
 * Write a program that would access two float-variables from a class that exists in 
 * another package. Note, you will need to create two packages to demonstrate the 
 * solution.
 */

public class Q11 {

	//program driver
	public static void main(String[] args) {

		//Instantiating FloatVariable class
		FloatVariable fv = new FloatVariable();
		
		//calling fv's float variables and adding them
		float sum = fv.a + fv.b;
		//print the sum of the float variables.
		System.out.println(sum);
	}

}
