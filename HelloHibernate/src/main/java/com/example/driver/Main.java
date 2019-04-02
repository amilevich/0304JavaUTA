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

	public static CharacterDao charDao = new CharacterDao();
	public static MovieDao movDao = new MovieDao();
	public static DirectorDao dircDao = new DirectorDao();
	
	/*
	 * Hibernate exceptions are runtime exceptions
	 * that encapsulte JDBC exceptions.
	 * If an exception is thrown, the transactions
	 * are rolled back
	 */
	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("done");
	}
	
	public static void insertInitialValues() {
		// directors
		Director dirc1 = new Director("Jay");
		Director dirc2 = new Director("Yousef");
		Director dirc3 = new Director("Soy Sauce");
		Director dirc4 = new Director("Allister");
		Director dirc5 = new Director("Meme");
		
		dircDao.insert(dirc1);
		dircDao.insert(dirc2);
		dircDao.insert(dirc3);
		dircDao.insert(dirc4);
		dircDao.insert(dirc5);
		
		// movies
		Movie mov1 = new Movie("donkey kong movie","best cgi movie", dirc1);
		Movie mov2 = new Movie("dune","um revenge of the profit", dirc2);
		Movie mov3 = new Movie("toy story 2: the awakening","toys come to life...", dirc4);
		Movie mov4 = new Movie("manatea","no... just no, a mockumentary", dirc3);
		movDao.insert(mov1);
		movDao.insert(mov2);
		movDao.insert(mov3);
		movDao.insert(mov4);
		
	
		List<Movie> movList = new ArrayList<>();
		movList.add(mov2);
		movList.add(mov1);
		movList.add(mov3);
		movList.add(mov4);
		//characters
		Character char1 = new Character("Patrick-shz", "male", "moneyz and also, to not die", movList);
		Character char2 = new Character("Keanu", "male", "puppy revenge", movList);
		
		charDao.insert(char1);
		charDao.insert(char2);

	}

}
