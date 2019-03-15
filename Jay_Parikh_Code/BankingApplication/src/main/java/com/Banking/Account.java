/*package com.Banking;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;

public class Account extends Customer{

	private static final long serialVersionUID = 1L;
	private double balance;
	private String personalInfo;
	private String jointAccount;
	
	private static HashMap<String, Customer> allUsers = new HashMap<String, Customer>(); 
	
	public Account() {
		
	}
	
	@Override
	public String toString() {
		return "Account [balance=" + balance  + ", personalInfo=" + personalInfo + "]";
	}



	
	
	static void writeObject(String filename, Account obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			oos.writeObject(obj);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Customer readObject(String filename, Account userName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			
			Object obj = ois.readObject();
			while((String)obj != null) {
				if(allUsers.containsKey(userName.getUserName()))
					return allUsers.get(userName.getUserName());
				
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

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double num) {
		balance = num;
	}
	
	public String getPersonalInfo() {
		return personalInfo;
	}
	
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}

	public String getJointAccount() {
		return jointAccount;
	}

	public void setJointAccount(String jointAccount) {
		this.jointAccount = jointAccount;
	}

	public HashMap<String, Customer> getAllUsers() {
		return allUsers;
	}

	public void addUsers(String users, Customer customer) {
		allUsers.put(users, customer);
	}
}
*/