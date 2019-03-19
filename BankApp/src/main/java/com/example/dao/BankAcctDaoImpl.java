package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.BankAcct;



public class BankAcctDaoImpl implements BankAcctDao {
	
	private static String url = "jdbc:oracle:thin:@sql0304.crsxfsopgb48.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "GenWood";
	private static String password = "GenW2921";
	
	
	@Override
	public int insertBankAcct(BankAcct ba) {
		//int id =0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO BankAcct (accountStatus, balance) VALUES (?,?)");
			//ps.setInt(1, id);
			ps.setInt(1, ba.getAccountStatus());
			ps.setDouble(2, ba.getBalance());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	



	@Override
	public double deposit(BankAcct ba) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE bankAcct SET balance=? WHERE accountNumber=?");
			ps.setDouble(1, ba.getBalance());
			ps.setInt(2, ba.getAccountNumber());
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();}
		return 0;
	}


	@Override
	public double withdraw(BankAcct ba) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE bankAcct SET balance=? WHERE accountNumber=?");
			ps.setDouble(1, ba.getBalance());
			ps.setInt(2, ba.getAccountNumber());
			ps.executeQuery();
	
		}catch (SQLException e) {
			e.printStackTrace();}
		return 0;
	}

	
	@Override
	public int approveAccount(int accountNumber, BankAcct ba) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE bankAcct SET accountStatus=1 WHERE accountNumber=?");
			ps.setInt(1, ba.getAccountNumber());
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();}
		
		return 0;
	}


	@Override
	public int deleteAccount(BankAcct ba) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM BankAcct WHERE accountNumber=?");
			ps.setInt(1, ba.getAccountNumber());
			ps.executeUpdate();
			//ps.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();}
		return 0;
	}


	@Override
	public List<BankAcct> selectAllBankAccts() {
		List<BankAcct> bankAcct = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankAcct");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			bankAcct.add(new BankAcct(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
			return bankAcct;
	}


	@Override
	public BankAcct selectUserByAccountNum(int accountNumber) {
		BankAcct bankAcct = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankAcct WHERE accountNumber = ?");
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();	
			
			while(rs.next()) {
				bankAcct = new BankAcct( rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return bankAcct;
	}



	@Override
	public void  updateBankAcct(BankAcct ba) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE BankAcct SET accountStatus=?, balance=? WHERE accountNumber=?");
			//ps.setInt(1, ba.getAccountNumber());
			ps.setInt(1, ba.getAccountStatus());
			ps.setDouble(2, ba.getBalance());
			ps.setInt(3, ba.getAccountNumber());
			System.out.println("in update bank account method");

			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();}
		
	}

	@Override
	public int selectAccNumByMax() {
		Integer accNum = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(accountNumber) FROM bankAcct");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accNum;
	}


}


	
	



