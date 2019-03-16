package com.bankApp.BankUserDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.bankApp.People.Account;
import com.bankApp.People.BankUser;

public class BankUserDAOImpl implements BankUserDAO {

	private static final String url = "jdbc:oracle:thin:@atworkdb.c05sxxntbuck.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String username = "chinook";
	private static final String passwordDB = "p4ssw0rd";

	public BankUserDAOImpl() {

	}

	// TODO all methods must update the state of the object and database!!!
	@Override
	public boolean withdraw(double amt, int whichAccount, BankUser acct) {

		if (acct.getAccount(whichAccount).getAccountStatus() == 0) {
			return false;
		}

		try (Connection conn = DriverManager.getConnection(url, username, passwordDB)) {

			// retrieves the account the user withdraws from
			Account tmp = acct.getAccount(whichAccount);
			double currentBalance = tmp.getCurrentBalance();

			// SQL STATEMENT UPDATE CHECKING_ACCOUNT SET CURRENT_BALANCE TO newBalance WHERE
			// ACCOUNT_NUMBER = actNum
			String sqlStatement = "UPDATE CHECKING_ACCOUNT SET CURRENT_BALANCE ="
					+ Double.toString(currentBalance - amt) + " WHERE ACCOUNT_NUMBER ="
					+ Integer.toString(tmp.getAccountNumber());

			// some input validation

			if (amt > currentBalance || amt < 0) {
				conn.close();
				return false;
			} else {
				// updates the local objects current balance, then updates the databases record
				tmp.setCurrentBalance(currentBalance - amt);
				PreparedStatement ps = conn.prepareStatement(sqlStatement);
				ps.executeQuery();
				conn.close();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deposit(double amt, int whichAccount, BankUser acct) {

		if (acct.getAccount(whichAccount).getAccountStatus() == 0) {
			return false;
		}

		try (Connection conn = DriverManager.getConnection(url, username, passwordDB)) {

			// retrieves the account the user withdraws from
			Account tmp = acct.getAccount(whichAccount);
			double currentBalance = tmp.getCurrentBalance();

			// SQL STATEMENT UPDATE CHECKING_ACCOUNT SET CURRENT_BALANCE TO newBalance WHERE
			// ACCOUNT_NUMBER = actNum
			String sqlStatement = "UPDATE CHECKING_ACCOUNT SET CURRENT_BALANCE ="
					+ Double.toString(currentBalance + amt) + " WHERE ACCOUNT_NUMBER ="
					+ Integer.toString(tmp.getAccountNumber());

			// input validation
			if (amt < 0) {
				conn.close();
				return false;
			} else {
				tmp.setCurrentBalance(currentBalance + amt);
				PreparedStatement ps = conn.prepareStatement(sqlStatement);
				ps.executeQuery();
				conn.close();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean transfer(double amt, int whichAccountFrom, int whichAccountTo, BankUser from, BankUser to) {
		return withdraw(amt, whichAccountTo, from) && deposit(amt, whichAccountFrom, to);
	}

	@Override
	public boolean insertAccount(BankUser acct) {
		try (Connection conn = DriverManager.getConnection(url, username, passwordDB)) {

			CallableStatement cStmt = conn.prepareCall("{call add_checking_account(?,?)}");

			cStmt.setString(1, Double.toString(0));
			cStmt.registerOutParameter(2, Types.INTEGER);

			cStmt.execute();

			Account tmp = new Account(0, cStmt.getInt(2), 0);
			acct.addAccount(tmp);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean insertBankUser(BankUser acct) {
		try {

			Connection conn = DriverManager.getConnection(url, username, passwordDB);
			CallableStatement cStmt = conn.prepareCall("{call add_bank_user(?,?,?,?)}");

			cStmt.setString(1, acct.getUsername());
			cStmt.setString(2, acct.getFirstName());
			cStmt.setString(3, acct.getLastName());
			cStmt.setString(4, acct.getPassword());

			cStmt.execute();
			// Lesson learned, close the connections after you're done
			// otherwise they wait on each other
			conn.close();

			// create an account for the user
			insertAccount(acct);

			// reopen the connection
			conn = DriverManager.getConnection(url, username, passwordDB);

			// add this new account and user to the join table
			String statement = "INSERT INTO USER_CHECKING_ACCOUNT VALUES(? , ?)";

			PreparedStatement cStmt2 = conn.prepareStatement(statement);

			cStmt2.setString(1, acct.getUsername());
			cStmt2.setInt(2, acct.getAccount(0).getAccountNumber());

			cStmt2.executeQuery();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override
	public BankUser login(String usrName, String password) {

		try {
			Connection conn = DriverManager.getConnection(url, username, passwordDB);
			String SQLStatement = "SELECT * FROM BANK_USER WHERE USERNAME = ? AND PASSWORD_USER = ?";

			PreparedStatement ps = conn.prepareStatement(SQLStatement);
			ps.setString(1, usrName);
			ps.setString(2, password);
			ResultSet rs1 = ps.executeQuery();

			rs1.next();
			BankUser tmp = new BankUser(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));

			String SQLStatement2 = "SELECT CHECKING_ACCOUNT.CURRENT_BALANCE, CHECKING_ACCOUNT.ACCOUNT_NUMBER, CHECKING_ACCOUNT.ACCOUNT_STATUS FROM USER_CHECKING_ACCOUNT INNER JOIN CHECKING_ACCOUNT ON USER_CHECKING_ACCOUNT.ACCOUNT_NUMBER = CHECKING_ACCOUNT.ACCOUNT_NUMBER WHERE USER_CHECKING_ACCOUNT.USERNAME = ?";
			// String SQLStatement2 = "SELECT * FROM USER_CHECKING_ACCOUNT";
			PreparedStatement ps2 = conn.prepareStatement(SQLStatement2);
			ps2.setString(1, usrName);
			ResultSet rs2 = ps2.executeQuery();

			while (rs2.next()) {
				Account tmp2 = new Account(rs2.getDouble(1), rs2.getInt(2), rs2.getInt(3));
				tmp.addAccount(tmp2);
			}

			return tmp;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * TODO move this to employeedao
	 * 
	 * @Override public void approveAccount(BankUserDAO act) { String sqlStatement =
	 * "UPDATE CHECKING_ACCOUNT SET ACCOUNT_STATUS = 1" +
	 * "WHERE ACCOUNT_NUMBER ="+Integer.toString(act.getAccountNumber());
	 * 
	 * try (Connection conn = DriverManager.getConnection(url, username, password))
	 * {
	 * 
	 * 
	 * PreparedStatement ps = conn.prepareStatement(sqlStatement);
	 * ps.executeQuery();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * @Override public Person login(String usrName, String password) { String
	 * sqlStatement1 = "Select * FROM BANK_USER WHERE USERNAME ="+usrName +
	 * " AND PASSWORD_USER ="+password;
	 * 
	 * try (Connection conn = DriverManager.getConnection(url, username, password))
	 * {
	 * 
	 * 
	 * PreparedStatement ps = conn.prepareStatement(sqlStatement1); ResultSet rs =
	 * ps.executeQuery();
	 * 
	 * int accountType = rs.getInt(1);
	 * 
	 * return new
	 * Person(rs.getString(3),rs.getString(4),rs.getString(2),rs.getString(5));
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return null; }
	 * 
	 * @Override public void deleteAccount(BankUserDAO act) {
	 * 
	 * 
	 * }
	 * 
	 * @Override public void recallInformation(BankUserDAO act) {
	 * 
	 * 
	 * }
	 */
}
