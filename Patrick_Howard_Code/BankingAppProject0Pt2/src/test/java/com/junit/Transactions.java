package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Transactions {

	Bank tester = new Bank();
	Integer accountBalance = 0;

	@BeforeClass
	public static void mehtodCalledBeforeTests() {
		System.out.println("Beginning of Tests");
	}

	@Test
	public void depositFunds() {
		System.out.println("Beginning of depositFunds()");
		Integer amount = 300;
		int total = accountBalance + amount;
		accountBalance = total;

		assertEquals("should deposit funds", 300, tester.depositFunds(0, total), 0.0);
		System.out.println("Mehtod deposited funds successfully");
	}

	@Test
	public void withdrawFunds() {
		System.out.println("Beginning of withdrawFunds()");
		Integer amount = 300;
		int total = accountBalance + amount;
		accountBalance = total;

		assertEquals("should withdraw funds", 200, tester.withdrawFunds(100, total), 0.0);
		System.out.println("Method withdrawl funds successfully");
	}

	@Test
	public void areUsersEqual() {
		assertEquals("Should be equal", true, tester.areUsersEqual("Bob", "Bob"));
		System.out.println("method to check for equality of strings");
	}
}
