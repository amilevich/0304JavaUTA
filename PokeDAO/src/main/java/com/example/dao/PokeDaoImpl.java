package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pokemon;

public class PokeDaoImpl implements PokeDao {
	// private static String url= "jdbc:oracle:thin:localhost:1521:xe";
	private static String url = "jdbc:oracle:thin:@wvudatabase.cctjesrx2liq.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Admin";
	private static String password = "p4ssw0rd";

	
	public static void main(String[] args) {
		
	}
	@Override
	public int insertPokemon(Pokemon p) {
		return 0;
	}

	@Override
	public List<Pokemon> selectAllPokemon() {
		List<Pokemon> pokes = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM pokemon";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pokes.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString("pokemon_type")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pokes;
	}

	@Override
	public Pokemon selectPokemonById(int id) {
		Pokemon pid = new Pokemon();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM pokemon WHERE pokemonid =?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id+"");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pid = new Pokemon(rs.getInt("pokemonid"), rs.getString(1), rs.getString(2));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pid;
	}

	@Override
	public Pokemon selectPokemonByName(String name) {		
	Pokemon names = new Pokemon();
	try(Connection conn = DriverManager.getConnection(url, username, password)){
		String sql = "SELECT * FROM pokemon WHERE pokemon_name =?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			names = new Pokemon(rs.getInt(1), rs.getString("pokemon_name"), rs.getString(2));
		}
		
	}catch(SQLException e) {
		e.printStackTrace();

	}
	return names;
	}

	@Override
	public List<Pokemon> selectByType(String type) {
		List<Pokemon> s_type = new ArrayList<>();
	try(Connection conn = DriverManager.getConnection(url, username, password)){
		String sql = "SELECT * FROM pokemon WHERE pokemon_type =?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,  type);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			s_type.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString("pokemon_type")));
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return s_type;

	}

	@Override
	public int updatePokemon(Pokemon p) {
		
		int res = 0;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE Pokemon SET pokemon_name= ?, pokemon_type=? WHERE pokemonid=" + p.getPokemon_id();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getPokemon_name());
			ps.setString(2,  p.getPokemon_type());
			res = ps.executeUpdate();
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deletePokemon(Pokemon p) {
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Pokemon WHERE p_id= ?");
			ps.setInt(1, p.getPokemon_id());
			return ps.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
