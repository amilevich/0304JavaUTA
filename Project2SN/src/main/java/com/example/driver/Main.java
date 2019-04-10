package com.example.driver;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.UserDao;
import com.example.model.User;

public class Main {
	
	public static UserDao userDao = new UserDao();
	
	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("Done");
		
		selectByIdMethod(11);
		selectAllMethod();
		
		String myString = "Patrick";
		selectByNameMethod(myString);
	}
	
	public static void selectByIdMethod(int id) { //select Character, Director or Movie by ID, for you to extract their name, gender, etc. via the getName(), getGender() methods
		//charDao.selectById(id);
		User user1 = new User(); //Character object
		user1 = userDao.selectById(id); //returns a Character object, containing: characterId, name, gender, motive; all of which are accessed through the getCharacterId(), getName(), getGender(), getMotive()
		System.out.println(user1.getName()); //prints out the "name" string of the Character object "char1"
		
		//System.out.println(charDao.selectById(id).getName()); //you can also do this
	}
	
	public static void selectAllMethod() { //returns a List of Character objects, Director objects, or Movie objects, for you to extract data from them (name via getName(), etc)
		List<User> userList1 = new ArrayList<User>();
		userList1 = userDao.selectAll();
		User user1 = new User();
		
		user1 = userList1.get(0);
		System.out.println(user1.getMotive());
		
		//System.out.println(charList1.get(0).getMotive()); //you can also do this
	}
	
	public static void selectByNameMethod(String name) {
		
		User user1 = new User();
		user1 = userDao.selectByName(name);
		
		System.out.println(user1.getGender());
		//System.out.println(charDao.selectByName(name).getGender());
	}
	
	public static void insertInitialValues() {
		
		//characters
		User user1 = new User("Patrick", "male", "Money and to not die"); //this uses one of the 4 constructors in Character.java
		User user2 = new User("Keanu", "female", "Puppy revenge");
		
		userDao.insert(user1);
		userDao.insert(user2);
	}
	
	//view, data modeler, browser
	//relational models, new relational model, drag tables

}
