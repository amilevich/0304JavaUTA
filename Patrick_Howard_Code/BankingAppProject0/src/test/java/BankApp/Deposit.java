package BankApp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import BankApp.Withdraw;

public class Deposit {

	Withdraw tester = new Withdraw();

	@BeforeClass
	public static void methodCalledBeforeAllTests() {
		System.out.println("Welcome to JUnit");

		/*
		 * @Ignore - ignores the method test that has this annotation
		 * 
		 * @After - have a method that will run after each test
		 * 
		 * @Before - have a method that will run before each test
		 * 
		 * @BeforeClass - have method what will run before class
		 * 
		 * @AfterClass - have method what will run after class
		 */
	}

	@Test
	public void areTwoIntegersEqual() {
		assertEquals("should return true", true, tester.areTwoIntegersEqual(5,5));
		System.out.println("method to check the equality of two numbers " + tester);
	}

	@Test
	public void addTwoIntegers() {
		assertEquals("should return true", 9, tester.addTwoIntegers(4,5));
		System.out.println("method added to numbers!");
	}
	@Test
	public void Exponent() {
		assertEquals("should return true", 9, tester.exponent(3));
		System.out.println("number exponent!");
	}


	@After
	public void afterMethod() {
		System.out.println("\n*******after each method********");
	}
}

