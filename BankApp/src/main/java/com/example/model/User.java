package com.example.model;



public class User {

	
	private String fName;
	private String lName;
	protected String userName;
	private String password;
	private int type;
	private Integer AccNumUser;
//	
//	ArrayList<BankAcct> account = new ArrayList<BankAcct>();
//	protected static HashMap<String, User> loginStuff = new HashMap<String, User>();
	
public User() {
	// TODO Auto-generated constructor stub
}
 
	
	@Override
public String toString() {
	return "User [fName=" + fName + ", lName=" + lName + ", userName=" + userName + ", password=" + password + ", type="
			+ type + ", AccNumUser=" + AccNumUser + "]";
}


	public User(String fName, String lName, String userName, String password, int type, int accNumUser) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.userName = userName;
	this.password = password;
	this.type = type;
	this.AccNumUser = null;
}


	public String getfName() {
	return fName;
}


public void setfName(String fName) {
	this.fName = fName;
}


public String getlName() {
	return lName;
}


public void setlName(String lName) {
	this.lName = lName;
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


public int getType() {
	return type;
}


public void setType(int type) {
	this.type = type;
}


public Integer getAccNumUser() {
	return AccNumUser;
}


public void setAccNumUser(int accNumUser) {
	AccNumUser = accNumUser;
}

//
//	public static User logIn(String userName, String password) {
//		if(loginStuff.containsKey(userName)) 
//			if(loginStuff.get(userName).getPassword().equals(password)) {
//				return loginStuff.get(userName);
//			}
//		return null;
//	}
//
//	public static boolean userNameNotUnique(String un) {
//		return loginStuff.containsKey(un);
//	}
//
//	public static boolean setUpAccount(BankAcct account) {
//		if(User.reviewAccount(account) && !(loginStuff).containsKey(account.getUserName())) {
//			loginStuff.put(account.getUserName(), account);
//		return true;
//		}else {
//			return false;} 
//			} 
//	
//
//	public static boolean reviewAccount(BankAcct account) {
//	
//		return true;
//	}
//
//	public static double viewBalance(BankAcct account) {
//		return account.getBalance();
//	}
//
//	
//
//	public static boolean  cancelAccount(BankAcct account) {
//		if(loginStuff.containsKey(account.getUserName())) {
//			loginStuff.remove(account.getUserName());
//			return true;
//		}else {
//			return false; 
//		}
//	}
//	
//	
//	
}
