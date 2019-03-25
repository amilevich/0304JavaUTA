package com.reimb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reimb.model.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "project1user";
	private static final String password = "1234";

	@Override
	public int insertReimbursement(Reimbursement r) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSEMENT VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setDouble(1, r.getReimbAmount());
			System.out.println("SET AMOUNT");
			ps.setString(2, r.getReimbSubmitted());
			System.out.println("SET TIMESTAMP SUBMITTED");
			ps.setString(3, r.getReimbResolved());
			System.out.println("SET TIMESTAMP RESOLVED");
			ps.setString(4, r.getReimbDescription());
			System.out.println("SET DESCRIPTION");
			ps.setBytes(5, r.getReimbReceipt());
			System.out.println("SET RECEIPT");
			ps.setInt(6, r.getReimbAuthor());
			System.out.println("SET AUTHOR");
			ps.setInt(7, r.getReimbResolver());
			System.out.println("SET RESOLVER");
			ps.setInt(8, r.getReimbStatusId());
			System.out.println("SET STATUS ID");
			ps.setInt(9, r.getReimbTypeId());
			System.out.println("SET TYPE ID");
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("END OF INSERT REIMBURSEMENT");
		return 0;
	}

	@Override
	public Reimbursement searchReimbursementById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> selectAllReimbursement() {

		List<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENT");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), 
											rs.getDouble("reimb_amount"), 
											rs.getString("reimb_submitted"), 
											rs.getString("reimb_resolved"),
											rs.getString("reimb_description"), 
											rs.getBytes("reimb_receipt"), 
											rs.getInt("reimb_author"),
											rs.getInt("reimb_resolver"), 
											rs.getInt("reimb_status_id"), 
											rs.getInt("reimb_type_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbs;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteReimbursement(Integer id) {
		// TODO Auto-generated method stub

	}

}