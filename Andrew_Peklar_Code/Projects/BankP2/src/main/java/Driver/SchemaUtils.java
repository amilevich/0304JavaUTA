package Driver;

import com.dbbank.dao.UserDaoImpl;
import com.dbbank.model.Users;
import com.dbbank.dao.*;
import com.dbbank.model.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

public class SchemaUtils {
	
	public static Users currentUser;
	public static Users loggedInUser;
	
	public static void insertUser(String b, String c) {
		int rand = (int)Math.random();
		Users one = new Users(rand, b, c, 0);
		UserDaoImpl ume = new UserDaoImpl();
		ume.insertUsers(one);
		currentUser = ume.selectUserByName(b, c);
	}
	
	public static void viewUsers() {
		UserDaoImpl ume = new UserDaoImpl();
		ume.selectAllUsers().forEach(System.out::println);
	}
	
	public static boolean UserLoginCheck(String name, String pass) {
		return new UserDaoImpl().selectAllUsers().stream()
								.anyMatch(o ->	o.getUserName().equals(name) 
											 && o.getUserPass().equals(pass));
	}
	
	public static Users setUser(String us, String ps) {
		return currentUser = new UserDaoImpl().selectUserByName(us, ps);
	}
	
	public static Users getUser() {
		return currentUser;
	}
	
	public static int UserType() {
		return currentUser.getUserID();
	}

}
