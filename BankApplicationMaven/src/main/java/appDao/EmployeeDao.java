package appDao;

import java.util.ArrayList;

import appModels.Employee;

public interface EmployeeDao {
	
	
			//CREATE - INSERT
			public int insertEmployee(Employee E);
			
			//READ - SELECT
			public Employee getEmployeeByUsername(String Username);
			
			public ArrayList<Employee> EmployeeArchive();
			
			//UPDATE
			public int updateEmployee(Employee E);
			
			//DELETE
			public int deleteEmployee(Employee E);
			
			

}
