package com.bank.daoJunctionTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Junction;
import com.bank.model.UserAccount;

public class DaoJunctionImpl implements DaoJunction {

	private static String url = "jdbc:oracle:thin:@revaturedb.clyh6jvswypw.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "thebankman";
	private static String password = "bank";

	public Junction getJunctionByUserId(int userId) {
		Junction junction = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Jn_Users_Accounts WHERE UserId = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				junction = new Junction(rs.getInt("Jn_Users_Accounts_Id"), rs.getInt("UserId"), rs.getInt("AccountId"),
						rs.getInt("isJointAccount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return junction;
	}

	public Junction getJunctionByAccountId(int accountId) {
		Junction junction = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Jn_Users_Accounts WHERE AccountId = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				junction = new Junction(rs.getInt("Jn_Users_Accounts_Id"), rs.getInt("UserId"), rs.getInt("AccountId"),
						rs.getInt("isJointAccount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return junction;
	}

	public int nextJunctionSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT jn_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public int insertJunction(Junction j) {
		int users_accounts_id = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Jn_Users_Accounts VALUES (?, ?, ?, ?)");
			users_accounts_id = nextJunctionSequence();
			ps.setInt(1, users_accounts_id);
			ps.setInt(2, j.getUserId());
			ps.setInt(3, j.getAccountId());
			ps.setInt(4, j.getIsJointAccount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users_accounts_id;
	}

	public List<UserAccount> getUserAccountsByUserName(String userName) {
		List<UserAccount> useraccounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT u.userid, u.username, a.accountid, a.accountname, a.balance, a.isactive, a.isapproved "
							+ "FROM Users u " + "INNER JOIN Jn_Users_Accounts j ON u.userid = j.userid "
							+ "INNER JOIN Accounts a ON j.accountid = a.accountid " + "WHERE u.username = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserAccount tmpUsAc = new UserAccount();
				tmpUsAc.setUserId(rs.getInt(1));
				tmpUsAc.setUsername(rs.getString(2));
				tmpUsAc.setAccountId(rs.getInt(3));
				tmpUsAc.setAccountName(rs.getString(4));
				tmpUsAc.setBalance(rs.getDouble(5));
				tmpUsAc.setIsActive(rs.getInt(6));
				tmpUsAc.setIsApproved(rs.getInt(7));
				useraccounts.add(tmpUsAc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return useraccounts;
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		List<UserAccount> useraccounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT u.userid, u.username, a.accountid, a.accountname, a.balance, a.isactive, a.isapproved "
							+ "FROM Users u " + "INNER JOIN Jn_Users_Accounts j ON u.userid = j.userid "
							+ "INNER JOIN Accounts a ON j.accountid = a.accountid");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserAccount tmpUsAc = new UserAccount();
				tmpUsAc.setUserId(rs.getInt(1));
				tmpUsAc.setUsername(rs.getString(2));
				tmpUsAc.setAccountId(rs.getInt(3));
				tmpUsAc.setAccountName(rs.getString(4));
				tmpUsAc.setBalance(rs.getDouble(5));
				tmpUsAc.setIsActive(rs.getInt(6));
				tmpUsAc.setIsApproved(rs.getInt(7));
				useraccounts.add(tmpUsAc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return useraccounts;
	}
}
