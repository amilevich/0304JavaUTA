package com.bankApp.UnitTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bankApp.BankUserDAO.BankUserDAOImpl;
import com.bankApp.EmployeeDAO.EmployeeDAOImpl;
import com.bankApp.People.BankUser;

public class Tester {

	public Tester() {
	}

	@Before
	public void before() {
		System.out.println("Starting new test");
	}

	@After
	public void after() {
		System.out.println("Test complete\n");
	}

	// ***********************************Begin
	// AccountHolderTests***************************

	@Ignore
	public void unsuccessfulLoginUsername() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		
		boolean testSuccess = true;

		if (t.login("Quinton", "1234") != null) {
			testSuccess = false;
		}

		assertEquals("this should be true", true, testSuccess);
		System.out.println("Invalid username test successful");
	}

	@Ignore
	public void unsuccessfulLoginPassword() {
		BankUserDAOImpl t = new BankUserDAOImpl();

		boolean testSuccess = true;

		if (t.login("Quinton", "1") != null) {
			testSuccess = false;
		}

		assertEquals("this should be true", true, testSuccess);
		System.out.println("Invalid password test successful");
	}

	@Ignore
	public void successfulLogin() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		
		boolean testSuccess = false;
		
		if(t.login("Quinton", "1234") != null) {
			testSuccess = true;
		}
		
		assertEquals("this should be true", true, testSuccess);
		System.out.println("Successful login test success");
	}

	@Ignore
	public void successfulWithdrawl() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		
		assertEquals("this should be true:", true, t.withdraw(1,0, p));
		System.out.println("withdraw success");
	}

	@Ignore
	public void unsuccessfulWithdrawOverdraw() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		
		assertEquals("This should be false", false, t.withdraw(101,0,p));
		System.out.println("Overdraw money success");
	}

	@Ignore
	public void unsuccessfulWithdrawNegativeMoney() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		
		assertEquals("This should be false", false, t.withdraw(-1,0,p));
		System.out.println("Negative money withdraw success");
	}
	
	@Ignore
	public void successfulDeposit() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		
		assertEquals("This should be true", true, t.deposit(5,0, p));
		System.out.println("Deposit deposit test successful");
		t.withdraw(5,0, p);
	}

	@Ignore
	public void unsuccessfulDepositNegativeMoney() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		
		assertEquals("This should be true", false, t.deposit(-5,0,p));
		System.out.println("Unsuccessful deposit test success");
	}

	@Ignore
	public void successfulTransfer() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		BankUser p2 = t.login("Rowen", "1234");
		
		assertEquals("this should be true", true, t.transfer(5, 0 , 0, p, p2));
		System.out.println("Successful transfer test successful");
		t.transfer(5, 0, 0, p2, p);
	}

	@Ignore
	public void unsuccessfulTransferNegativeMoney() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		BankUser p2 = t.login("Rowen", "1234");
		
		assertEquals("this should be false", false, t.transfer(-3,0,0,p,p2));
		System.out.println("Unsuccessful transfer of negative money test successful");
	}

	
	@Ignore
	public void unsuccessfulTransferOverdraw() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = t.login("Quinton", "1234");
		BankUser p2 = t.login("Rowen", "1234");
		
		assertEquals("this should be false", false, t.transfer(101, 0, 0, p,p2));
		System.out.println("Unsuccessful transfer overdraw test successful");
	}

	
	@Ignore
	public void insertBankUserTest() {
		BankUserDAOImpl t = new BankUserDAOImpl();
		BankUser p = new BankUser("C","D","C","1234");
		
		t.insertBankUser(p);
		boolean testSuccess = false;
		
		if(t.login("C", "1234").equals(p)) {
			testSuccess = true;
		}
		
		assertEquals("This should be true", true, testSuccess);
	}
	
	/*
	 * TODO create a separate package for
	 * beans
	 * dao's
	 * driver class
	 */
	@Ignore
	public void insertAccountandApproveAccountTest() {
		EmployeeDAOImpl t = new EmployeeDAOImpl();
		BankUserDAOImpl t2 = new BankUserDAOImpl();
		BankUser p = t2.login("C", "1234");
		
		t.approveAccount(p.getAccount(0).getAccountNumber());
		
		assertEquals("This should be true",true, t2.deposit(100, 0, p));
	}
	// *******************END AccountHolder
	// Tests**********************

	// *****************Begin Employee
	// Tests**************************

	@Ignore
	public void viewAccountInfoTest() {
		EmployeeDAOImpl t = new EmployeeDAOImpl();
		
		ArrayList<BankUser> test = t.recallInformation(75);
		
		System.out.println(test.get(1).getFirstName());
		
		assertEquals("this should be true","D",test.get(1).getFirstName());
	}
	
	// *******************End Employee Tests******************************

	// *******************Begin Bank Admin Tests**************************
	@Test
	public void cancelAccountTest() {
		EmployeeDAOImpl t = new EmployeeDAOImpl();
		
		assertEquals("this should be true", true, t.deleteAccount(81));
		System.out.println("Cancel Account test successful");
	}
	
}
