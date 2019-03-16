package com.bankApp.EmployeeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bankApp.People.Account;
import com.bankApp.People.BankUser;
import com.bankApp.People.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String url = "jdbc:oracle:thin:@atworkdb.c05sxxntbuck.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String username = "chinook";
	private static final String passwordDB = "p4ssw0rd";

	@Override
	public boolean approveAccount(int act) {

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, passwordDB);

			String SQLStatement = "UPDATE CHECKING_ACCOUNT SET ACCOUNT_STATUS = ? WHERE ACCOUNT_NUMBER = ?";

			PreparedStatement ps = conn.prepareStatement(SQLStatement);
			ps.setInt(1, 1);
			ps.setInt(2, act);

			ps.execute();

			// cleanup and escape
			conn.prepareStatement("COMMIT").execute();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

	//TODO possible bug, the code will say operation successful if there is no account to delete
	@Override
	public boolean deleteAccount(int act) {
		try {
			Connection conn = DriverManager.getConnection(url, username, passwordDB);

			String deleteAccount = "DELETE FROM CHECKING_ACCOUNT WHERE ACCOUNT_NUMBER = ?";

			PreparedStatement st1 = conn.prepareStatement(deleteAccount);
			st1.setInt(1, act);

			st1.execute();

			conn.prepareStatement("COMMIT").execute();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public ArrayList<BankUser> recallInformation(int act) {

		String getAccountHolders = "SELECT BANK_USER.USERNAME, BANK_USER.FIRSTNAME, BANK_USER.LASTNAME FROM USER_CHECKING_ACCOUNT INNER JOIN BANK_USER ON USER_CHECKING_ACCOUNT.USERNAME = BANK_USER.USERNAME WHERE ACCOUNT_NUMBER = ?";
		ArrayList<BankUser> queryResult = new ArrayList<BankUser>();

		try {
			Connection conn = DriverManager.getConnection(url, username, passwordDB);

			PreparedStatement st1 = conn.prepareStatement(getAccountHolders);
			st1.setInt(1, act);

			ResultSet accountHolders = st1.executeQuery();

			while (accountHolders.next()) {
				BankUser tmp = new BankUser(accountHolders.getString(1), accountHolders.getString(2),
						accountHolders.getString(3), null);
				queryResult.add(tmp);
			}

			String getAccountDetails = "SELECT CURRENT_BALANCE, ACCOUNT_STATUS FROM CHECKING_ACCOUNT WHERE ACCOUNT_NUMBER = ?";
			PreparedStatement st2 = conn.prepareStatement(getAccountDetails);
			st2.setInt(1, act);
			ResultSet accountDetails = st2.executeQuery();

			accountDetails.next();

			Account tmp = new Account(accountDetails.getDouble(1), act, accountDetails.getInt(2));

			for (BankUser i : queryResult) {
				i.addAccount(tmp);
			}

			conn.close();

			return queryResult;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Employee login(String usrName, String password) {
		try {
			Connection conn = DriverManager.getConnection(url, username, passwordDB);
			String SQLStatement = "SELECT * FROM EMPLOYEE1 WHERE USERNAME = ? AND PASSWORD_USER = ?";

			PreparedStatement ps = conn.prepareStatement(SQLStatement);
			ps.setString(1, usrName);
			ps.setString(2, password);
			ResultSet rs1 = ps.executeQuery();

			rs1.next();
			Employee tmp = new Employee(rs1.getString(2), rs1.getString(3), rs1.getString(1), rs1.getString(4), rs1.getInt(5));

			return tmp;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
