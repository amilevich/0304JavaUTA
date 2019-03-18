package com.projectzerotwo.model;

public class User {

	Integer userid = null;
	Integer accNumber;
	String username, password, firstname, lastname;
	Integer type;

	public User() {
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {

		return "id:\t\t" + userid + "\ntype:\t\t" + type() + "\nfirst name:\t" + firstname + "\nlast name:\t" + lastname
				+ "\nusername:\t" + username + "\npassword\t" + password + "\naccount num:\t" + accNumber + "\n";
		// return "User [userid=" + userid + ", accNumber=" + accNumber + ", username="
		// + username + ", password="
		// + password + ", firstname=" + firstname + ", lastname=" + lastname + ",
		// type=" + type + "]";
	}

	public User(Integer userid, Integer accNumber, String username, String password, String firstname, String lastname,
			Integer type) {
		super();
		this.userid = userid;
		this.accNumber = accNumber;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
	}

	public String type() {
		String userType = null;
		if (this.type.equals(0)) {
			userType = "customer";
		} else if (this.type.equals(1)) {
			userType = "employee";
		} else if (this.type.equals(2)) {
			userType = "admin";
		}
		return userType;
	}

}
