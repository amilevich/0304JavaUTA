package com.dbbank.dao;

import java.util.List;

import com.dbbank.model.Users;

public interface UserDao {
	// CREATE
	public int insertUsers(Users u);
	
	// READ
	public Users selectUserByName(String userName, String userPass);
	
	// READ ALLL
	public List<Users> selectAllUsers();
	
	// UPDATE
	public int updateUser(Users u);
	
	// DELETE
	public int deleteUser(Users u);
}
