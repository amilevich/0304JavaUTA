package com.projectzero.users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import com.projectzero.accounts.Account;
import com.projectzero.accounts.WithdrawTooBigException;

public class Admin extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//separate hashmap for admin loginInfo
	public static HashMap<String, Admin> loginAdminInfo = new HashMap<>();

	//SHOULD authenticate Admin for login
	public static Admin authenticateAd(String un, String pw) {
		
		//check if username is in hashmap and if the password matches the hashmap password
		if (loginAdminInfo.containsKey(un) && loginAdminInfo.get(un).getPassword().equals(pw)) {
			//returns username if successful, null if failed
			return loginAdminInfo.get(un);
		} else {
			return null;
		}

	}

	public Admin(int id, String username, String password, String firstName, String lastName) {
	}

	//can cancel an account by its corresponding username
	public static void cancelAccount(Account a) {
		if (User.loginInfo.containsKey(a.getUsername())) 
			User.loginInfo.remove(a.getUsername());
	}

	//can do transactions with inserted Account
	public static void withdraw(float wAmount, Account a) throws WithdrawTooBigException {

		a.withdraw(wAmount);
	}

	public static void deposit(float dAmount, Account a) {
		a.deposit(dAmount);
	}

	public static void transfer(Account fromA, float tAmount, String toAccount) throws WithdrawTooBigException {
		fromA.transfer(tAmount, toAccount);
	}
	
	//method to insert Admin account for authentication purposes
	public static void InsertAdminAccount() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					System.getProperty("user.dir") + "\\Admin.txt"));

			Admin acct = (Admin) ois.readObject();
			loginAdminInfo.put(acct.getUsername(), acct);
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("No previous Admin account found. Please create one");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}