package project0.dao;

import java.util.ArrayList;
import java.util.List;

import project0.users.User;

public interface UserDao {
	
	//CREATE
	public boolean insertUser(User u);
	
	//READ
	public User selectUserByUsername(String username);
	public User login(String username, String password);
	public ArrayList<User> selectAllCustomers();
	public ArrayList<User> selectAllCustomers(ArrayList<String> usernames);
	
	//DELETE
	public boolean deleteUser(String usename);

	int nextSequence();
}
