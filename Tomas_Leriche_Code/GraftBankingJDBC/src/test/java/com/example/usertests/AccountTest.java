package com.example.usertests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.model.Account;
import com.example.model.Employee;
import com.example.model.Pet;
import com.example.dao.AccountDaoImpl;
import com.example.dao.EmployeeDaoImpl;
import com.example.dao.PetDaoImpl;
import com.example.driver.Main;

public class AccountTest {
	
	PetDaoImpl petDaoImpl = new PetDaoImpl();
	AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
	EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	
	List<Pet> pets = petDaoImpl.selectAllPets();
	List<Account> accounts = accountDaoImpl.selectAllAccounts();
	List<Employee> employees = employeeDaoImpl.selectAllEmployees();
	
	@BeforeClass
	public static void say() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@ Beginning of JUnit testing @@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
	}
	
	@Ignore
	public void after() {
		System.out.println("This should be ignored");
	}
	
	
	@After
	public void partition() {
		System.out.println("\n|------------------------------------------------------------|\n");
	}
	
	@Test
	public void getBalance() {

		Account acc = new Account(22,500.0);
		Account acc1 = new Account(23,500.0);
		acc.setPet_id(5);
		
		accounts.add(acc);
		accounts.add(acc1);
		
		Pet pet = new Pet();
		pet.setName("Bob");
		pet.setPassword("test");
		pet.setPet_id(5);
		
//		System.out.println(pet);
//		System.out.println(acc);

		assertEquals("should return double",
					500.0,
					Main.seeBalance(pet, accounts), 0.001);
		
		System.out.println("method seeBalance() tested successfully");
	}
	
	@Test
	public void deposit() {
		
		Pet pet = new Pet();
		pet.setName("Bob");
		pet.setPassword("test");
		pet.setPet_id(5);
		
		Account acc = new Account(22,500.0);
		Account acc1 = new Account(23,500.0);
		acc.setPet_id(5);
		
		accounts.add(acc);
		accounts.add(acc1);
		
		assertEquals("should return double",
				acc,
				Main.deposit(pet, accounts, 25.5));
	
		System.out.println("method deposit() tested successfully");
		
	}
	
	@Test
	public void withdraw() {
	
		Pet pet = new Pet();
		pet.setName("Bob");
		pet.setPassword("test");
		pet.setPet_id(5);
		
		Account acc = new Account(22,500.0);
		Account acc1 = new Account(23,474.5);
		acc.setPet_id(5);
		
		accounts.add(acc);
		accounts.add(acc1);
		
		assertEquals("should return double",
				acc,
				Main.withdraw(pet, accounts, 25.5));
	
		System.out.println("method withdraw() tested successfully");
	}
	
	@Test
	public void transfer() {
		
		Pet pet1 = new Pet();
		pet1.setName("Bob");
		pet1.setPassword("test");
		pet1.setPet_id(5);
		
		Pet pet2 = new Pet();
		pet2.setName("John");
		pet2.setPassword("test");
		pet2.setPet_id(6);
		
		Account acc = new Account(22,500.0);
		Account acc1 = new Account(23,500.0);

		acc.setPet_id(5);
		acc1.setPet_id(6);

		accounts.add(acc);
		accounts.add(acc1);
		
		assertEquals("should return double",
				"Success",
				Main.transfer(pet1, pet2, accounts,  25.5, accountDaoImpl));
		
		System.out.println("method transfer() tested successfully");
		
	}
	
	@AfterClass
	public static void sayEnd() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@ End of JUnit testing @@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
}
