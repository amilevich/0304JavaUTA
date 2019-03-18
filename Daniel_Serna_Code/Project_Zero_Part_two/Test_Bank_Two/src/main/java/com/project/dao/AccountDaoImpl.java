package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Account;

public class AccountDaoImpl implements AccountDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cabkx1onjwc8.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "DanielJosephSerna";
	private static String password = "CherryPie0!";
	
	@Override
	public int insertAccount(Account a) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNT VALUES (?,?,?)"); 
			ps.setInt(1, a.getAccount_id()); System.out.println("Set account id");
			ps.setDouble(2, a.getBalance()); System.out.println("Set balance");
			ps.setInt(3, a.getStatus()); System.out.println("Set status");
			ps.executeUpdate();
			System.out.println("Update here");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("End of account insert");
		
		return 0;
		
	}

	@Override
	public Account selectAccountByID(int id) {
		
		Account acc = null; 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE ACCOUNT_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				acc = new Account(rs.getInt("ACCOUNT_ID"), rs.getDouble("BALANCE"), rs.getInt("STATUS"));
				// System.out.println("ACCOUNT: "+acc.getAccount_id()+" "+acc.getBalance()+" "+acc.getStatus());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return acc;
	}
	
	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<>(); 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNT"); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override 
	public List<Account> selectAllOpenAccounts()
	{
		List<Account> accounts = new ArrayList<>(); 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE STATUS=0"); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void updateAccountStatus(int id)
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE=?, STATUS=? WHERE ACCOUNT_ID="+id);
			ps.setDouble(1, 200.0 );
			ps.setInt(2, 1);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(int id) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ACCOUNT WHERE ACCOUNT_ID="+id);
			ps.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
