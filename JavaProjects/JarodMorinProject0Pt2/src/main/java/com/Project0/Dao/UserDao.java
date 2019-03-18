package com.Project0.Dao;

import com.Project0.Bank.User;

public interface UserDao {
	
	public int addUser(User acc);
	public int addEmployee(User acc);
	public int addAdmin(User acc);
}
