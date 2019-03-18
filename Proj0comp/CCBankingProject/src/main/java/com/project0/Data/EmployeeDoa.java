package com.project0.Data;

import com.project0.Build.Employee;

public interface EmployeeDoa {
		
		//Select from database by Username and Password
		public Employee findEmployee(String Uname, String pass);
}
