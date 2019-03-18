package com.Account.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Account;

public class AccountDaoImpl implements AccountDao{

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cclfw9z8ofht.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Frank";
	private static String password = "hello";
	
	
	@Override
	public int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts (balance, status) VALUES (?,0)");
			ps.setDouble(1, a.getBalance());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//id
	@Override
	public Account selectAccountById(int id) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE accountnumber=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				account = new Account(rs.getInt("accountnumber"), rs.getInt("balance"), rs.getInt("status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				accounts.add(new Account(rs.getInt("accountnumber"), rs.getInt("balance"), rs.getInt("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance=?, status=? WHERE accountnumber=?");
			ps.setDouble(1, a.getBalance());
			ps.setDouble(2, a.getStatus());
			ps.setInt(3, a.getAccountid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Integer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounts WHERE accountnumber=?");
			ps.setInt(1, a);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int nextSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT acc_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/*//dont think i need this
	@Override
	public Account selectAccountByName(String name) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE =?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				account = new Account(rs.getInt("balance"), rs.getInt("status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}*/
	

}
