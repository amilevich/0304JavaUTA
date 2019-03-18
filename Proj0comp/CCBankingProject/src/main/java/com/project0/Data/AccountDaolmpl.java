package com.project0.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0.Build.Account;

public class AccountDaolmpl implements AccountDao {
	
	private static String url = "jdbc:oracle:thin:@oracledb.cknk4xe34org.us-east-2.rds.amazonaws.com:1521:SQL0304";
	private static String username = "CBankC";
	private static String password = "BankingSQL";
	
	@Override
	public int insertAccount(Account Alpha) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Account VALUES(?,?,?,?,?,?,0)");
			ps.setString(1, Alpha.getUserName());
			ps.setString(2, Alpha.getPassword());
			ps.setString(3, Alpha.getName());
			ps.setInt(4, Alpha.getAccountID());
			ps.setString(5, String.valueOf(Alpha.getStatus()));
			ps.setDouble(6, Alpha.getFunds());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	/*
	@Override
	public List<Account> selectAllAccounts() {
		List<Account> Alpha = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Alpha.add(new Account(rs.getString("userName"),rs.getString("password"),rs.getString("Name"), rs.getInt("AccountID"), rs.getString("Status"), rs.getDouble("Funds")));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Alpha;
	}
	*/
	@Override
	public void displayAccounts() {
		Account Alpha = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Alpha = new Account(rs.getString("userName"),rs.getString("password"),rs.getString("Name"), rs.getInt("AccountID"), rs.getString("Status"), rs.getDouble("Funds"));
				System.out.println(Alpha);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Account selectAccount(String name,String pass) {
		Account Zeta = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE Username=? AND Password =?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			Zeta = new Account(rs.getString("userName"),rs.getString("password"),rs.getString("Name"), rs.getInt("AccountID"), rs.getString("Status"), rs.getDouble("Funds"));
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Zeta;
	}

	@Override
	public int deleteAccount(int Beta) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Account WHERE AccountID=?");
			ps.setInt(1, Beta);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	@Override
	public int updateAccount(Account Gamma) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET Funds=? WHERE AccountID=?");
			ps.setDouble(1, Gamma.getFunds());
			ps.setInt(2, Gamma.getAccountID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account FindByID(int T_ID) {
		Account Zeta = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE AccountID=?");
			ps.setInt(1, T_ID);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			Zeta = new Account(rs.getString("userName"),rs.getString("password"),rs.getString("Name"), rs.getInt("AccountID"), rs.getString("Status"), rs.getDouble("Funds"));
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Zeta;
	}

	@Override
	public Account FindByUser(String Uname) {
		Account Zeta = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE Username=?");
			ps.setString(1, Uname);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			Zeta = new Account(rs.getString("userName"),rs.getString("password"),rs.getString("Name"), rs.getInt("AccountID"), rs.getString("Status"), rs.getDouble("Funds"));
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Zeta;
	}

	@Override
	public List<Account> FindPending() {
		List<Account> Alpha = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE Status =?");
			ps.setString(1,"W");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Alpha.add(new Account(rs.getString("userName"),rs.getString("password"),rs.getString("Name"), rs.getInt("AccountID"), rs.getString("Status"), rs.getDouble("Funds")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Alpha;
	}

	@Override
	public void updateStatus(Account Gamma) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET Status=? WHERE AccountID=?");
			ps.setString(1, String.valueOf(Gamma.getStatus()));
			ps.setInt(2, Gamma.getAccountID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
