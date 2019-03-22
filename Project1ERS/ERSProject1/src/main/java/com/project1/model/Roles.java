package com.project1.model;

public class Roles {
	
	private int ersUserRoleId;
	private String userRole;
	
	public Roles() {
		
	}

	public Roles(String userRole) {
		super();
		this.userRole = userRole;
	}

	public Roles(int ersUserRoleId, String userRole) {
		super();
		this.ersUserRoleId = ersUserRoleId;
		this.userRole = userRole;
	}

	public int getErsUserRoleId() {
		return ersUserRoleId;
	}

	public void setErsUserRoleId(int ersUserRoleId) {
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
		return "Roles [ersUserRoleId=" + ersUserRoleId + ", userRole=" + userRole + "]";
	}
	
	
	
}

