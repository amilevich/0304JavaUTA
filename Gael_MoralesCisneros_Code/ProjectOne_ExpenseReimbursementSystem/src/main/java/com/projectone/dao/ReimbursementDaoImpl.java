package com.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES(?,?,?,?,?,?,?)");
            System.out.println("Reimbursement 2");
            //ps.setInt(1, p.getReimbId());
            ps.setDouble(1, p.getReimbAmount());
            ps.setString(2, p.getReimbSubmitted());
            ps.setString(3, p.getReimbResolved());
            ps.setString(4, p.getReimbDescription());
            ps.setInt(5, p.getReimbAuthor());
            ps.setString(6, p.getReimbStatus());
            ps.setString(7, p.getReimbType());
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
                pet = new Reimbursement(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"), rs.getString("REIMB_SUBMITTED"), rs.getString("REIMB_RESOLVED"), rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"), rs.getString("REIMB_STATUS_ID"), rs.getString("REIMB_TYPE_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return pet;
    }

	@Override
	public Integer selectReimbursementStatusByMax() {
	     Integer petid = null;
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            PreparedStatement ps = conn.prepareStatement("SELECT MAX(REIMB_STATUS_ID) FROM ERS_REIMBURSEMENT_STATUS");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                petid = rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();

	        }
	        return petid;
	}

	@Override
	public Integer selectReimbursementTypeByMax() {
        Integer pet = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(REIMB_TYPE_ID) FROM ERS_REIMBURSEMENT_TYPE");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pet = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return pet;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		List<Reimbursement> reimb = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"), rs.getString("REIMB_SUBMITTED"), rs.getString("REIMB_RESOLVED"), rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"), rs.getString("REIMB_STATUS_ID"), rs.getString("REIMB_TYPE_ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return reimb;
	}

	@Override
	public Integer selectUserIDByUsername(String x) {
	      Users pet = null;
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
	            ps.setString(1, x);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                pet = new Users(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();

	        }
	        return pet.getErsUsersId();
	}
	
	@Override
    public int updateReimbursement(Reimbursement x) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=?, REIMB_RESOLVER=?, REIMB_STATUS_ID=? WHERE REIMB_ID=?");
            ps.setString(1, x.getReimbResolved());
            ps.setInt(2, x.getReimbResolver());
            ps.setString(3, x.getReimbStatus());
            ps.setInt(4,x.getReimbId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}