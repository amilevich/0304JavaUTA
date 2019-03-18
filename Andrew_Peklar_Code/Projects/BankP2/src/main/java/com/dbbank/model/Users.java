package com.dbbank.model;

import java.util.Arrays;
import java.util.List;

public class Users {
	
	public static List<? extends Object> Used;
	Integer userID 	= null;
	String	userName, 
			userPass;
	Integer	accountType;
	
	public Users() {}

	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public Integer getAccountType() {
		return accountType;
	}


	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}


	
//	@Override
//	public String toString() {
//		return "Users [userID=" + userID + ", userName=" + userName + ", userPass=" + userPass + ", userFName="
//				+ userFName + ", userLName=" + userLName + ", accountType=" + accountType + "]";
//	}

	public List<Users> accountInstance() {
		return (List<Users>) (Used = Arrays.asList(userID, userName, userPass, accountType));
		
	}
	
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userName=" + userName + ", userPass=" + userPass + ", accountType="
				+ accountType + "]";
	}

	public Users(Integer userID, String userName, String userPass, Integer accountType) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPass = userPass;
		this.accountType = accountType;
	}
}
