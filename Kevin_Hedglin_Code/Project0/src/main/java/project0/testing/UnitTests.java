package project0.testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project0.account.Account;
import project0.users.Admin;
import project0.users.Employee;
import project0.users.User;

public class UnitTests {

	private User testUserA;
	private User testUserB;
//	private Employee testEmployee;
//	private Admin testAdmin;
	private Account testBankAccountA;
	private Account testBankAccountB;

	public UnitTests() {
		
	}

	@Before
	public void setUp() {
		
		//testEmployee = new Employee("ralph", "smith", "Employee1", "password");
		//testAdmin = new Admin("Tim", "Franklin", "Admin1", "password");
		
		testUserA = User.getUser("UserA");
		testUserB = User.getUser("UserB");
		
		if(testUserA == null)
		{
			testBankAccountA = new Account("TestAccountA", 50f, true, new ArrayList<String>(Arrays.asList("UserA")));
			testUserA = new User("jim", "bobson", "UserA", "password", new ArrayList<Account>(Arrays.asList(testBankAccountA)));
			User.saveUser(testUserA);
			Account.insertAccount(testBankAccountA);
		}
		else
		{
			testBankAccountA = testUserA.getBankAccounts().get(0);
		}
		if(testUserB == null)
		{
			testBankAccountB = new Account("TestAccountB", 50f, true, new ArrayList<String>(Arrays.asList("UserB")));
			testUserB = new User("ron", "Walters", "UserB", "password", new ArrayList<Account>(Arrays.asList(testBankAccountB)));
			User.saveUser(testUserB);
			Account.insertAccount(testBankAccountB);
		}
		else
		{
			testBankAccountB = testUserB.getBankAccounts().get(0);
		}
		
		
		System.out.println("Beginning test...");
	}
	
	@After
	public void after() {
		System.out.println("Test complete...");
	}

	@Test
	public void successfulDeposit() {
		assertEquals("This should be true", true, testBankAccountA.deposit(5));
	
		System.out.println("deposited successfully");
	}
	
	@Test
	public void successfulDepositAmount() {
		testBankAccountA.deposit(5);
		assertEquals("This should be true", 55, testBankAccountA.getBalance(), 0.001);
	
		System.out.println("deposited successfully");
	}

	@Test
	public void unsuccessfulDepositNegativeAmount() {
		assertEquals("This should be false", false, testBankAccountA.deposit(-5));
		System.out.println("deposit negative test successful");
	}

	@Test
	public void successfulWithdraw() {
		assertEquals("This should be true", true, testBankAccountA.withdraw(10));
		System.out.println("Withdrew successfully");
	}
	
	@Test
	public void successfulWithdrawAmount() {
		testBankAccountA.withdraw(10);
		assertEquals("This should be true", 40, testBankAccountA.getBalance(), 0.001);
		System.out.println("Withdrew successfully");
	}

	@Test
	public void unsuccessfulOverdraw() {
		assertEquals("This should be false", false, testBankAccountA.withdraw(200));
		System.out.println("Overdraw test successful");
	}

	@Test
	public void unsuccessfulWithdrawNegativeAmount() {
		assertEquals("This should be false", false, testBankAccountA.withdraw(-50));
		System.out.println("Negative withdraw test successful");
	}


	@Test
	public void successfulTransfer() {

		assertEquals("This should be true", true, testBankAccountA.transferFunds(testBankAccountB, 10));
		System.out.println("successful transfer test");
	}
	
	@Test
	public void successfulTransferAmountAccountA() {
		testBankAccountA.transferFunds(testBankAccountB, 10);
		assertEquals("This should be true", 40, testBankAccountA.getBalance(), 0.001);
		System.out.println("successful transfer test");
	}
	@Test
	public void successfulTransferAmountAccountB() {

		testBankAccountA.transferFunds(testBankAccountB, 10);
		assertEquals("This should be true", 60, testBankAccountB.getBalance(), 0.001);
		System.out.println("successful transfer test");
	}

	@Test
	public void unsuccessfulTransferNegativeAmount() {
		assertEquals("This should be false", false, testBankAccountA.transferFunds(testBankAccountB, -10));
		System.out.println("Unsuccessful transfer of negative money test successful");
	}

	@Test
	public void unsuccessfulTransferOverdraw() {
		assertEquals("This should be false", false, testBankAccountA.transferFunds(testBankAccountB, 200));
		System.out.println("Unsuccessful transfer of negative money test successful");
	}

	@Test
	public void successfulLogin() {
		boolean test;

		if(User.login("UserA", "password") != null)
		{
			test = true;
		}
		else
		{
			test = false;
		}

		assertEquals("this should be true", true, test);
		System.out.println("Username test successful");
	}

	@Test
	public void unsuccessfulLoginUserNotExist() {
		boolean test;
		if(User.login("User200", "password") != null)
		{
			test = true;
		}
		else
		{
			test = false;
		}

		assertEquals("this should be false", false, test);
		System.out.println("Wrong username test successful");
	}

	@Test
	public void unsuccessfulLoginWrongPassword() {
		boolean test;
		if(User.login("User1", "password200") != null)
		{
			test = true;
		}
		else
		{
			test = false;
		}

		assertEquals("this should be false", false, test);
		System.out.println("Wrong password test successful");
	}
	
	@Test
	public void loadUser() {
		User u = User.loadUser(testUserA.getUsername());
		
		assertEquals("this should be jim", "jim", u.getFirstName());
		System.out.println("Save user test successful");
	}
	
	@Test
	public void loadAccount() {
		Account a = Account.getAccount(testBankAccountA.getAccountID());
		
		assertEquals("this should be 50", 50, a.getBalance(), 0.001);
		System.out.println("Save user test successful");
	}
}
