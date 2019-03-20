package com.dbbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dbbank.model.CustomerAccount;

public class CustomerAccountDaoImpl implements CustomerAccountDao {
	
	private static String url = "jdbc:oracle:thin:@sql034.cgrzwg2xzjmp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "banker";
	private static String password = "banking";

	@Override
	public int insertCustomerAccount(CustomerAccount ca) {
		// TODO Auto-generated method stub
		List<CustomerAccount> custACC = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO CustomerAccount (custID, accountID) VALUES(?,?)");
			ps.setInt(1, ca.getCustID());
			ps.setInt(2, ca.getAccId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}


	@Override
	public List<String> selectCustomerAccountByCID(Integer CustomerAccountAID) {
		// TODO Auto-generated method stub
		List<String> custACC = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account natural join CustomerAccount WHERE custID=?");
			ps.setInt(1, CustomerAccountAID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String s = "  " +  Integer.toString(rs.getInt(1)) + "\t\tUSD\t$" + Integer.toString(rs.getInt(2))+".00";
				custACC.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custACC;
	}

	@Override
	public CustomerAccount selectCustomerAccountByAID(Integer CustomerAccountCID) {
		// TODO Auto-generated method stub
		CustomerAccount account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CustomerAccount WHERE accountID=?");
			ps.setInt(1, CustomerAccountCID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				account = new CustomerAccount(rs.getInt(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<CustomerAccount> selectAllCustomerAccounts() {
		// TODO Auto-generated method stub
		List<CustomerAccount> custACC = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CustomerAccount");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) custACC.add(new CustomerAccount(rs.getInt(1), rs.getInt(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custACC;
	}

	@Override
	public int updateCustomerAccount(CustomerAccount ca) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE CustomerAccount SET custID=?, accountID=? WHERE accNumber=?");
			ps.setDouble(1, ca.getCustID());
			ps.setDouble(2, ca.getAccId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomerAccount(CustomerAccount ca) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM deleteCustomerAccount WHERE accountID=?");
			// problem with setString
			ps.setInt(1, ca.getCustID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
