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
	 * JDBC API
	 * 
	 * Important Interfaces: Connection - allows us to connect to our db Statement -
	 * allows for SQL injection PreparedStatement - precompiles the SQL string
	 * without parameters once the parameters are added, they are only treated as
	 * values, never keywords CallableStatement - stored procedures
	 * 
	 * Statement vs PreparedStatement 1. PS has better readibility 2. PS more secure
	 * than statement (no SQL injections)
	 * 
	 * To connect to our database, we need 4 things: 1. URL 2. Username 3. Password
	 * 4. Driver (the jar that implements JDBC)
	 * 
	 * URL = endpoint + port + database name
	 */

	private static String url = "jdbc:oracle:thin:@db-instance-0304uta.c4ngsdhhjuji.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "PetLover";
	private static String password = "p4ssw0rd";

	@Override
	public int insertPet(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Pet VALUES(?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pet WHERE name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new Pet(rs.getString("name"), rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}

	@Override
	public int updatePet(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Pet SET type=? WHERE name=?");
			ps.setString(1, p.getType());
			ps.setString(2, p.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deletePet(Pet p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Pet WHERE name=?");
			ps.setString(1, p.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// FOR AUTOINCREMENT
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
	// @Override
	// public int insertAccount(Account a) {
	// int id = 0;
	// try(Connection conn = DriverManager.getConnection(url, username, password)) {
	// PreparedStatement ps = conn.prepareStatement("INSERT INTO account VALUES(?,
	// ?)");
	// id = nextSequence();
	// ps.setInt(1, id);
	// ps.setDouble(2, a.amount);
	// ps.executeUpdate();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return id+1;
	// }

	@Override
	public List<Pet> selectAllPets() {
		List<Pet> pets = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pet");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pets.add(new Pet(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

}
