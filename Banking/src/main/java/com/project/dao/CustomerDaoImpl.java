package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private static String url = "jdbc:oracle:thin:@yosdb2.ccphgh1h1mce.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Don";
	private static String password = "password";

	public static void main(String[] args) {

	}

	@Override
	public int insertCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer VALUES(?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer selectByUsername(String uname) {
		Customer cnames = new Customer();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE username=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cnames = new Customer(rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnames;
	}

	@Override
	public List<Customer> selectAllCustomer() {
		List<Customer> custos = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM Customer";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				custos.add(new Customer(rs.getString(1), rs.getString(2)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return custos;
	}

	@Override
	public int updateCustomer(Customer c) {
		int res = 0;

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE Customer SET username= ?, password=? WHERE username =" + c.getUsername();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return res;

	}

	@Override
	public int deleteCustomer(Customer c) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE username= ?");
			ps.setString(1, c.getUsername());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public Customer selectByPassword(String pword) {
		Customer pwords = new Customer();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE password=?");
			ps.setString(1, pword);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pwords = new Customer(rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwords;

	}
}
