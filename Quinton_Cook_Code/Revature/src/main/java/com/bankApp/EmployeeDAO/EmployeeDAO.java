package com.bankApp.EmployeeDAO;

import java.util.ArrayList;

import com.bankApp.People.BankUser;
import com.bankApp.People.Employee;



public interface EmployeeDAO {
	boolean approveAccount(int act);
	boolean deleteAccount(int act);
	ArrayList<BankUser> recallInformation(int act);
	Employee login(String usrName, String password);
	
}