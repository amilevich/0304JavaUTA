package com.example.wrapper;

public class Main {

	public static void main(String[] args) {
		
		//primitives
		/*
		 * byte
		 * short
		 * int -> Integer
		 * long
		 * float
		 * double
		 * char
		 * boolean -> Boolean
		 */
		
		// wrapper is a class that encapsulates
		// primitive data types
		
		Integer i = new Integer(3);
//		System.out.println(i);
		
		short s = 3;
		Short s2 = new Short(s);
		
		// boxing (autoboxing) -> primitive to Wrapper
		// unboxing -> Wrapper to primitive
		
		Float f = 998f; // (auto)boxing
		float tempFloat = f; // unboxing
		
	}

}
