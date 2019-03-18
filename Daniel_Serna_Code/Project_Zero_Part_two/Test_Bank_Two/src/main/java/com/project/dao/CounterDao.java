package com.project.dao;

import com.project.model.Counter;

public interface CounterDao {

	// CREATE
	public int insertCounter(Counter c); // insert customer into DB
	
	// READ
	public int grabLastHeldID();
	
	// UPDATE
	
	// DELETE
}
