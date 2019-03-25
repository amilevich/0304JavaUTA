package com.projectone.dao;
import com.projectone.models.Users;

public interface UsersDao {

	//CREATE
	public int insertUser(Users p);
	//READ
	public Users selectUserByName(String ersUsername, String ersPassword);
	//UPDATE
	//DELETE
}
