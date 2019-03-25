package com.reimb.dao;

import java.util.List;

import com.reimb.model.Users;

public interface UsersDao {

	//READ
	public List<Users> selectAllUsers();
	public Users selectUserById(int id);
	
}
