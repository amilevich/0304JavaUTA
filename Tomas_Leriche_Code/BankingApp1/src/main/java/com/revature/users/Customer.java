package com.revature.users;

import java.io.IOException;
import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5159718083862330454L;
	private String firstName;
	private String lastname;
	private String userID;
	private String userName;
	private Account account;
	private String password;
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	Customer(){
		System.out.println("Customer Made " + serialVersionUID);
	}
	
	public Customer(String firstname, String lastName, String userID, String userName, Account account, String pw){
		System.out.println("Customer " + firstname + " " + lastName + " Made with " + serialVersionUID);
		
		
		this.firstName = firstname;
		this.lastname = lastName;
		this.userID = userID;
		this.userName = userName;
		this.account = account;
		this.password = pw;
		
	}
	
	
//	public static void register(String s1, String s2) {
//		
//	}
	
	
	
	public final void writeObject(Object obj) throws IOException {
		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
