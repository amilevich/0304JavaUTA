package com.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectone.models.ReimbursementType;
import com.projectone.models.UserRoles;

public class ReimbursementTypeDaoImpl implements ReimbursementTypeDao{
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "username";
	private static String password = "passw0rd";

	@Override
	public int insertReimbursementType(ReimbursementType x) {
		System.out.println("0");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("ReimbursementType 1");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT_TYPE(REIMB_TYPE) VALUES(?)");
			System.out.println("ReimbursementType 2");
			//ps.setInt(1, x.getReimbTypeId());
			ps.setString(1, x.getReimbType());
			System.out.println("ReimbursementType 3");
			ps.executeUpdate();
			System.out.println("ReimbursementType 4");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ReimbursementType selectReimbursementTypeByName(Integer x) {
		ReimbursementType pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID=?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new ReimbursementType(rs.getInt("REIMB_TYPE_ID"), rs.getString("REIMB_TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}


}
