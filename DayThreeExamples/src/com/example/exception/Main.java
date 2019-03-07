package com.example.exception;

public class Main {

	/*
	 * Throwable - superclass of all errors and exceptions
	 * 
	 * Error - a problem that occurs external to your program
	 * and is fatal (stackoverflow)
	 * 
	 * Exception is "thrown" when something goes wrong and 
	 * can be "caught" to resolve the problem.
	 * 
	 * Try -> try some code, must be followed by at least
	 * one catch block or finally block
	 * Catch -> resolve the problem, must specify the exception
	 * type
	 * Finally -> runs no matter what, must be the last block
	 * 
	 * "throw" - if there is a problem, you can throw
	 * anything that is a Throwable (most commonly used
	 * for custom exceptions)
	 * 
	 * "throws" - ducking, you pass of responsibility to another
	 * method, a band-aid fix. 
	 * 
	 * When an exception is thrown, the stack unrolls until
	 * it is caught.
	 * 
	 */
	public static void main(String[] args) {

		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace(); // don't have to put this here, good practice to
			
			throw new RuntimeException(); 
			//you can put exceptions inside of exceptions
		}
	}

}
