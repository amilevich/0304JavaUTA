package com.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.projectone.models.Reimbursement;
import com.projectone.models.Users;

public class ReimbursementDaoImpl implements ReimbursementDao{
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "username";
	private static String password = "passw0rd";

	@Override
	public int insertReimbursement(Reimbursement p) {
		System.out.println("Reimbursement 0");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Reimbursement 1");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES(?,?,?,?,?,?,?,?,?)");
			System.out.println("Reimbursement 2");
			//ps.setInt(1, p.getReimbId());
			ps.setDouble(1, p.getReimbAmount());
			ps.setTimestamp(2, p.getReimbSubmitted());
			ps.setTimestamp(3, p.getReimbResolved());
			ps.setString(4, p.getReimbDescription());
			ps.setBlob(5, p.getReimbReceipt());
			ps.setInt(6, p.getReimbAuthor());
			ps.setInt(7, p.getReimbResolver());
			ps.setInt(8, p.getReimbStatusId());
			ps.setInt(9, p.getReimbTypeId());
			System.out.println("Reimbursement 3");
			ps.executeUpdate();
			System.out.println("Reimbursement 4");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Reimbursement selectReimbursementById(Integer x) {
		Reimbursement pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new Reimbursement(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"), rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_RESOLVED"), rs.getString("REIMB_DESCRIPTION"), rs.getBlob("REIMB_RECEIPT"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"), rs.getInt("REIMB_STATUS_ID"), rs.getInt("REIMB_TYPE_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}

	@Override
	public int updateReimbursement(Timestamp x, Integer y) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=? WHERE REIMB_ID=?");
			ps.setTimestamp(1, x);
			ps.setInt(2, y);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
