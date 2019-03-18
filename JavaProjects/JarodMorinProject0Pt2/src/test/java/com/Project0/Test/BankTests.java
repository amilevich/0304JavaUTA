package com.Project0.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Project0.Bank.Bank;

public class BankTests {

	@Before
	public void shushSyso() {	// Suppress System.output statements by changing the output stream
	    System.setOut(new PrintStream(new ByteArrayOutputStream()));
	    System.setErr(new PrintStream(new ByteArrayOutputStream()));
	}

	@After
	public void restoreSyso() {	// Re-enable System.output statements by restoring the output stream
	    System.setOut(System.out);
	    System.setErr(System.err);
	}
	
	
	@Test
	public void createUserTest() {
		Bank banky = new Bank();
		File fileName = new File("./BankCreateUserTest.txt");
		
		Scanner fileScanner;
		String username = null;
		
		try {
			fileScanner = new Scanner(fileName);
			username = fileScanner.nextLine();
			System.out.println("username is " + username);
			banky.createUser(fileScanner);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		assertEquals("should return true", true, banky.getUserMap().containsKey(username));
	}
}
