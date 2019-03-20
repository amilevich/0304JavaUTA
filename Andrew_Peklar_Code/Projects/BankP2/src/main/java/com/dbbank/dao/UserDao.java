package com.dbbank.dao;

import java.util.List;

import com.dbbank.model.Users;

public interface UserDao {
	// CREATE
	public int insertUsers(Users u);
	public int unregisteredUser(String username, String Password);
	
	// READ
	public Users selectUserByName(String userName, String userPass);
	public Users selectUserByID(Integer UID);
	
	// READ ALLL
	public List<Users> selectAllUsers();
	
	// UPDATE
	public int updateUser(Users u);
	
	// DELETE
	public int deleteUser(Users u);
}
