package com.example.dao;

import java.util.List;


import com.example.model.User;

public interface UserDao {
	
	public int insertUser(User u);
	
	public int updateUser(User u);
	
	public List<User> selectAllUsers(); 
	
	public User selectUserByUsername(String userName);
	
	public User selectUserByAcctNum(Integer AccNumUser);
	
	public int getAccNumByUserName(String userName);
	
	
	

	
	
	

}
