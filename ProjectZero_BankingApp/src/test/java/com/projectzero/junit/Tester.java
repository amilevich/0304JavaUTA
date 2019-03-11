package com.projectzero.junit;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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

public class Tester {
	
	Tester tester = new Tester();
	
	@BeforeClass
	public static void methodCallBeforeAllTests() {
		System.out.println("WELCOME TO BANKING APP TEST");
	}
	
	@After
	public void afterMethod() {
		System.out.println("\n**************after each method**************");
	}
	
//	@Test
	

	
	
}
