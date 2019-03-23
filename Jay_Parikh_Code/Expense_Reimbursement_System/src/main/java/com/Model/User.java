package com.Model;

public class User {

	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private int status = 0;
	
	
	//------------------------Constructors---------------------------------------
	public User() {
		
	}

	public User(String userName, String passWord, String firstName, String lastName, String email, int status) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
	}

	
	//ToString
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", status=" + status + "]";
	}

	
	//--------------------Getters and Setters--------------------------------------
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
