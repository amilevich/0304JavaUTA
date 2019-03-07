package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	/*
	 * JUnit - testing framework, specifically, a unit testing framework.
	 * 
	 * Unit testing - testing a small portion of your program, typically, a method.
	 * Method = unit. (as opposed to integration testing - testing a lot of stuff
	 * together)
	 * 
	 * JUnit is important for TDD (Test Driven Development) TDD is writing tests
	 * before you write code.
	 * 
	 * Benefits: - you create a detailed specification of what you want your method
	 * to do - it requires you to think/plan what you want from each piece of code -
	 * modularity - the goal of programming, modules work by
	 * themselves/independent/reusable
	 * 
	 * 
	 * JUnit provides us with static methods in the org.junit.Assert class to test
	 * for certain conditions. These methods usually start with "assert" and let you
	 * specify an error message, the expected result, and the actual result. If the
	 * test fails, the "assert" method will throw an AssertionException.
	 */
	Calculator tester = new Calculator();

	@BeforeClass
	public static void methodCalledBeforeAllTests() {
		System.out.println("WELCOME TO JUNIT");
	}

	/*
	 * @Ignore - ignores the method test that has this annotation
	 * 
	 * @After - have a method that will run after each test
	 * 
	 * @Before - have a method that will run before each test
	 * 
	 * @BeforeClass - have a method that will run before the class
	 * 
	 * @AfterClass - have a method that will run after the class
	 */

	@Test
	public void areTwoIntegersEqual() {
		assertEquals("should return true", true, tester.areTwoIntegersEqual(4, 4));
		System.out.println("method to check the equality of two numbers tested");
	}

	@After
	public void afterMethod() {
		System.out.println("\n**************after each method**************");
	}

}
