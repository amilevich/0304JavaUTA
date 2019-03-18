package com.bank.model;

public class app {
	
	String UserID, Password, FirstName, LastName, Role, AccNum, Status, Datetime;
	String PENDING, APPROVED, CANCELLED, CLOSED;
	int BALANCE, WBALANCE, DBALANCE, TBALANCE; 
	String WTranID, DTrainID, TTranID;
	
	public String getPENDING() {
		return PENDING;
	}
	public void setPENDING(String pENDING) {
		PENDING = pENDING;
	}
	public String getAPPROVED() {
		return APPROVED;
	}
	public void setAPPROVED(String aPPROVED) {
		APPROVED = aPPROVED;
	}
	public String getCANCELLED() {
		return CANCELLED;
	}
	public void setCANCELLED(String cANCELLED) {
		CANCELLED = cANCELLED;
	}
	public String getCLOSED() {
		return CLOSED;
	}
	public void setCLOSED(String cLOSED) {
		CLOSED = cLOSED;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getAccNum() {
		return AccNum;
	}
	public void setAccNum(String accNum) {
		AccNum = accNum;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDatetime() {
		return Datetime;
	}
	public void setDatetime(String datetime) {
		Datetime = datetime;
	}
	public int getBALANCE() {
		return BALANCE;
	}
	public void setBALANCE(int bALANCE) {
		BALANCE = bALANCE;
	}
	public int getWBALANCE() {
		return WBALANCE;
	}
	public void setWBALANCE(int wBALANCE) {
		WBALANCE = wBALANCE;
	}
	public int getDBALANCE() {
		return DBALANCE;
	}
	public void setDBALANCE(int dBALANCE) {
		DBALANCE = dBALANCE;
	}
	public int getTBALANCE() {
		return TBALANCE;
	}
	public void setTBALANCE(int tBALANCE) {
		TBALANCE = tBALANCE;
	}
	public String getWTranID() {
		return WTranID;
	}
	public void setWTranID(String wTranID) {
		WTranID = wTranID;
	}
	public String getDTrainID() {
		return DTrainID;
	}
	public void setDTrainID(String dTrainID) {
		DTrainID = dTrainID;
	}
	public String getTTranID() {
		return TTranID;
	}
	public void setTTranID(String tTranID) {
		TTranID = tTranID;
	}
	
	
	
	@Override
	public String toString() {
		return "UserID=" + UserID + ", Password=" + Password + ", Role=" + Role;
	}
	
	public String pendingAccounts()
	{
		return "UserID=" + UserID + ", PENDING=" + PENDING + ", APPROVED=" + APPROVED + ", CANCELLED=" + CANCELLED + ", CLOSED=" + CLOSED;
	}
	
	public String CustomerView() {
		return "AccNum=" + AccNum + ", BALANCE=" + BALANCE + ", UserID=" + UserID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Role=" + Role ;
	}
	
	public String FindAccNum() {
		return "AccNum=" + AccNum;
	}
	
	public String CustomerJointToString() {
		return "ACCNUM=" + AccNum ;
	}
	
	
	public String CustomerBalanceToString() {
		return "AccNum=" + AccNum + ", BALANCE=" + BALANCE ;
	}
	 
	public int Deposite() {
		return BALANCE ;
	}

	
	
	public app() {
		super();
	}
	public app(String userID) {
		super();
		UserID = userID;
	}
	public app(String userID, String password) {
		super();
		UserID = userID;
		Password = password;
	}
	public app(String userID, String password, String role) {
		super();
		UserID = userID;
		Password = password;
		Role = role;
	}

//	public app(String userID, String firstName, String lastName, String role, String accNum, double bALANCE) {
	public app(String userID, String firstName, String lastName, String role) {
		super();
		UserID = userID;
		FirstName = firstName;
		LastName = lastName;
		Role = role;
		//AccNum = accNum;
		//BALANCE = bALANCE;
	}
	
	
	
	

}
