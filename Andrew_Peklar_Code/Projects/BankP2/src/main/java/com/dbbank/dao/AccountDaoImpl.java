package com.dbbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbbank.model.Account;

public class AccountDaoImpl implements AccountDao {

	private static String url = "jdbc:oracle:thin:@sql034.cgrzwg2xzjmp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "banker";
	private static String password = "banking";

	@Override
	public int insertAccount(Account a) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Account (accountID, accountBalance) VALUES(?,?)");
			ps.setInt(1, a.getAccountID());
			ps.setDouble(2, a.getAccountBalance());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Account selectAccountByID(Integer accountID) {
		// Rework for adding custAcc table
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE accountID=?");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				account = new Account(rs.getInt(1), rs.getDouble(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET accountBalance=?, status=? WHERE accNumber=?");
			ps.setDouble(1, a.getAccountID());
			ps.setDouble(2, a.getAccountBalance());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Account WHERE accountID=?");
			// problem with setString
			ps.setInt(1, a.getAccountID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
