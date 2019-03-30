package com.projectone.models;

public class UserRoles {

	private Integer ersUserRoleId;
	private String userRole;
	
	public UserRoles() {
	}
	
	

	public UserRoles(String userRole) {
		super();
		this.userRole = userRole;
	}



	public Integer getErsUserRoleId() {
		return ersUserRoleId;
	}

	public void setErsUserRoleId(Integer ersUserRoleId) {
		this.ersUserRoleId = ersUserRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRoles [ersUserRoleId=" + ersUserRoleId + ", userRole=" + userRole + "]";
	}

	public UserRoles(Integer ersUserRoleId, String userRole) {
		super();
		this.ersUserRoleId = ersUserRoleId;
		this.userRole = userRole;
	}
}
