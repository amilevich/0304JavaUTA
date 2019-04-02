package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Reimbursement;
import com.project1.model.UserReimb;

public class DaoReimbursementImpl implements DaoReimbursement {

		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	private static String url = "jdbc:oracle:thin:@revaturedb.clyh6jvswypw.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "reimburse";
	private static String password = "project1";

	@Override
	public int insertReimbursement(Reimbursement reimbursement) {
		int reimb_Id = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ERS_Reimbursement VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			reimb_Id = nextReimbursementSequence();
			ps.setInt(1, reimb_Id);
			ps.setDouble(2, reimbursement.getReimb_amount());
			ps.setDate(3, reimbursement.getReimb_submitted());
			ps.setDate(4, reimbursement.getReimb_resolved());
			ps.setString(5, reimbursement.getReimb_description());
			ps.setBlob(6, reimbursement.getReimb_receipt());
			ps.setInt(7, reimbursement.getReimb_author());
			ps.setNull(8, java.sql.Types.INTEGER);
			//ps.setInt(8, reimbursement.getReimb_resolver());
			ps.setInt(9, reimbursement.getReimb_status_Id());
			ps.setInt(10, reimbursement.getReimb_type_Id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb_Id;
	}

	@Override
	public int updateReimbursement(Reimbursement reimbursement) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ERS_Reimbursement SET reimb_amount = ?, reimb_submitte = ?, reimb_resolved = ?, reimb_description = ?, reimb_receipt = ?,"
							+ " reimb_author = ?, reimb_resolver = ?, reimb_status_Id = ?, reimb_type_Id = ? reimb_Id = ?");
			ps.setDouble(1, reimbursement.getReimb_amount());
			ps.setDate(2, reimbursement.getReimb_submitted());
			ps.setDate(3, reimbursement.getReimb_resolved());
			ps.setString(4, reimbursement.getReimb_description());
			ps.setBlob(5, reimbursement.getReimb_receipt());
			ps.setInt(6, reimbursement.getReimb_author());
			ps.setInt(7, reimbursement.getReimb_resolver());
			ps.setInt(8, reimbursement.getReimb_status_Id());
			ps.setInt(9, reimbursement.getReimb_type_Id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement.getReimb_Id();
	}

	@Override
	public List<UserReimb> selectAllReimbursements(int user_Id) {
		List<UserReimb> reimbursements = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT " + 
					"REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECIEPT," + 
					"ERS_Reimbursement.REIMB_AUTHOR, authors.USER_FIRST_NAME authorsFirstName, authors.USER_LAST_NAME authorsLastName," + 
					"resolvers.USER_FIRST_NAME resolversFirstName, resolvers.USER_LAST_NAME resolversLastName," + 
					"REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID " + 
					"FROM ERS_Reimbursement " + 
					"LEFT OUTER JOIN ERS_USERS authors " + 
					"ON ERS_Reimbursement.REIMB_AUTHOR = authors.ERS_USERS_ID " + 
					"LEFT OUTER JOIN ERS_USERS resolvers " + 
					"ON ERS_Reimbursement.REIMB_RESOLVER = resolvers.ERS_USERS_ID");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserReimb tmpReimb = new UserReimb();
				tmpReimb.setReimb_Id(rs.getInt(1));
				tmpReimb.setReimb_amount(rs.getDouble(2));
				tmpReimb.setReimb_submitted(rs.getDate(3));
				tmpReimb.setReimb_resolved(rs.getDate(4));
				tmpReimb.setReimb_description(rs.getString(5));
				tmpReimb.setReimb_receipt(rs.getBlob(6));
				tmpReimb.setReimb_author(rs.getInt(7));
				tmpReimb.setReimb_author_name(rs.getString(8) + " " + rs.getString(9));
				tmpReimb.setReimb_resolver_name(rs.getString(10) + " " + rs.getString(11));
				tmpReimb.setReimb_resolver(rs.getInt(12));
				tmpReimb.setReimb_status_Id(rs.getInt(13));
				tmpReimb.setReimb_type_Id(rs.getInt(14));
				reimbursements.add(tmpReimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<UserReimb> selectReimbursementsByUser(int user_Id) {
		List<UserReimb> reimbursements = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Reimbursement WHERE Reimb_author = ?");
			ps.setInt(1, user_Id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserReimb tmpReimb = new UserReimb();
				tmpReimb.setReimb_amount(rs.getDouble(1));
				tmpReimb.setReimb_submitted(rs.getDate(2));
				tmpReimb.setReimb_resolved(rs.getDate(3));
				tmpReimb.setReimb_description(rs.getString(4));
				tmpReimb.setReimb_receipt(rs.getBlob(5));
				tmpReimb.setReimb_author(rs.getInt(6));
				tmpReimb.setReimb_resolver(rs.getInt(7));
				tmpReimb.setReimb_status_Id(rs.getInt(8));
				tmpReimb.setReimb_type_Id(rs.getInt(9));
				reimbursements.add(tmpReimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	@Override
	public int updateReimbStatus(int reimbId, int status, int resolverId) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ERS_Reimbursement SET reimb_status_Id = ?, reimb_resolver = ? WHERE reimb_Id = ?");
			ps.setInt(1, status);
			ps.setInt(2, resolverId);
			ps.setInt(3, reimbId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbId;
	}
	
	private int nextReimbursementSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT reimbursement_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}


}
