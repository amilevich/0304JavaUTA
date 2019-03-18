package com.example.dao;

import java.util.List;


import com.example.model.Employee;


public interface EmployeeDao {

	public List<Employee> selectAllEmployees();
	
	public Employee selectEmployeeById(int id);
	
	public int deleteEmployeeById(Employee e);
}
