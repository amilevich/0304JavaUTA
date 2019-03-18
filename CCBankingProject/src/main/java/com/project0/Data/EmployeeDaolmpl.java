package com.project0.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project0.Build.Employee;

public class EmployeeDaolmpl implements EmployeeDoa {
	
	private static String url = "jdbc:oracle:thin:@oracledb.cknk4xe34org.us-east-2.rds.amazonaws.com:1521:SQL0304";
	private static String username = "CBankC";
	private static String password = "BankingSQL";

	@Override
	public Employee findEmployee(String Uname, String pass) {
		Employee Zeta = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE EmployeeID = ? AND Password = ?");
			ps.setString(1, Uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Zeta = new Employee(rs.getString("EmployeeID"),rs.getString("Password"),rs.getString("Name"), rs.getString("Rank"));
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Zeta;

	}

}
