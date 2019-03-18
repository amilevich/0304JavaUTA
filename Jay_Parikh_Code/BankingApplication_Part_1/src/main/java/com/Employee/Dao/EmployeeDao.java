package com.Employee.Dao;

import java.util.List;

import com.Model.Employee;

public interface EmployeeDao {
	
	//CRUD methods
	//CREATE
	public int insertAccount(Employee e);
	
	//READ
	public Employee selectAccountByName(String name);
	public List<Employee> selectAllAccounts();
	
	// UPDATE
	//public int updateAccount(Employee e);
	
	// DELETE
	//public int deleteAccount(Employee e);

	int nextSequence();

	//Employee selectEmployeeById(int id);
}
