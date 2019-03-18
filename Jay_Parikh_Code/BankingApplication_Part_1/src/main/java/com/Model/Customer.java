package com.Model;

public class Customer{
		//register with username & password
		//apply to open an account
		//withdraw, deposit, transfer, must catch overdrawing, negative amounts
	
	private Integer customerid;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String personalInfo;
	private Integer accountid;
	private int isRegistered = 0;
	
	public Customer() {
		
	}
	
	//userN, passW, fname, lname, perInfo
	public Customer(String userN, String passW, String fname, String lname, String perInfo, Integer accountid) {
		this.customerid = null;
		userName = userN;
		passWord = passW;
		firstName = fname;
		lastName = lname;
		personalInfo = perInfo;
		this.accountid = accountid;
	}
	
	public Customer(Integer custid, String userN, String passW, String fname, String lname, String perInfo, Integer accountid) {
		this.customerid = custid;
		userName = userN;
		passWord = passW;
		firstName = fname;
		lastName = lname;
		personalInfo = perInfo;
		this.accountid = accountid;
	}


	@Override
	public String toString() {
		return "Customer " + firstName + " " + lastName + ", with userName = " + userName + ", and SSN = " + personalInfo + ".";
	}



	
	//------------------------------------------Getters and setters------------------------------------------------
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		lastName = name;
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

	public int getRegistered() {
		return isRegistered;
	}

	public void setRegistered() {
		this.isRegistered = 1;
	}
	
	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	
	public String getPersonalInfo() {
		return personalInfo;
	}
	
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}


/*	public static Queue<String> getCustomerAccountApplications() {
		return customerAccountApplications;
	}
	
	public static void removeCustomerApplications(String userName) {
		customerAccountApplications.remove(userName);
	}

	public static HashMap<String, Customer> getBankCustomers() {
		return bankCustomers;
	}


	public static void setBankCustomers(HashMap<String, Customer> bankCustomers) {
		Customer.bankCustomers = bankCustomers;
	}*/
}
