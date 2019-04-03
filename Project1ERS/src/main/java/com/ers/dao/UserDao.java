package com.ers.dao;

import java.util.ArrayList;

import com.ers.model.Ticket;
import com.ers.model.User;

public interface UserDao {
	
	//CREATE
	public int insertUser(User u);
		
	//READ
	public ArrayList<User> selectAllUsers(); 
	public User selectUserByUsername(String username);

}
