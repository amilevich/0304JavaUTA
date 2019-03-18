package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;
import com.example.model.Employee;

public class AccountDaoImpl implements AccountDao {

	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "otheruser";
	private static final String password = "otheruser";
	
	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(new Account(rs.getInt("acc_id"), 
								rs.getInt("pet_id"), 
								rs.getDouble("balance")));		 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNT (pet_id, balance) VALUES (?, ?)");
			ps.setInt(1, a.getPet_id());
			ps.setDouble(2, a.getBalance() );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account selectAccountById(int id) {
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE acc_id = ?");
			ps.setInt(1, id);
			//ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				account = new Account(rs.getInt("acc_id"), 
								rs.getInt("pet_id"), 
								rs.getDouble("balance")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int deleteAccountById(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Account WHERE acc_id = ?");
			ps.setInt(1, a.getAcc_id());
			ps.executeUpdate();
		} catch (SQLException f) {
			f.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAccountWhereId(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET balance = ? WHERE acc_id = ?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAcc_id());	
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
