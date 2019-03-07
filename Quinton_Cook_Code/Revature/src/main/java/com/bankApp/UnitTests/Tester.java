package com.bankApp.UnitTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import com.bankApp.Account.Account;
import com.bankApp.People.BankAdmin;
import com.bankApp.People.Employee;

public class Tester {

	public Tester() {
	}

	@Before
	public void before() {
		System.out.println("Starting new test");
	}

	@After
	public void after() {
		System.out.println("\nTest complete\n");
	}

	// ***********************************Begin
	// AccountHolderTests***************************

	@Test
	public void successfulWithdrawl() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("This should be true", true, quinton.withdraw(3));
		quinton.deposit(3);
		System.out.println("withdraw success");
	}

	@Test
	public void unsuccessfulWithdrawOverdraw() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("This should be false", false, quinton.withdraw(11));
		System.out.println("Overdraw money success");
	}

	@Test
	public void unsuccessfulWithdrawNegativeMoney() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("This should be false", false, quinton.withdraw(-1));
		System.out.println("Negative money withdraw success");
	}

	@Test
	public void successfulDeposit() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("This should be true", true, quinton.deposit(5));
		System.out.println("Deposit deposit test successful");
	}

	@Test
	public void unsuccessfulDepositNegativeMoney() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("This should be true", false, quinton.deposit(-5));
		System.out.println("Unsuccessful deposit test success");
	}

	@Test
	public void successfulTransfer() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		Account rowen = new Account("Rowen", "Atkinson", "Rowan", "1234", 10, "Rowen");
		assertEquals("this should be true", true, quinton.transfer(rowen, 3));
		System.out.println("Successful transfer test successful");
	}

	@Test
	public void unsuccessfulTransferNegativeMoney() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		Account rowen = new Account("Rowen", "Atkinson", "Rowan", "1234", 10, "Rowen");
		assertEquals("this should be false", false, quinton.transfer(rowen, -3));
		System.out.println("Unsuccessful transfer of negative money test successful");
	}

	@Test
	public void unsuccessfulTransferOverdraw() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		Account rowen = new Account("Rowen", "Atkinson", "Rowan", "1234", 10, "Rowen");
		assertEquals("this should be false", false, quinton.transfer(rowen, 11));
		System.out.println("Unsuccessful transfer overdraw test successful");
	}

	@Test
	public void unsuccessfulLoginUsername() {
		assertEquals("this should be false", false, Account.login("Q", "1"));
		System.out.println("Invalid username test successful");
	}

	@Test
	public void unsuccessfulLoginPassword() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		Account.applyForAccount(quinton);
		assertEquals("this should be false", false, Account.login("Quinton", "1"));
		System.out.println("Invalid password test successful");
	}

	@Test
	public void successfulLogin() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		Account.applyForAccount(quinton);
		assertEquals("this should be true", true, Account.login("Quinton", "1234"));
		System.out.println("Successful login test success");
	}

	@Test
	public void successfulApplyForSingleAccount() {
		Account test = new Account("Q", "Q", "Q", "Q", 1, "Q");
		assertEquals("this should be true", true, Account.applyForAccount(test));
		System.out.println("Account Application test successful");
	}
	// *******************END AccountHolder
	// Tests**********************

	// *****************Begin Employee
	// Tests**************************

	@Test
	public void testViewAccountInfo() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		String[] quintonsInfo = { "Quinton", "Cook", "Quinton", "1234", Double.toString(quinton.getCurrentBalance()),
				"Quinton" };
		
		assertEquals("this should match:" , quintonsInfo[0], Employee.recallInformation(quinton)[0]);
		System.out.println("View Account Information test successful");

	}

	@Test
	public void viewAccountBalance() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("this should be 5", quinton.getCurrentBalance(), Employee.viewAccountBalance(quinton), 0);
		System.out.println("View Account Balance test successful");
	}

	@Test
	public void reviewAccount() {
		Account test = new Account("A", "B", "C", "D", 0, "NO ONE");
		assertEquals("this should be true", true, Employee.reviewAccount(test));
		System.out.println("Review Account test successful");
	}

	// *******************End Employee Tests******************************

	// *******************Begin Bank Admin Tests**************************

	@Test
	public void withdrawAdmin() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("this should be true", true, BankAdmin.withdraw(quinton, 5));
		System.out.println("Admin withdrawl test successful");
	}

	@Test
	public void depositAdmin() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		assertEquals("this should be true", true, BankAdmin.deposit(quinton, 5));
		System.out.println("Admin deposit test successful");
	}

	@Test
	public void transferAdmin() {
		Account quinton = new Account("Quinton", "Cook", "Quinton", "1234", 10, "Quinton");
		Account rowen = new Account("Rowen", "Atkinson", "Rowan", "1234", 10, "Rowen");

		assertEquals("this should be true", true, BankAdmin.transfer(quinton, rowen, 4));
		System.out.println("Admin transfer test successful");
	}

	@Test
	public void cancelAccountTest() {
		Account tmp = new Account("Q", "Q", "unique", "Q", 0, "NO ONE");

		Account.applyForAccount(tmp);

		assertEquals("this should be true", true, BankAdmin.cancelAccount(tmp));
		System.out.println("Cancel Account test successful");
	}

}
