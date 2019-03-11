package com.bank.customer;

import com.bank.office.App;

public class customer {
	
	private String username;
	private String password;
	private String first;
	private String last;
	private String sex;
	private String address;
	private String checking;
	private String joinAcc;
	private double amount;
	private String accountnumber;
	private String status;
	boolean waitApprove = false;

	private String dob;
	private String ssn;
	private String city;
	private String zipcode;
	private String telephone;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void runCust() {
		boolean t = false;
		System.out.println("Would you like to login or Register Account?");
		System.out.println("1. login");
		//System.out.print("2. Register");
		
		String s = App.input();
		do {
			switch (s) {
				case "1": System.out.println("call login mehtod "); t = true; break;
				case "2": System.out.println("call Register mehtod"); t= true; break;
				case "3": System.out.println("exit"); t= true; break;
				default: System.out.println("Please input valid key to be continoue");
					
			}
		}while (t==false);
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getChecking() {
		return checking;
	}

	public void setChecking(String checking) {
		this.checking = checking;
	}

	public String getJoinAcc() {
		return joinAcc;
	}

	public void setJoinAcc(String joinAcc) {
		this.joinAcc = joinAcc;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public boolean isWaitApprove() {
		return waitApprove;
	}

	public void setWaitApprove(boolean waitApprove) {
		this.waitApprove = waitApprove;
	}
	
	

}
