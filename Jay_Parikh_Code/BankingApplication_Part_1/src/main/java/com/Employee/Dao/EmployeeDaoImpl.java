package com.Employee.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	
	private static String url = "jdbc:oracle:thin:@oracle-instance1.cclfw9z8ofht.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Frank";
	private static String password = "hello";
	
	
	@Override
	public int insertAccount(Employee emp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO employee (username, password, type) VALUES (?,?,?)");
			ps.setString(1, emp.getUserName());
			ps.setString(2, emp.getPassWord());
			ps.setInt(3, emp.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Employee selectAccountByName(String userName) {
		Employee emp = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE username = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emp = new Employee(rs.getString("username"), rs.getString("password"), rs.getInt("type"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Employee> selectAllAccounts() {
		List<Employee> emp = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emp.add(new Employee(rs.getString("username"), rs.getString("password"), rs.getInt("type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

/*	@Override
	public int updateAccount(Employee e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE employee SET firstname=? , lastname=? , personalinfo=? , accountid=? WHERE username=?");
			ps.setString(5, c.getUserName());
			//ps.setString(5, c.getPassWord());
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getPersonalInfo());
			//ps.setInt(4, c.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	}*/

	/*@Override
	public int deleteAccount(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public int nextSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT emp_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*@Override
	public Employee selectEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
