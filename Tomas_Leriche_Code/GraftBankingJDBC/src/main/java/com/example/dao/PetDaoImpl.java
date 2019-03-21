package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pet;

public class PetDaoImpl implements PetDao {

	/*
	 * 
	 * JDBC API
	 * 
	 * Important Interfaces: Connection - allows us to connect to our DB Statement -
	 * allows for SQL injection PreparedStatement - precompiles the SQL string
	 * without parameters - once the parameters are added, they are only treated as
	 * values. - never keywords. CallableStatement - stored procedures
	 * 
	 * 1. PS has better readability 2. PS more secure than statement
	 * 
	 * 1. URL, username, password, Driver (the jar that implements JDBC)
	 * 
	 * URL = endpoint + port + database name
	 * 
	 */

	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "otheruser";
	private static final String password = "otheruser";
	
	int count = 1;

	// FOR AUTO INCREMENT
	@Override
	public int insertPet(Pet p) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PET (name, type, password) VALUES (?, ?, ?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			ps.setString(3, p.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Pet selectPetById(int id) {
		Pet pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pet WHERE pet_id = ?");
			ps.setInt(1, id);
			//ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pet = new Pet(rs.getInt("pet_id"), 
								rs.getString("name"), 
								rs.getString("type"), 
								rs.getString("password"),
								rs.getString("hasAccount"),
								rs.getString("accountApproved"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pet;
	}

	@Override
	public Pet selectPetByName(String name) {
		Pet pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pet WHERE name = ?");
			ps.setString(1, name);
			//ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pet = new Pet(rs.getInt("pet_id"), 
								rs.getString("name"), 
								rs.getString("type"), 
								rs.getString("password"),
								rs.getString("hasAccount"),
								rs.getString("accountApproved"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pet;
	}
	
	

	@Override
	public int updatePetTypeWhereName(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Pet SET name = ?,"
					+ ", type = ?, password = ?, hasAccount = ?,"
					+ "accountApproved = ? WHERE name = ?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.isHasAccount());
			ps.setString(5, p.getAccountApproved());
			ps.setString(6, p.getName());
	
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int updatePetNameWhereId(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Pet SET name = ?"
					+ ", type = ?, password = ?, hasAccount = ?,"
					+ "accountApproved = ? WHERE pet_id = ?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.isHasAccount());
			ps.setString(5, p.getAccountApproved());
			ps.setInt(6, p.getPet_id());	
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deletePetByName(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Pet WHERE name = ?");
			ps.setString(1, p.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deletePetById(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Pet WHERE pet_id = ?");
			ps.setInt(1, p.getPet_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Pet> selectAllPets() {
		List<Pet> pets = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pet");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pets.add(new Pet(rs.getInt("pet_id"), 
								rs.getString("name"), 
								rs.getString("type"), 
								rs.getString("password"),
								rs.getString("hasAccount"),
								rs.getString("accountApproved")));			 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

	

	
}
