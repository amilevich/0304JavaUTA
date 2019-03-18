package com.example.model;

public class Employee {

	int emp_id;
	String firstname, lastname, type, password;
	
	
	public Employee() {
		
	}
	
	public Employee(String firstname, String lastname, String type, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.password = password;
	}
	
	public Employee(int emp_id, String firstname, String lastname, String type, String password) {
		super();
		this.emp_id = emp_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", firstname=" + firstname + ", lastname=" + lastname + ", type=" + type
				+ ", password=" + password + "]";
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
