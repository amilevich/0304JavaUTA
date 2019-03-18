package com.bank.daoAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;

public class DaoAccountImpl implements DaoAccount {

	private static String url = "jdbc:oracle:thin:@revaturedb.clyh6jvswypw.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "thebankman";
	private static String password = "bank";

	public Account getAccount(int accountId) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE AccountId = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt(1));
				account.setAccountName(rs.getString(2));
				account.setBalance(rs.getDouble(3));
				account.setIsActive(rs.getInt(4));
				account.setIsApproved(rs.getInt(5));
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private int nextAccountSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT account_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	public int insertAccount(Account account) {
		int accountid = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES (?, ?, ?, ?, ?)");
			accountid = nextAccountSequence();
			ps.setInt(1, accountid);
			ps.setString(2, account.getAccountName());
			ps.setDouble(3, account.getBalance());
			ps.setInt(4, account.getIsActive());
			ps.setInt(5, account.getIsApproved());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountid;
	}

	public Account getAccountByName(int u, String an) {
		// TODO Auto-generated method stub
		return null;
	}

	// public Account getAccountByName(int userId, String accountName) {
	// Account account = null;
	// try (Connection conn = DriverManager.getConnection(url, username, password))
	// {
	// PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE
	// AccountId = ?");
	// ps.setInt(1, accountId);
	// ResultSet rs = ps.executeQuery();
	//
	// while (rs.next()) {
	// account = new Account(rs.getInt("accountId"), rs.getString("accountname"),
	// rs.getDouble("balance"),
	// rs.getInt("isActive"), rs.getInt("isApproved"));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return account;
	// }

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account tmpAcct = new Account();
				tmpAcct.setAccountId(rs.getInt(1));
				tmpAcct.setAccountName(rs.getString(2));
				tmpAcct.setBalance(rs.getDouble(3));
				tmpAcct.setIsActive(rs.getInt(4));
				tmpAcct.setIsApproved(rs.getInt(5));
				accounts.add(tmpAcct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account account) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE Accounts SET AccountName = ?, Balance = ?, isActive = ?, isApproved = ? WHERE AccountId = ?");
			ps.setString(1, account.getAccountName());
			ps.setDouble(2, account.getBalance());
			ps.setInt(3, account.getIsActive());
			ps.setInt(4, account.getIsApproved());
			ps.setInt(5, account.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account.getAccountId();
	}
}
