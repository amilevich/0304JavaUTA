package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeDaoImpl;

@Service
public class EmployeeServImpl {
	
	@Autowired
	EmployeeDaoImpl empdao;
	
	public List<Employee> getAllEmployee(){
		return empdao.getAllEmployeesFromDb();
	}

}
