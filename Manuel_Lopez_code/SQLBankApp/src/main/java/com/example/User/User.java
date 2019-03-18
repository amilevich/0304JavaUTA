package com.example.User;
import java.security.SecureRandom;

public class User {
	
	int userid;
	String userName, password, firstName, lastName;
	int userKey, userAcctStatus, ssn, acctNum;

	public int genRandInt5() {
		//used for userId
		SecureRandom random = new SecureRandom();
		int x = random.nextInt(100000);
		return x;
		
	}
	
	public int genRandInt7() {
		//used for acctNum
		SecureRandom random = new SecureRandom();
		int x = random.nextInt(10000000);
		return x;
	}
	
	public int genRandInt9() {
		//used for ssn
		SecureRandom random = new SecureRandom();
		int x = random.nextInt(1000000000);
		return x;
	}
	
	public User() {
		
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password, int userAcctStatus) {
		this.userName = userName;
		this.password = password;
		this.userAcctStatus = userAcctStatus;
	}
	
	public User(String userName, String password, int userAcctStatus, int userKey) {
		this.userName = userName;
		this.password = password;
		this.userAcctStatus = userAcctStatus;
		this.userKey = userKey;
	}

	public User(int userid, String userName, String password, String firstName, String lastName, int userKey,
			int userAcctStatus, int ssn, int acctNum) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userKey = userKey;
		this.userAcctStatus = userAcctStatus;
		this.ssn = ssn;
		this.acctNum = acctNum;
	}
	
	public User(String userName, String password, String firstName, String lastName, int userKey,
			int userAcctStatus, int ssn, int acctNum) {
		super();
		//this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userKey = userKey;
		this.userAcctStatus = userAcctStatus;
		this.ssn = ssn;
		this.acctNum = acctNum;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public void setUserid() {
		int y = genRandInt5();
		this.userid = y;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getUserKey() {
		return userKey;
	}

	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}
	
	public void setUserkey() {
		this.userKey = 0;
	}

	public int getUserAcctStatus() {
		return userAcctStatus;
	}

	public void setUserAcctStatus(int userAcctStatus) {
		this.userAcctStatus = userAcctStatus;
	}
	
	public void setUserAcctStatus() {
		this.userAcctStatus = 0;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public void setSsn() {
		int y = genRandInt9();
		this.ssn = y;
	}
	
	public int getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	
	public void setAcctNum() {
		int x = genRandInt7();
		this.acctNum = x;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userKey=" + userKey + ", userAcctStatus=" + userAcctStatus
				+ ", ssn=" + ssn + "]";
	}
	
	
	
	
}
