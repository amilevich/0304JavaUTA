package com.Project0.DoaImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Project0.Bank.Account;
import com.Project0.Bank.Admin;
import com.Project0.Bank.Employee;
import com.Project0.Bank.User;
import com.Project0.Dao.BankDao;

public class BankDaoImpl implements BankDao {

	private static String url = "jdbc:oracle:thin:@bankdb.ctjqi18j2emr.us-east-2.rds.amazonaws.com:1521:bankdb";
	private static String username = "Banky";
	private static String password = "DankBank";

	@Override
	public int createTables() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// Statement s = conn.createStatement();
			// s.executeUpdate("DROP TABLE Users");
			// s.executeUpdate("DROP TABLE Accounts");
			PreparedStatement ps = conn.prepareStatement("CREATE TABLE Users( username VARCHAR2(20) PRIMARY KEY, "
					+ "password VARCHAR2(20), name VARCHAR2(20), userType NUMBER(2))");
			ps.executeUpdate();
			ps = conn.prepareStatement(
					"CREATE TABLE Accounts( accountId NUMBER(5) PRIMARY KEY, " + "balance FLOAT(10))");
			ps.executeUpdate();
			ps = conn.prepareStatement(
					"CREATE TABLE Applications( accountId NUMBER(5) PRIMARY KEY, " + "balance FLOAT(10))");
			ps.executeUpdate();
			ps = conn.prepareStatement(
					"CREATE TABLE Junction( accountId NUMBER(5) NOT NULL, " + "username VARCHAR2(20) NOT NULL,"
							+ "CONSTRAINT pk_acId_usrNm PRIMARY KEY (accountId, username))");
			ps.executeUpdate();

		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("finally")
	@Override
	public int returnMaxAccId() {
		int res = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement s = conn.createStatement();
			ResultSet resSet = s.executeQuery("SELECT MAX(accountId) FROM Accounts");
			if (resSet.next()) {
				res = resSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return res;
		}
	}

	@Override
	public ArrayList<Account> getAccountList() {
		ArrayList<Account> accs = new ArrayList<Account>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts");
			ResultSet rs = ps.executeQuery();
			ResultSet rs2;
			while (rs.next()) {
				Account acc = new Account(rs.getInt(1), rs.getDouble(2), null);
				ps = conn.prepareStatement("SELECT username FROM Junction WHERE accountId=" + rs.getInt(1));
				rs2 = ps.executeQuery();
				acc.getAccountUsers().clear();
				while (rs2.next()) {
					
					acc.getAccountUsers().add(rs2.getString(1));
				}
				accs.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accs;
	}

	@Override
	public ArrayList<User> getUserList() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				switch (rs.getInt(4)) {
				case 1:
					users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
					break;
				case 2:
					users.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3)));
					break;
				case 3:
					users.add(new Admin(rs.getString(1), rs.getString(2), rs.getString(3)));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
