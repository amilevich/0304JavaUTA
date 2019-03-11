package com.projectzero.users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import com.projectzero.accounts.Account;
import com.projectzero.accounts.Application;
import com.projectzero.accounts.JointApplication;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//separate hashmap for employee loginInfo
	public static HashMap<String, Employee> loginEmpInfo = new HashMap<>();
	static String username = "employee";
	static String password = "pass123";
	static String firstName = "Morty";
	static String lastName = "Smith";

	//SHOULD authenticate Employee for login
	public static Employee authenticateEmp(String un, String pw) {
		loginEmpInfo.get(un);
		//check if username is in hashmap and if the password matches the hashmap password
		if (loginEmpInfo.containsKey(un) && Employee.getPassword().equals(pw)) {
			//returns username if successful, null if failed
			return loginEmpInfo.get(un);
		} else {
			return null;
		}

	}
		
	

	public Employee() {
	
	}

	//method to view Applications and approve or deny them
	public static String getUsername() {
		return username;
	}



	public static void setUsername(String username) {
		Employee.username = username;
	}



	public static String getPassword() {
		return password;
	}



	public static void setPassword(String password) {
		Employee.password = password;
	}



	public static String getFirstName() {
		return firstName;
	}



	public static void setFirstName(String firstName) {
		Employee.firstName = firstName;
	}



	public static String getLastName() {
		return lastName;
	}



	public static void setLastName(String lastName) {
		Employee.lastName = lastName;
	}



	public static boolean approveAccount(Account newAccount) {
		//Deserialize Application to check
		//CAN'T FIGURE OUT PROCESS
			//THOUGHT - txt file of all Application usernames?
		//return true to create account, false to deny
		return true;

	}
	public static boolean approveJointAccount(JointApplication a) {
		//Deserialize JointApplication to check 
		//CAN'T FIGURE OUT PROCESS
			//THOUGHT - txt file of all Application usernames?
		//return true to create account, false to deny
		return true;
	}
	
	//View balance of accepted account
	public static float viewAccountBal(Account a) {
		return a.getAccountBalance();

	}
	
	//view personal info of accepted account
	public static String viewAccountInfo(Account a) {
		String s = a.toString();
		return s;

	}
	
	//method to insert Employee account for authentication purposes
	public static void InsertEmployeeAccount() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					System.getProperty("user.dir") + "\\Employee.txt"));

			Employee emp = (Employee) ois.readObject();
			loginEmpInfo.put(username, emp);
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("No previous Employee account found. Please create one");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
