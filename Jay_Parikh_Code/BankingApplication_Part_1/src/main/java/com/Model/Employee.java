package com.Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Queue;

public class Employee{
	//View all accounts
	//approve/deny accounts
	//view account info, balances, personal info
	
	private String userName;
	private String passWord;
	private Integer type;

	public Employee() {
	
	}
	
	public Employee(String user, String pass, int empType) {
		this.userName = user;
		this.passWord = pass;
		this.type = empType;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	//Employee Frank = new Employee("Frank", "frank", "456");
	/*public static Employee bankLogin (String user, String pass) {
		if(bankEmployee.containsKey(user) && bankEmployee.get(user).getPassWord().equals(pass)) {
			return bankEmployee.get(user);
		}else {
			System.out.println("Username and Password do not match");
			return null; 
		}
		
	}*/
	
/*	static void writeObject(String filename, Employee obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			oos.writeObject(obj);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object readObject(String filename, Employee userName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			
			Object obj = ois.readObject();
			while(obj != null) {
				if(bankEmployee.containsKey(((Employee) userName).getUserName()))
					return bankEmployee.get(userName);
			}
			//System.out.println(obj);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
	//employee approves the customer and creates the account with same values
	//public static boolean approveAccount(Account custom) {
	/*	if(custom.getRegistered() == 0) { //&& getCustomerAccountApplications().contains(custom.getUserName())) {
			//removeCustomerApplications(custom.getUserName());
			custom.setBalance(0.0);
		}else {
			System.out.println("Account is already registered");
		}
		return true;
	}
	
	public static void denyAccount(Customer custom) {
		if(custom.getRegistered() == 0 && getCustomerAccountApplications().contains(custom.getUserName())) {
			removeCustomerApplications(custom.getUserName());
		}
	}
	
	public static void viewAccountBalance(Customer account) {
		System.out.println(account.getBalance());
	}
	
	public static void viewInfo(Customer customer) {
		System.out.println(customer.toString());
	}
	
*/
	
}
