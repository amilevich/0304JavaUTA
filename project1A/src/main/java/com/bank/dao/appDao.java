package com.bank.dao;

import java.util.List;

import com.bank.model.app;

public interface appDao {
	
	public int Register(app ap) ;
	
	public app FindAccNum(String userID, String password);
	
	
	public List<app> ViewAccount();
	public List<app> adminTask();
	
	public int UpdateAcc(app ap);
	
	public int DeleteAcc(app ap);
	
	public boolean HomeScreen();
	
	//public int approveAccount(app userID);
	
	
	
	

}
