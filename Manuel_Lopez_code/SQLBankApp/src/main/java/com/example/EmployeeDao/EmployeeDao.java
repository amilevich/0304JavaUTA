package com.example.EmployeeDao;
import java.util.List;
import com.example.Employee.Employee;
import com.example.User.User;

public interface EmployeeDao {
				
				// READ
				//public User personalInfo(String username);
				public List<Employee> selectAllUsers();
				public User personalInfo(String name);
				public User accountInfo(String name);

				
				// UPDATE
				public int updateUser(User p);
				
				public void approveUser(String p);
				
				public int approveUser(User p);
				
				// DELETE
				public int deleteUser(User p);

				int nextSequence();

}
