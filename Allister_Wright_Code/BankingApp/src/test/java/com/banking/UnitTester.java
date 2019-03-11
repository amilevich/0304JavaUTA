package com.banking;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTester
{

		@Before
		public void before()
		{
			System.out.println("BEGIN NEW TEST");
		}
		
		@After
		public void after()
		{
			System.out.println("TEST RUN COMPLETE");
		}
		
		// **** User Interface ****
		@Test
		public void loginSuccess() {
			Customer c = new Customer("Name", "uname", "pass");
			ArrayList<Customer> cList = new ArrayList<>();
			cList.add(c);
			
			assertTrue("This login should succeed", c.getLogin("uname", "pass"));
			System.out.println("Login Pass Success");
		}
		
		@Test
		public void loginFail() {
			Customer c = new Customer("Name", "uname", "pass");
			ArrayList<Customer> cList = new ArrayList<>();
			cList.add(c);
			
			assertTrue("This login should false", !c.getLogin("uname", ""));
			System.out.println("Login Fail Success");
		}
		
		// **** Account Actions ****
		@Test
		public void withdrawSuccess() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
	
			try
			{
				account.requestWithdrawl(50);
				assertTrue("Remaining balance should be 50", 50 == account.getBalance());
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test withdrawl should avoid overdraft");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test withdrawl should be positive");
				e1.printStackTrace();
			}
			System.out.println("Withdraw success");
		}
		
		@Test
		public void withdrawFailNegative() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test deposit should be positive");
				e1.printStackTrace();
			}
			
			try
			{
				account.requestWithdrawl(-300);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test withdrawl should be in memory range");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				assertTrue("Account balance should be unchanged", 100 == account.getBalance());
				System.out.println("Negative Withdraw success");
			}
		}
		
		@Test
		public void withdrawFailOverdraft() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test deposit should be positive");
				e1.printStackTrace();
			}
			
			try
			{
				account.requestWithdrawl(300);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				assertTrue("Account balance should be unchanged", 100 == account.getBalance());
				System.out.println("Withdraw Overdraft success");
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Withdrawl should be positive");
			}
		}
		
		@Test
		public void withdrawFailNotOpen() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
	
			account.closeAccount();
			try
			{
				account.requestWithdrawl(50);
			}
			catch (AccountNotOpenException e1)
			{
				assertTrue("Account should not be open", 100 == account.getBalance());
				System.out.println("Withdraw Account Not Open Success");
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test withdrawl should avoid overdraft");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test withdrawl should be positive");
				e1.printStackTrace();
			}
		}
		
		@Test
		public void depositSuccess() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
			assertTrue("Account should contain test deposit", 100 == account.getBalance());
			System.out.println("Deposit Success");
		}
		
		@Test
		public void depositFailMemory() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			try
			{
				account.requestDeposit(100);
				account.requestDeposit(Double.MAX_VALUE);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				assertTrue("Balance Overflow should be avoided", 100 == account.getBalance());
				System.out.println("Deposit Overflow success");
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
		}
		
		@Test
		public void depositFailNotOpen() {
			Customer c = new Customer("Name", "uname", "pass");
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				assertTrue("Account Should not be Open", 0 == account.getBalance());
				System.out.println("Deposit Not Open Success");
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
		}
		
		@Test
		public void transferSuccess() {
			Customer c1 = new Customer("Name", "uname", "pass");
			Customer c2 = new Customer("Name", "user", "pass");
			Employee e = new Employee(null, null);
			Account account1 = new Account(0, Account.AccountType.CHECKING, c1);
			Account account2 = new Account(1, Account.AccountType.CHECKING, c2);
			e.approveApplication(account1);
			e.approveApplication(account2);
			try
			{
				account1.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 1 should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
			
			try
			{
				account1.requestTransfer(50, account2);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 2 Should be open");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Transfer amount should be positive");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Transfer amount should be valid for both accounts");
				e1.printStackTrace();
			}
			assertTrue("Account 2 should have received transfer", 50 == account2.getBalance());
			System.out.println("Transfer Success");
		}
		
		@Test
		public void transferFailOverdraft() {
			Customer c1 = new Customer("Name", "uname", "pass");
			Customer c2 = new Customer("Name", "user", "pass");
			Employee e = new Employee(null, null);
			Account account1 = new Account(0, Account.AccountType.CHECKING, c1);
			Account account2 = new Account(1, Account.AccountType.CHECKING, c2);
			e.approveApplication(account1);
			e.approveApplication(account2);
			try
			{
				account1.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 1 should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
			
			try
			{
				account1.requestTransfer(300, account2);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 2 Should be open");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Transfer amount should be positive");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				assertTrue("Overdraft from Account 1 should be caught", 100 == account1.getBalance());
				System.out.println("Transfer Overdraft Success");
			}
		}
		
		@Test
		public void transferFailThisNotOpen() {
			Customer c1 = new Customer("Name", "uname", "pass");
			Customer c2 = new Customer("Name", "user", "pass");
			Employee e = new Employee(null, null);
			Account account1 = new Account(0, Account.AccountType.CHECKING, c1);
			Account account2 = new Account(1, Account.AccountType.CHECKING, c2);
			e.approveApplication(account1);
			e.approveApplication(account2);
			try
			{
				account1.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 1 should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
			
			account1.closeAccount();
			try
			{
				account1.requestTransfer(50, account2);
			}
			catch (AccountNotOpenException e1)
			{
				assertTrue("Account 1 should not be open", 100 == account1.getBalance());
				System.out.println("Transfer Fail This Not Open Success");
			}
			catch (NegativeMoneyException e1)
			{
				fail("Transfer amount should be positive");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Transfer amount should be valid for both accounts");
				e1.printStackTrace();
			}
		}
		
		@Test
		public void transferFailTargetNotOpen() {
			Customer c1 = new Customer("Name", "uname", "pass");
			Customer c2 = new Customer("Name", "user", "pass");
			Employee e = new Employee(null, null);
			Account account1 = new Account(0, Account.AccountType.CHECKING, c1);
			Account account2 = new Account(1, Account.AccountType.CHECKING, c2);
			e.approveApplication(account1);

			try
			{
				account1.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 1 should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
			
			try
			{
				account1.requestTransfer(50, account2);
			}
			catch (AccountNotOpenException e1)
			{
				assertTrue("Target Account should not be open", 
						100 == account1.getBalance() &&
						0 == account2.getBalance());
				System.out.println("Transfer Fail Target Not Open Success");
			}
			catch (NegativeMoneyException e1)
			{
				fail("Transfer amount should be positive");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Transfer amount should be valid for both accounts");
				e1.printStackTrace();
			}
		}
		
		@Test
		public void transferFailTargetMemory() {
			Customer c1 = new Customer("Name", "uname", "pass");
			Customer c2 = new Customer("Name", "user", "pass");
			Employee e = new Employee(null, null);
			Account account1 = new Account(0, Account.AccountType.CHECKING, c1);
			Account account2 = new Account(1, Account.AccountType.CHECKING, c2);
			e.approveApplication(account1);
			e.approveApplication(account2);
			try
			{
				account1.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 1 should be open");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
			
			try
			{
				account2.requestDeposit(Double.MAX_VALUE);
				account1.requestTransfer(50, account2);
			}
			catch (AccountNotOpenException e1)
			{
				fail("Account 2 Should be open");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Transfer amount should be positive");
				e1.printStackTrace();
			}
			catch (InvalidBalanceException e1)
			{
				assertTrue("Transfer Overflow should be caught",
						100 == account1.getBalance() &&
						Double.MAX_VALUE == account2.getBalance());
				System.out.println("Transfer Overflow Success");
			}
		}
		
		@Test
		public void closeAccountSuccess() {
			Customer c = new Customer("Name", "uname", "pass");
			Employee e = new Employee(null, null);
			Account account = new Account(0, Account.AccountType.CHECKING, c);
			e.approveApplication(account);
			account.closeAccount();
			try
			{
				account.requestDeposit(100);
			}
			catch (AccountNotOpenException e1)
			{
				assertTrue("Account should be closed", 0 == account.getBalance());
				System.out.println("Account Closed Success");
			}
			catch (InvalidBalanceException e1)
			{
				fail("Test balance should be valid");
				e1.printStackTrace();
			}
			catch (NegativeMoneyException e1)
			{
				fail("Test Deposit should be positve");
				e1.printStackTrace();
			}
		}
		
		// **** Employee Actions ****
		
		@Test
		public void viewAccountSuccess() {}
		/*
		@Test
		public void viewBalanceSuccess() {}
		
		@Test
		public void viewCustomerSuccess() {}
		
		@Test
		public void approveAccountSuccess() {}
		
		@Test
		public void denyAccountSuccess() {}
		
		
		// **** Admin Actions ****
		
		@Test
		public void adminWithdraw() {}
		
		@Test
		public void adminDeposit() {}
		
		@Test
		public void adminTransfer() {}
		
		@Test
		public void adminClose() {}
		
		@Test
		public void adminApprove() {}
		
		@Test
		public void adminDeny() {}
		
		// **** Data Persistence ****
		
		@Test
		public void saveUsers() {}
		
		@Test
		public void saveAccounts() {}
		
		@Test
		public void loadUsers() {}
		
		@Test
		public void loadAccounts() {}
		*/
}
