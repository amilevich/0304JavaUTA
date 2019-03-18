package com.project.model;

public class Junction {

	String userName;
	int account_id;
	
	public Junction()
	{
		
	}
	
	public Junction(String userName, int account_id)
	{
		this.userName = userName; 
		this.account_id = account_id; 
	}

	@Override
	public String toString() {
		return "Junction [userName=" + userName + ", account_id=" + account_id + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	
}
