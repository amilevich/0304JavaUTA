package com.Banking;

import java.util.HashMap;

public class Admin extends Employee{

	private static final long serialVersionUID = 7487609311124474001L;
	private static HashMap<String, Admin> bankAdmin = new HashMap<String, Admin>();
	
	public Admin() {

	}

	public static Customer editCustomerInfo(Customer customer, String name, String userName, String passWord) {
		customer.setName(name);
		customer.setUserName(userName);
		customer.setPassWord(passWord);
		return customer;
	}
	
	public static void editAccountInfo(Customer customer, String userName, String personalInfo, String jointAccount) {
		customer.setInfo(userName, personalInfo);
		customer.addJointAccount(jointAccount);
	}
	
	public static void cancelAccount(Customer accountNum) {
		accountNum = null;
	}
}
