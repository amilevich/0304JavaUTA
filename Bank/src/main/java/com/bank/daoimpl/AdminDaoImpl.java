package com.bank.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.account.Account;
import com.bank.dao.AdminDao;
import com.bank.users.Customer;
import com.bank.utility.Util;
public class AdminDaoImpl implements AdminDao
{
	@Override
	public int getCustomerID()
	{
		int nextId =0;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ids ");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				nextId = rs.getInt("CUSTOMERID");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		//System.out.println(nextId);
		return nextId;
	}

	@Override
	public int getAccountID()
	{
		int nextId =0;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ids");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				nextId = rs.getInt("ACCOUNTID");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		//System.out.println(nextId);
		return nextId;
	}

	@Override
	public int getJointID()
	{
		int nextId =0;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ids");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				nextId = rs.getInt("JOINTID");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		//System.out.println(nextId);
		return nextId;
	}

	@Override
	public int insertAccount(Account a) 
	{
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES(?,?,?,?,?,?,?)");
			ps.setLong(1, getAccountID());
			ps.setString(2, a.getBalanceString());
			ps.setLong(3, a.getOwnerID());
			for(int i = 4; i < 8;i++)
			ps.setLong(i, a.getSecondaryOwnerID(i-4));
			ps.executeUpdate();
			System.out.println("Account added");

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return 0;
	}

	@Override
	public int insertCustomer(Customer in) 
	{
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?)");
			ps.setLong(1, getCustomerID());
			ps.setString(2, in.getUserName());	//System.out.println("un added");
			ps.setString(3, in.getPassWord());	//System.out.println("pw added");
			ps.setLong(4,getAccountID());	//System.out.println("mid added");
			ps.setLong(5, getJointID());	//System.out.println("jid added");
			ps.executeUpdate();
			ps.close();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
	
		return 0;
	}

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
				account = new Account(rs.getInt("ACCOUNTID"),rs.getDouble("balance"),rs.getInt("PRIMARYOWNERID"),1);
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
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance =?," +
															  "JOINTACCOUNTID1=?,JOINTACCOUNTID2 =?," +
															  "JOINTACCOUNTID3=?,JOINTACCOUNTID4 =? " +
															  "WHERE accountid =?");
			ps.setDouble(1, a.getBalance());
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
	public int updateCustomer(Customer in)
	{
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE Customers SET customerusername = ?,CUSTOMERPASSWORD = ? WHERE accountid =?");
			ps.setString(1, in.getUserName());
			ps.setString(2, in.getPassWord());
			ps.executeUpdate();

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		Util.refreshCustomers();
		return 0;
	}

	@Override
	public int deleteAccount(Account a) 
	{
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounts WHERE ACCOUNTID =?");
			ps.setInt(1, a.getId());
			ps.executeUpdate();

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return 0;
	}

	@Override
	public int deleteCustomer(Customer in)
	{
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE CUSTOMERID =?");
			ps.setInt(1, in.getId());
			ps.executeUpdate();

			ps = conn.prepareStatement("DELETE FROM accounts WHERE PRIMARYOWNERID =?");
			ps.setInt(1, in.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		Util.refreshCustomers();
		return 0;
	}

	@Override
	public List<Account> selectAllAccounts()
	{
		List<Account> account = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM accounts");
			ResultSet rs = ps.executeQuery();
			int counter = 0;
			while (rs.next()) 
			{
				account.add(new Account(rs.getInt("ACCOUNTID"),rs.getDouble("balance"),rs.getInt("PRIMARYOWNERID"),1));
				
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

	@Override
	public List<Customer> selectAllCustomers() 
	{
		List<Customer> customer = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM Customers");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) 
			{
				customer.add(new Customer(rs.getInt("CUSTOMERID"),rs.getString("CUSTOMERUSERNAME"),rs.getString("CUSTOMERPASSWORD"),
						rs.getInt("PRIMARYACCOUNTID"),rs.getInt("JOINTACCOUNTID")));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return customer;
	}



	@Override
	public Account selectAccount(int id) 
	{	
		Account account = null;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM accounts WHERE accountid = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				account = new Account(rs.getInt("ACCOUNTID"),rs.getDouble("balance"),rs.getInt("PRIMARYOWNERID"),1);
				
				for (int i = 4; i < 8; i++)
					account.setSecondaryOwnerID(i, rs.getInt(i));
				
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return account;
	}

	@Override
	public Customer selectCustomer(int id) 
	{
		Customer customer = null;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM accounts WHERE accountid = ?");
			ps.setInt(1,id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				customer =new Customer(rs.getInt("CUSTOMERID"),rs.getString("CUSTOMERUSERNAME"),rs.getString("CUSTOMERPASSWORD"),
						rs.getInt("PRIMARYACCOUNTID"),rs.getInt("JOINTACCOUNTID"));			
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return customer;
	}

	@Override
	public Customer selectCustomer(String username)
	{
		Customer customer = null;
		try (Connection conn = DriverManager.getConnection(Util.url, Util.username, Util.password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT*FROM customers WHERE customerusername = ?");
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				customer =new Customer(rs.getInt("CUSTOMERID"),rs.getString("CUSTOMERUSERNAME"),rs.getString("CUSTOMERPASSWORD"),
						rs.getInt("PRIMARYACCOUNTID"),rs.getInt("JOINTACCOUNTID"));
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return customer;
	}


}
