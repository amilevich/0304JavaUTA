package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.beans.Account;
import com.models.beans.Customer;

public class AccountDaoImpl implements AccountDao {

	private static String url = "jdbc:oracle:thin:@yosdb2.ccphgh1h1mce.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Don";
	private static String password = "password";

	public static void main(String[] args) {

	}

	@Override
	public int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES(?,?,?)");
			ps.setString(1, a.getUsername());
			ps.setDouble(2, a.getBalance());
			ps.setBoolean(3, a.isStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Account selectByUsername(String uname) {
		Account blist = new Account();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE username=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				blist = new Account(rs.getString("username"), rs.getDouble("balance"), rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return blist;
	}

	@Override
	public Account selectBystatus(Boolean status) {
		Account alist = new Account();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE username=?");
			ps.setBoolean(1, status);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				alist = new Account(rs.getString("username"), rs.getDouble("balance"), rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alist;
	}

	@Override
	public List<Account> selectAllAccount() {
		List<Account> accs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM Accounts";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				accs.add(new Account(rs.getString("username"), rs.getDouble("balance"), rs.getBoolean("status")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accs;
	}

	@Override
	public int updateAccount(Account a) {
		int res = 0;

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE Accounts SET balance=?, status=? WHERE username =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, a.getBalance());
			ps.setBoolean(2, a.isStatus());
			ps.setString(3, a.getUsername());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return res;
	}

	@Override
	public int deleteAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accounts WHERE username= ?");
			ps.setString(1, a.getUsername());
//			 ps.setDouble(2, a.getBalance());
//			 ps.setBoolean(3, a.isStatus());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return 0;
	}

}
