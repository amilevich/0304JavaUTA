package com.example.scopes;

public class Scopes {

	/*
	 * The lifetime of a variable
	 * 
	 * 4 in Java:
	 * 
	 * Class/Static - this is the largest scope ("global") variables in the class
	 * scope exist for the lifetime of the class and exist within the class itself.
	 * 
	 * Object/Instance - the object's fields/state variables in this scope exist for
	 * the lifetime of the object and exist within the object itself.
	 * 
	 * Method - parameters and any variables defined at the method level. Variables
	 * in this scope exist for the lifetime of the method call.
	 * 
	 * Loop/Block scope - any variable defined within curly braces
	 */

	public Scopes() {

	}

	// public Scopes(String hello, int i){
	//
	// }

	{
		System.out.println("Block Scope");
		int i = 4;
		int j = 4;

	}
	
	static {
		System.out.println("Static scope");
		int i = 4;
	}
	
	public static int i;
	
	public static void main(String[] args) {
		
		int k; //method scope
		
		//block scope
		for( int l =0; l<3; l++) {
			int i = 5;
		}
	}

}
