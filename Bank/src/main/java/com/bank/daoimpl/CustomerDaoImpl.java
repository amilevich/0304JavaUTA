package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.account.Account;
import com.bank.dao.CustomerDao;
import com.bank.users.Customer;
import com.bank.utility.Util;

public class CustomerDaoImpl implements CustomerDao
{

	

	@Override
	public List<Account> selectAccountByUserID(int id) 
	{
		List<Account> accounts = new ArrayList<>();
		Account account;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM accounts WHERE PRIMARY_OWNERID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) 
			{
				account = new Account(rs.getInt("ACCOUNTID"),rs.getDouble("balance"),rs.getInt("PRIMARYOWNERID"));
				for (int i = 4; i < 8; i++)
					account.setSecondaryOwnerID(i, rs.getInt(i));
				accounts.add(account);
			}
			ps.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return accounts;
	}

	@Override
	public int updateAccount(Account a) 
	{
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance =?,JOINTACCOUNTID1=?,JOINTACCOUNTID2 =?,JOINTACCOUNTID3=?,JOINTACCOUNTID4 =? WHERE accountid =?");
			ps.setString(1, a.getBalanceString());
			ps.setInt(2, a.getSecondaryOwnerID(0));
			ps.setInt(3, a.getSecondaryOwnerID(1));
			ps.setInt(4, a.getSecondaryOwnerID(2));
			ps.setInt(5, a.getSecondaryOwnerID(3));
			ps.setInt(6, a.getId());
			ps.executeUpdate();

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return 0;
	}

	@Override
	public List<Account> selectAllAccounts(Customer in) 
	{
		List<Account> account = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM accounts WHERE primaryownerid = ? "
					+ "									 or JOINTACCOUNTID1 =? or JOINTACCOUNTID2 = ? "
					+ "									 or JOINTACCOUNTID3 = ? or JOINTACCOUNTID4 = ? ");
			ps.setInt(1, in.getId());
			ps.setInt(2, in.getJointID());
			ps.setInt(3, in.getJointID());
			ps.setInt(4, in.getJointID());
			ps.setInt(5, in.getJointID());
			ResultSet rs = ps.executeQuery();
			int counter = 0;
			while (rs.next()) 
			{
				account.add(new Account(rs.getInt("ACCOUNTID"),rs.getDouble("balance"),rs.getInt("PRIMARYOWNERID")));
				
				for (int i = 4; i < 8; i++)
					account.get(counter).setSecondaryOwnerID(i, rs.getInt(i));
				counter++;
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return account;
	}
	

	
}
