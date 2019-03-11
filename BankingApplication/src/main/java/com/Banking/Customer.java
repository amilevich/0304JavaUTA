package com.Banking;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Queue;

public class Customer implements Serializable{
		//register with username & password
		//apply to open an account
		//withdraw, deposit, transfer, must catch overdrawing, negative amounts
	
	private static final long serialVersionUID = -3418258019299216183L;
	//private static final String filename = "./bankAccounts";
	
	private String name;
	private String userName;
	private String passWord;
	private double balance;
	private boolean isRegistered = false;
	
	static HashMap<String, Customer> bankCustomers = new HashMap<String, Customer>();
	protected static Queue<String> customerAccountApplications;
	
	public Customer() {
		
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", userName=" + userName + ", passWord=" + passWord + ", balance=" + balance
				+ "]";
	}


	//applying for an account
	public void applyAccount(Customer custom) {
		if(getRegistered() == false && Employee.approveAccount(custom)){
			custom.setRegistered(true);
			bankCustomers.put(custom.getUserName(), custom);
			System.out.println(bankCustomers);
		}else if(getRegistered() == false) {
			customerAccountApplications.add(custom.getUserName());
		}
	}
	
	//returns if the user has the matching username and password
	public static Customer bankLogin (String user, String pass) {
		if(bankCustomers.get(user).getPassWord() == pass) {
			return bankCustomers.get(user);
		}else {
			System.out.println("Username and Password do not match");
			return null; 
		}
		
	}
	
	public void addJointAccount(String newUser) {
		this.name = this.name + " " + newUser;
	}
	
	public void withdrawMoney(double i) {
		if(balance > i) {
			balance -= i;
		}else {
			System.out.println("Not enough balance to complete this transaction");
		}
	}
	
	public void depositMoney(double i) {
		balance += i;
	}
	
	public void transferMoney(double i, Customer depositAccountNum) {
		if(balance > i) {
			balance -= i;
			depositAccountNum.setBalance(depositAccountNum.getBalance() + i);
		}else {
			System.out.println("Not enough balance to complete this transaction");
		}
	}
	
	static void writeObject(String filename, Customer obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			oos.writeObject(obj);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			
			Customer readCustom = (Customer) ois.readObject();
			bankCustomers.put(readCustom.getName(), readCustom);
			//System.out.println(bankCustomers);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//------------------------------------------Getters and setters------------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean getRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}


	public static Queue<String> getCustomerAccountApplications() {
		return customerAccountApplications;
	}
	
	public static void removeCustomerApplications(String userName) {
		customerAccountApplications.remove(userName);
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public static HashMap<String, Customer> getBankCustomers() {
		return bankCustomers;
	}


	public static void setBankCustomers(HashMap<String, Customer> bankCustomers) {
		Customer.bankCustomers = bankCustomers;
	}

	public void setInfo(String userName, String name) {
		this.userName = userName;
		this.name = name;
		
	}

}
