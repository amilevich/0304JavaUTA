package com.project1.model;

public class Users {

	private int ersUsersId;
	private String ersUsername;
	private String ersPassword;
	private String userFirstname;
	private String userLastname;
	private String userEmail;
	private int userRoleId;

	public Users() {

	}

	public Users(String ersUsername, String ersPassword, String userFirstname, String userLastname, String userEmail,
			int userRoleId) {
		super();
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public Users(int ersUsersId, String ersUsername, String ersPassword, String userFirstname, String userLastname,
			String userEmail, int userRoleId) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public int getErsUsersId() {
		return ersUsersId;
	}

	public void setErsUsersId(int ersUsersId) {
		this.ersUsersId = ersUsersId;
	}

	public String getErsUsername() {
		return ersUsername;
	}

	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "Users [ersUsersId=" + ersUsersId + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", userFirstname=" + userFirstname + ", userLastname=" + userLastname + ", userEmail=" + userEmail
				+ ", userRoleId=" + userRoleId + "]";
	}

}
