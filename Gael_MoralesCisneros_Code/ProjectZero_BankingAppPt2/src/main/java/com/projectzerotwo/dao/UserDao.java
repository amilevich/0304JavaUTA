package com.projectzerotwo.dao;

import java.util.List;

import com.projectzerotwo.model.User;

public interface UserDao {

	//create
	public int insertUser(User u);

	//read
	public User selectUserByUsername(String username);
	public List<User> selectAllUsers();
	public Integer selectAccNumByMax();
	public User selectUserByAccountNum(Integer accNumber);
	
	//update
	public int updateUser(User u);
	
	//delete
	public int deleteUser(User u);
	
}
