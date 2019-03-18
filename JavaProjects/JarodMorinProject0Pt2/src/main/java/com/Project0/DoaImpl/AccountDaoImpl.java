package com.Project0.DoaImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Project0.Bank.Account;
import com.Project0.Dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

	private static String url = "jdbc:oracle:thin:@bankdb.ctjqi18j2emr.us-east-2.rds.amazonaws.com:1521:bankdb";
	private static String username = "Banky";
	private static String password = "DankBank";

	@Override
	public int updateBalance(Account acc) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET balance="+ acc.getBalance() +
					"WHERE accountId=" + acc.getAccountNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int addAccount(Account acc, String userName) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES("+ acc.getAccountNumber() +
					"," + acc.getBalance() + ")");
			ps.executeUpdate();
			addUserToAccount(acc, userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int addUserToAccount(Account acc, String userName) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Junction VALUES("+ acc.getAccountNumber() +
					",'" + userName + "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int removeAccount(Account acc) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accounts WHERE accountId ="+ acc.getAccountNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


}
