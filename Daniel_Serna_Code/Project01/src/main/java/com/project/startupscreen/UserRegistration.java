package com.project.startupscreen;

import java.io.Serializable;

public class UserRegistration implements Serializable {



	/**
	 *  generated serial version UID
	 */
	
	private static final long serialVersionUID = 1760797854622742053L;
	
	int ssn; 
	String fn; 
	String ln;
	String un; 
	String pw;
	int ab;
	String joint;
	String accountApp; 
	
	public UserRegistration( 
							int ssn,
							String firstName, 
							String lastName,
							String userName,
							String password,
							int accountBalance,
							String joint,
							String accountApplicationStatus) 
	{ 
		this.ssn = ssn; 
		this.fn = firstName; 
		this.ln = lastName; 
		this.un = userName;
		this.pw = password;
		this.ab = accountBalance;
		this.joint = joint; 
		this.accountApp = accountApplicationStatus; 
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getJoint() {
		return joint;
	}

	public void setJoint(String joint) {
		this.joint = joint;
	}

	public String getAccountApp() {
		return accountApp;
	}

	public void setAccountApp(String accountApp) {
		this.accountApp = accountApp;
	}
	
	public int getAb() {
		return ab;
	}

	public void setAb(int ab) {
		this.ab = ab;
	}
}
