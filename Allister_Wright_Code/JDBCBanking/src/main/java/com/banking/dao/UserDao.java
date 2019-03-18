package com.banking.dao;

import java.util.ArrayList;

import com.banking.user.User;

public interface UserDao
{
	// CREATE
	public abstract int registerUser(String username, String password, int typeKey, String fullName);
	
	// READ
	public abstract ArrayList<User> getAllUsers();
	public abstract User getUserByName(String username);
	public abstract User getUserLogin(String username, String password);
	
	// UPDATE
	public abstract int updatePasswordByName(String username, String password);
	
	// DELETE
	public abstract int deleteUser(String username);
}
