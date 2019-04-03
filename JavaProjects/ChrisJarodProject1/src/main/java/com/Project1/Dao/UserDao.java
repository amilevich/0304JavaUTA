package com.Project1.Dao;

import java.util.List;

import com.Project1.Model.User;


public interface UserDao {
	public int insertUser(User u);
	
	public User selectUserByUsername(String username);
	public User selectUserByUserId(int userId);
	public List<User> selectAllUsers();
	
	public int returnMaxUserId();
	
}
