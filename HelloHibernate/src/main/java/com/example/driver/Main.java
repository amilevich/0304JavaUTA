package com.example.driver;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.CharacterDao;
import com.example.dao.DirectorDao;
import com.example.dao.MovieDao;
import com.example.model.Director;
import com.example.model.Movie;
import com.example.model.Character;

public class Main {

	public static CharacterDao cDao = new CharacterDao();
	public static MovieDao mDao = new MovieDao();
	public static DirectorDao dDao = new DirectorDao();
	
	/*
	 * Hibernate exceptions are runtime exceptions that encapsulate
	 * 	JDBC exceptions. If an exception is thrown, the transactions
	 * 	are rolled back.
	 */
	public static void main(String[] args) {

		insertInitialValues();
		System.out.println("done");
	}
	
	public static void insertInitialValues() {
		//directors
		Director dir1 = new Director("Jay");
		Director dir2 = new Director("Yousef");
		Director dir3 = new Director("Soy Sauce");
		Director dir4 = new Director("Allister");
		Director dir5 = new Director("Meme");

		dDao.insert(dir1);
		dDao.insert(dir2);
		dDao.insert(dir3);
		dDao.insert(dir4);
		dDao.insert(dir5);
		
		//movies
		Movie mov1 = new Movie("donkey kong movie","best cgi movie", dir1);
		Movie mov2 = new Movie("dune","um revenge of the profit", dir2);
		Movie mov3 = new Movie("toy story 2: the awakening","toys come to life...", dir4);
		Movie mov4 = new Movie("manatea","no... just no, a mockumentary", dir3);
		mDao.insert(mov1);
		mDao.insert(mov2);
		mDao.insert(mov3);
		mDao.insert(mov4);
		
		List<Movie> movList = new ArrayList<>();
		movList.add(mov2);
		movList.add(mov1);
		movList.add(mov3);
		movList.add(mov4);
		
		//characters
		Character char1 = new Character("Patrick-shz","male","moneyz and also to not die",movList);
		Character char2 = new Character("Keanu","male","puppy revenge",movList);
		
		cDao.insert(char1);
		cDao.insert(char2);
		
		
	}

}
