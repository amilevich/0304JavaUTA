package com.Project1.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Project1.Dao.ReimbursementDao;
import com.Project1.Model.Reimbursement;
import com.Project1.Model.User;

public class ReimbursementDaoImpl implements ReimbursementDao {

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	private static String url = "jdbc:oracle:thin:@erssql.ctjqi18j2emr.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "BigBoss";
	private static String password = "BigBosss";

	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO Reimbursements " + "(reimbursement_id, reimbursement_type_id, reimbursement_amount,"
							+ " reimbursement_description, reimbursement_author," + "reimbursement_status_id)"
							+ " VALUES(?,?,?,?,?,?)");
			ps.setInt(1, r.getReimbursementId());
			ps.setInt(2, r.getReimbursementTypeId());
			ps.setInt(3, r.getReimbursementAmount());
			ps.setString(4, r.getReimbursementDescription());
			ps.setInt(5, r.getReimbursementAuthor());
			ps.setInt(6, r.getReimbursementStatusId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Reimbursement selectReimbursementById(int id) {
		Reimbursement reimb = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Reimbursements " + "WHERE reimbursement_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9), rs.getString(5));
				reimb.setAuthor(returnName(reimb.getReimbursementAuthor()));
				reimb.setResolver(returnName(reimb.getReimbursementResolver()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByAuthor(String author) {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM Users " + "WHERE username = ?");
			ps.setString(1, author);
			ResultSet rs = ps.executeQuery();
			int userId = 0;
			while (rs.next()) {
				userId = rs.getInt(1);
			}
			ps = conn.prepareStatement("SELECT * FROM Reimbursements " + "WHERE reimbursement_author = ?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getString(5));
				temp.setAuthor(returnName(temp.getReimbursementAuthor()));
				temp.setResolver(returnName(temp.getReimbursementResolver()));
				reimb.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByStatusId(int statusId) {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Reimbursements " + "WHERE reimbursement_status_id = ?");
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getString(5));
				temp.setAuthor(returnName(temp.getReimbursementAuthor()));
				temp.setResolver(returnName(temp.getReimbursementResolver()));
				reimb.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursements");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getString(5));
				temp.setAuthor(returnName(temp.getReimbursementAuthor()));
				temp.setResolver(returnName(temp.getReimbursementResolver()));
				reimb.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public int updateReimbursementById(int id, User user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("UPDATE Reimbursements " + 
			"SET reimbursement_status_id=1, reimbursement_resolver=? "
			+ "WHERE reimbursement_id = ?");
			ps.setInt(1, user.getUserId());
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteReimbursementById(int id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Reimbursements " + "WHERE reimbursement_id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int returnMaxReimbursementId() {
		int res = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement s = conn.createStatement();
			ResultSet resSet = s.executeQuery("SELECT MAX(reimbursement_id) FROM Reimbursements");
			if (resSet.next()) {
				res = resSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String returnName(int Id) {
		if (Id == 0)
			return "-";
		String res = "";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT firstname, lastname FROM Users " + "WHERE user_id=?");
			ps.setInt(1, Id);
			ResultSet resSet = ps.executeQuery();
			if (resSet.next()) {
				res = resSet.getString(1);
				res += " " + resSet.getString(2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
