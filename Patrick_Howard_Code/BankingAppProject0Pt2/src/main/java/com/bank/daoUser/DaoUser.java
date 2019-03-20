package com.bank.daoUser;

import com.bank.model.User;

public interface DaoUser {

	public User getUser(int userId);

	public int insertUser(User u);

	public User getUserByName(String n);
}
