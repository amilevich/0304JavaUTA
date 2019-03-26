package com.project1.dao;

import com.project1.model.Users;

public interface DaoUsers {

	public int insertUser(Users user);
	
	public int updateUser(Users user);
	
	public Users validateUser(String ers_username, String ers_password);
}
