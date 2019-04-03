package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pet;
import com.example.model.Reimbursement1;

public class Reimbursement1DaoImpl implements Reimbursement1Dao {

	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "project1user";
	private static final String password = "1234";
	@Override
	public int insertReimbursement(Reimbursement1 r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSEMENT1 (reimb_amount,"
														+ " reimb_author, reimb_description) VALUES (?, ?, ?)");
			ps.setDouble(1, r.getReimb_amount());
			ps.setInt(2, r.getReimb_author() );
			ps.setString(3, r.getReimb_description());

			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Reimbursement1 selectReimbById(int id) {
		Reimbursement1 reimb = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement1 r inner join reimbursement_status rs on r.REIMB_STATUS_ID = rs.REIMB_STATUS_ID");
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				reimb = new Reimbursement1(rs.getInt(1),
								rs.getDouble(2), 
								rs.getInt(3), 
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getInt(7),
								rs.getString("reimb_status")
								);

			}
					
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimb;
	}
	
	
	@Override
	public List<Reimbursement1> selectAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int updateReimbursement(Reimbursement1 r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE reimbursement1 SET reimb_amount=?, reimb_description=? "
										+ " WHERE reimb_id=?");
			ps.setDouble(1, r.getReimb_amount() );
			ps.setString(2, r.getReimb_description() );
			ps.setInt(3, r.getReimb_id() );

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public List<Reimbursement1> selectAllPetsReimbs() {
		List<Reimbursement1> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("select * from reimbursement1 r inner join pet p on r.REIMB_AUTHOR = p.USER_ID");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("worked");
				reimbs.add(new Reimbursement1(rs.getInt("reimb_id"), 
								rs.getDouble("reimb_amount"), 
								rs.getInt("reimb_author"), 
								rs.getString("reimb_submitted"),
								rs.getString("reimb_resolved"),
								rs.getString("reimb_description"),
								rs.getString("first_name"),
								rs.getString("last_name"),
								rs.getInt("reimb_status_id")
						));			 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
}
