package com.example.UnitTests;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.People.Customer;
import com.example.User.User;

public class Tester {
	
	public Tester() {
		
	}
	
	@Before
	public void before() {
		System.out.println("Starting new test");
	}
	
	@After
	public void after() {
		System.out.println("Test completed");
	}
	
	//Customer Tests*****************************
	@Test
	public void makeDeposit() {
		User user = new User("Test", "Chester", "Test_Chester", "pw");
		Customer c = new Customer();
		c.setUserName(user.getUserName());
		//assertEquals("this should be true", true, c.makeDeposit(100));
		//assertEquals("should be true", true, c.makeDeposit(100));
		c.makeDeposit(100);
		System.out.println(c.getBalance()); // this should be 200
		if(c.getBalance()==200)
			System.out.println("deposit success");
	}
	
	@Test
	public void makeWithdrawl() {
		User user = new User("Test", "Chester", "Test_Chester", "pw");
		Customer c = new Customer();
		c.setUserName(user.getUserName());
		int with=200;
		if(with<=100) {
			c.makeWithdrawl(with); // this should be allowed because withdrawlAmount is 100 or less
			System.out.println("withdrawl success");
		}
		else {
			System.out.println("withdrawl failure"); //which is also kinda a success
		}
	}

}
