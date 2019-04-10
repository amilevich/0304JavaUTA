package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Employee;
import com.github.javafaker.Faker;

@Repository
public class EmployeeDaoImpl {
	
	public List<Employee> getAllEmployeesFromDb(){
		
		//to generate the fake details for the employees
		Faker faker = new Faker();
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		for(int i = 101; i<=110; i++) {
			Employee myEmployee = new Employee();
			myEmployee.setId(i);
			myEmployee.setName(faker.name().fullName());
			myEmployee.setMobile(faker.phoneNumber().cellPhone());
			myEmployee.setAddress(faker.address().streetAddress());
			myEmployee.setCompanylogo(faker.company().logo());
			
			employeeList.add(myEmployee);
		}
		
		return employeeList;
	}

}
