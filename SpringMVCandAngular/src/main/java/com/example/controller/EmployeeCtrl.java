package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeServImpl;

@RestController
public class EmployeeCtrl {
	
	@Autowired
	EmployeeServImpl empService;
	
	//@CrossOrigin is used to handle the request from a different origin
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/getemployees", method=RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployee();
	}

}
