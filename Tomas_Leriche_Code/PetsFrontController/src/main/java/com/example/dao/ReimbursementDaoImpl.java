package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.example.model.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "project1user";
	private static final String password = "1234";
	
	@Override
	public int insertReimbursement(Reimbursement r) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSEMENT (reimb_amount, reimb_submitted,"
														+ " reimb_author, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?)");
			ps.setDouble(1, r.getReimbAmount());
			ps.setString(2, r.getReimbSubmitted() );
			ps.setInt(3, r.getReimbAuthor());
			ps.setInt(4, r.getReimbStatusId());
			ps.setInt(5, r.getReimbTypeId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
