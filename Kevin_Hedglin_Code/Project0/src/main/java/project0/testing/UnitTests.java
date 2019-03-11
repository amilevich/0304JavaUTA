package project0.testing;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project0.account.Account;
import project0.users.Admin;
import project0.users.Employee;
import project0.users.User;

public class UnitTests {

	private User testUser;
	private Employee testEmployee;
	private Admin testAdmin;
	private Account testBankAccountA;
	private Account testBankAccountB;

	public UnitTests() {
		
	}

	@Before
	public void setUp() {
		testUser = new User("jim", "bobson", "User1", "password");
		testEmployee = new Employee("ralph", "smith", "Employee1", "password");
		testAdmin = new Admin("Tim", "Franklin", "Admin1", "password");

		ArrayList<String> accountOwners = new ArrayList<String>();
		accountOwners.add("User1");
		accountOwners.add("Employee1");
		accountOwners.add("Admin1");
		testBankAccountA = new Account("TestAccountA", accountOwners);
		testBankAccountB = new Account("TestAccountB", accountOwners);
		
		testBankAccountA.deposit(20);
		
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
		assertEquals("This should be true", 25, testBankAccountA.getBalance(), 0.001);
	
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
		assertEquals("This should be true", 10, testBankAccountA.getBalance(), 0.001);
		System.out.println("Withdrew successfully");
	}

	@Test
	public void unsuccessfulOverdraw() {
		assertEquals("This should be false", false, testBankAccountA.withdraw(50));
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
		assertEquals("This should be true", 10, testBankAccountA.getBalance(), 0.001);
		System.out.println("successful transfer test");
	}
	@Test
	public void successfulTransferAmountAccountB() {

		testBankAccountA.transferFunds(testBankAccountB, 10);
		assertEquals("This should be true", 10, testBankAccountB.getBalance(), 0.001);
		System.out.println("successful transfer test");
	}

	@Test
	public void unsuccessfulTransferNegativeAmount() {
		assertEquals("This should be false", false, testBankAccountA.transferFunds(testBankAccountB, -10));
		System.out.println("Unsuccessful transfer of negative money test successful");
	}

	@Test
	public void unsuccessfulTransferOverdraw() {
		assertEquals("This should be false", false, testBankAccountA.transferFunds(testBankAccountB, 50));
		System.out.println("Unsuccessful transfer of negative money test successful");
	}

	@Test
	public void successfulLogin() {
		boolean test;

		if(User.login("User1", "password") != null)
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


}
