package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;
import com.example.model.Pet;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "otheruser";
	private static final String password = "otheruser";
	
	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("emp_id"), 
								rs.getString("firstname"), 
								rs.getString("lastname"),
								rs.getString("type"),
								rs.getString("password")));		 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee selectEmployeeById(int id) {
		Employee employee = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE emp_id = ?");
			ps.setInt(1, id);
			//ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employee = new Employee(rs.getInt("emp_id"), 
								rs.getString("firstname"), 
								rs.getString("lastname"), 
								rs.getString("type"),
								rs.getString("password")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public int deleteEmployeeById(Employee e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Employee WHERE emp_id = ?");
			ps.setInt(1, e.getEmp_id());
			ps.executeUpdate();
		} catch (SQLException f) {
			f.printStackTrace();
		}
		return 0;
	}
	
}
