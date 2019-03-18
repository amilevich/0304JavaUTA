package com.project0;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.project0.Build.Account;

public class Testing {
	
	Account Alpha = new Account("Temp","Temp","Temp");
	
	@Test
	public void Deposit() {
		assertEquals("should return true", true, Alpha.Deposit(500.0) == 500.0);
		System.out.println("method to check funds are being added");
		
	}
	
	@Test
	public void Withdraw() {
		assertEquals("should return true", true, Alpha.Withdraw(500.0) == 0.0);
		System.out.println("method to check funds are being taken");
		
	}
}
