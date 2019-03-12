package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BankDatabase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4775813102960641641L;
	
	private List<User> user;
	private List<Account> account;
	private List<Application> application;
	private HashMap<String, String> userLoginMap;

	public BankDatabase() {
		this.user = new ArrayList<User>();
		this.account = new ArrayList<Account>();
		this.application = new ArrayList<Application>();
		this.userLoginMap = new HashMap<>();
	}


	// just getters and setters
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	public HashMap<String, String> getUserLoginMap() {
		return userLoginMap;
	}

	public void setUserLoginMap(HashMap<String, String> userLoginMap) {
		this.userLoginMap = userLoginMap;
	}

}
