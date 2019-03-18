package com.projectzerotwo.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.projectzerotwo.driver.Main;
import com.projectzerotwo.driver.WithdrawTooBigException;
import com.projectzerotwo.model.Account;

public class JUnit {
	
	public JUnit() {
	}
	
	Account tester = new Account();

	@BeforeClass
	public static void methodCallBeforeAllTests() {
		System.out.println("WELCOME TO BANKING APP TEST");
	}
	
	@After
	public void afterMethod() {
		System.out.println("\n**************after each method**************");
	}
	
	@Test
	public void withdrawTest() throws WithdrawTooBigException {
		Double amt = 50.00;
		assertEquals("Should be 0", 0, Main.withdraw(tester, amt));
		System.out.println("withdrawTest success");
	}
	
	@Test
	public void depositTest() {
		Double amt = 50.00;
		assertEquals("Should be 0", 0, Main.deposit(tester, amt));
		System.out.println("depositTest success");
	}
	
	@Test
	public void transferTest() throws WithdrawTooBigException {
		Double amt = 50.00;
		int to = 1;
		assertEquals("Should be 0", 0, Main.transfer(tester, amt, to));
		System.out.println("transferTest success");
	}
}
