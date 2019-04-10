package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//You use these @'s to create tables in SQL instead of implementing the DAO design pattern
//map Character being to a table

@Entity //Import this from javax.persistence.Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="user_id") //creates a column in SQL
	@GeneratedValue(strategy = GenerationType.AUTO) //Use this instead of the DAO ?,?,? part
	private int userId;
	
	@Column(name="name", unique=true, nullable=false) //Notice you don't need semi-colons at the end
	private String name;
	
	@Column(name="gender", nullable=false)
	private String gender;
	
	@Column(name="motive", nullable=false)
	private String motive;
	
	public User() { //constructor
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	/*

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	*/

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", gender=" + gender + ", motive=" + motive + "]";
	}

	public User(int userId, String name, String gender, String motive) { //constructor
		super();
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.motive = motive;
		choseDefaultMotive(gender);
	}

	public User(String name, String gender) { //constructor
		super();
		this.name = name;
		this.gender = gender;
		choseDefaultMotive(gender);
	}
	
	private void choseDefaultMotive(String gender) {
		if(gender.equals("female")) {
			this.motive = "She was a good cop";
		} else {
			this.motive = "A violent criminal";
		}
	}

	public User(String name, String gender, String motive) { //constructor
		super();
		this.name = name;
		this.gender = gender;
		this.motive = motive;
	}
	
	
}
