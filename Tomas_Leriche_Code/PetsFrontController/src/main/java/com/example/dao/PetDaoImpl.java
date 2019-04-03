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

public class PetDaoImpl implements PetDao {

	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }
	
	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "project1user";
	private static final String password = "1234";

	
	@Override
	public int insertPet(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO PET (name, type, age, first_name, last_name,"
													+ " email) values(?,?,?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			ps.setInt(3, p.getAge());
			ps.setString(4, p.getFirst_name());
			ps.setString(5, p.getLast_name());
			ps.setString(6, p.getEmail());
			
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Pet selectPetByName(String name) {
		Pet pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PET WHERE NAME = ?");
			ps.setString(1, name);
			
			
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				pet = new Pet(rs.getInt(1),
								rs.getString(2), 
								rs.getString(3), 
								rs.getInt(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getInt(8));
			}
					
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pet;
	}
	
	@Override
	public int updatePet(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Pet SET type=?, age=?, first_name=?, "
										+ "last_name=?, email=? WHERE name=?");
			ps.setString(1, p.getType());
			ps.setInt(2, p.getAge() );
			ps.setString(3, p.getFirst_name() );
			ps.setString(4, p.getLast_name() );
			ps.setString(5, p.getEmail() );
			ps.setString(6, p.getName());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Reimbursement1> selectReimbursementsByUserId(int id) {
		List<Reimbursement1> reimbs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement1 r inner join reimbursement_status rs on r.REIMB_STATUS_ID = rs.REIMB_STATUS_ID where reimb_author = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbs.add(new Reimbursement1(rs.getInt("reimb_id"), 
								rs.getDouble("reimb_amount"), 
								rs.getInt("reimb_author"),
								rs.getString("reimb_submitted"),
								rs.getString("reimb_resolved"),
								rs.getString("reimb_description"),
								rs.getInt("reimb_status_id"),
								rs.getString("reimb_status")
						));		 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("THIS" +reimbs);
		return reimbs;
	}
	
}
