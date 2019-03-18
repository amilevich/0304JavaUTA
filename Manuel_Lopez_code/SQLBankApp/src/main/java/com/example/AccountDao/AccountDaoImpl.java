package com.example.AccountDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.Account.Account;
import com.example.User.User;

public class AccountDaoImpl implements AccountDao{
	
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "meme7";
	private static String password = "Arkange1";

	@Override
	public int withdraw(int acctNum, double w) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNTS SET balance=? WHERE acct_num=?");
			ps.setDouble(1, w);
			ps.setInt(2, acctNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deposit(int acctNum, double d) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNTS SET balance=? WHERE acct_num=?");
			ps.setDouble(1, d);
			ps.setInt(2, acctNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int transfer(Account p, int t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAccount(Account p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)");
			ps.setInt(1, p.getAcctNum());
			ps.setDouble(2, p.getBalance());
			ps.setInt(3, p.getAcctType());
			ps.setString(4, p.getUserName1());
			ps.setString(5, p.getUserName2());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account getAccount(int acctNum) {
		Account pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE acct_num=?");
			ps.setInt(1, acctNum);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new Account(rs.getInt("acct_num"), rs.getInt("acct_type"), rs.getDouble("balance"), rs.getString("username1"), rs.getString("username2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}

}
