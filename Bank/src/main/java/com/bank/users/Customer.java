package com.bank.users;

public class Customer 
{
	private String userName;
	private String passWord;
	private int id;
	private int mainAccountID;
	private int jointID;
	public Customer() {}
	public Customer(int id,String userName, String passWord, int mainAccountID, int jointID)
	{
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.id = id;
		this.mainAccountID = mainAccountID;
		this.jointID = jointID;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassWord() 
	{
		return passWord;
	}
	public void setPassWord(String passWord) 
	{
		this.passWord = passWord;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getMainAccountID()
	{
		return mainAccountID;
	}
	public void setMainAccountID(int mainAccountID) 
	{
		this.mainAccountID = mainAccountID;
	}
	public int getJointID()
	{
		return jointID;
	}
	public void setJointID(int jointID) 
	{
		this.jointID = jointID;
	}
	
	@Override
	public String toString() 
	{
		return "Customer [userName=" + userName + ", passWord=" + passWord + ", id=" + id + ", mainAccountID="
				+ mainAccountID + ", jointID=" + jointID + "]";
	}
	
	
}
