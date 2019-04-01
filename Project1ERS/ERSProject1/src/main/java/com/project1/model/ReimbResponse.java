package com.project1.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

public class ReimbResponse {

	public int ersUsersId;
	public String ersUsername;
	public String ersPassword;
	public String userFirstname;
	public String userLastname;
	public String userEmail;
	public int userRoleId;
	public List<UserReimb> reimbList;
}
