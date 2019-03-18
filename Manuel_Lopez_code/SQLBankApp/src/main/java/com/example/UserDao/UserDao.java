package com.example.UserDao;
import java.util.List;
import com.example.User.User;

public interface UserDao {
			// CREATE
			public int insertUser(User p);
			
			// READ
			public User selectUserByName(String username, String password);
			public User selectUserByName(String username);
			//public User personalInfo(String username);
			public List<User> selectAllUsers();
			
			// UPDATE
			public int updateUser(User p);
			
			// DELETE
			public int deleteUser(User p);

			int nextSequence();

}
