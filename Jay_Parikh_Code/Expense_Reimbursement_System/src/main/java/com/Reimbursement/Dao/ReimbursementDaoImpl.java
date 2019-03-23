package com.Reimbursement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao{

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cmseb0jui8wp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Jay";
	private static String password = "password";
	
	
	@Override
	public int insertReimbursement(Reimbursement u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Reimbursements (balance, status) VALUES (?,0)");
			ps.setDouble(1, u.getAmount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//id
	@Override
	public Reimbursement selectReimbursementById(int id) {
		Reimbursement reimbursement = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursements WHERE Reimbursementnumber=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				reimbursement = new Reimbursement();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursements");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public int updateReimbursement(Reimbursement u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Reimbursements SET balance=?, status=? WHERE Reimbursementnumber=?");
			ps.setDouble(1, u.getAmount());
			ps.setDouble(2, u.getStatus());
			ps.setInt(3, u.getReimburseId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteReimbursement(Integer u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Reimbursements WHERE Reimbursementnumber=?");
			ps.setInt(1, u);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int nextSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT acc_seq.NEXTVAL FROM dual");
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
	public Reimbursement selectReimbursementByName(String name) {
		Reimbursement reimbursement = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursements WHERE =?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				reimbursement = new Reimbursement();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

}
