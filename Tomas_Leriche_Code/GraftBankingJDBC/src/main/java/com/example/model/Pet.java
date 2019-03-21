package com.example.model;


// MUST REFLECT THE TABLE PERFECTLY
public class Pet {

	Integer pet_id;
	String name, type, password, hasAccount, accountApproved;
	
	public Pet(String name, String type, String pword) {
		super();
		this.name = name;
		this.type = type;
		this.password = pword;
		this.pet_id = null;

	}
	


	public Pet(Integer id, String name, String type, String password, String hasAccount,
				String accountApproved) {
		super();
		this.name = name;
		this.type = type;
		this.pet_id = id;
		this.password = password;
		this.hasAccount = hasAccount;
		this.accountApproved = accountApproved;

	}
	
	public Pet() {
		
	}
	

	/*
	 *  Need empty and parameterized constructor
	 */
	
	public String getAccountApproved() {
		return accountApproved;
	}

	public void setAccountApproved(String accountApproved) {
		this.accountApproved = accountApproved;
	}

	public String isHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(String hasAccount) {
		this.hasAccount = hasAccount;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pet [pet_id=" + pet_id + ", name=" + name + ", type=" + type + "]";
	}

}
