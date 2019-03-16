package com.bankApp.EmployeeDAO;

import java.util.ArrayList;

import com.bankApp.People.BankUser;



public interface EmployeeDAO {
	boolean approveAccount(int act);
	boolean deleteAccount(int act);
	ArrayList<BankUser> recallInformation(int act);
	
}