package com.bankApp.EmployeeDAO;

import com.bankApp.People.BankUser;



public interface EmployeeDAO {
	boolean approveAccount(int act);
	boolean deleteAccount(int act);
	BankUser[] recallInformation(int act);
	
}