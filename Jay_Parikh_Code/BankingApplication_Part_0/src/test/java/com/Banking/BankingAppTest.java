package com.Banking;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Banking.Customer;

public class BankingAppTest {
	
	Employee test = new Employee();
	Admin admin = new Admin();
	Customer customer = new Customer();
	
	@BeforeClass
	public static void methodCalledBeforeAllTests() {
		System.out.println("Welcome to JUnit!!");
	}
	
	@Test
	public void customerWithdraw() {
		customer.setBalance(100);
		assertEquals("should return true", true, customer.withdrawMoney(20));
		System.out.println("Withdraw money");
	}
	
	@Test
	public void customerDeposit() {
		customer.setBalance(100);
		assertEquals("should return true", true, customer.depositMoney(20));
		System.out.println("Deposit money");
	}
	
	@Test
	public void customerTransfer() {
		customer.setBalance(100);
		Customer customer2 = new Customer();
		assertEquals("should return true", true, customer.transferMoney(20, customer2));
		System.out.println("Transfer money");
	}
	
	
	
}
