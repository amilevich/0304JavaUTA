package BankingApp;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -390000049745555951L;

	private String username;
	private String password;

	public User() {

	}

	public User(String newUsername, String newPassword) {
		this.username = newUsername;
		this.password = newPassword;
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
