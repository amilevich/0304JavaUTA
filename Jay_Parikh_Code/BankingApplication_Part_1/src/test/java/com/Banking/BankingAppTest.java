package com.Banking;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Main.Main;
import com.Model.Account;
import com.Model.Customer;
import com.Model.Employee;

public class BankingAppTest {
	
	@BeforeClass
	public static void methodCalledBeforeAllTests() {
		System.out.println("Welcome to JUnit!!");
	}
	
	
	@Test
	public void customerWithdraw() {
		Customer c = new Customer();
		Account a = new Account();
		a.setBalance(100.0);
		a.setStatus(1);
		assertEquals("should return true", 1, Main.withdraw(c));
		
	}
	
	@Test
	public void customerDeposit() {
		Customer c = new Customer();
		Account a = new Account();
		a.setBalance(100.0);
		a.setStatus(1);
		assertEquals("should return true", 1, Main.deposit(c));
		System.out.println("Deposit money");
	}
	
	@Test
	public void customerTransfer() {
		Customer c = new Customer();
		Account a = new Account();
		a.setBalance(100.0);
		a.setStatus(1);
		assertEquals("should return true", 1, Main.transfer(c));
		System.out.println("Transfer money");
	}		
}
	
