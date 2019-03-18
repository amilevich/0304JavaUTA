package com.project.dao;

import java.util.List;

import com.project.model.Junction;

public interface JunctionDao {

	// CREATE
	public int insertJunction(Junction j); // insert account into DB
		
	// READ
	public Junction selectJunctionByID(int id); 
	public Junction selectJunctionByUsername(String user); 
	public List<Junction> selectAllJunctions(); // select (DISPLAY) all accounts
	
	// UPDATE
	public int updateJunction(Junction j); 
		
	// DELETE
	public void deleteJunction(int id);
}
