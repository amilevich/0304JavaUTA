package com.bank.model;

public class User {

	private int userId;
	private String username;
	private String password;
	private String type;

	public User() {

	}

	public User(int userId, String username, String password, String type) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public User(String username, String password, String type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// properties
	// getters and setters
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

	// methods

}
