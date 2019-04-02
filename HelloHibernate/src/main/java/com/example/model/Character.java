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

/*
 * ORM - Object Relational Mapping,
 * it is a technique that lets you query and 
 * manipulate data from a database using an
 * object-oriented paradigm.
 * 
 * An ORM - a library written in language of choice
 * (Java) that encapsulates the code needed to
 * manipulate the data, so you don't have to use
 * SQL anymore.
 * You interact with an object directly.
 * 
 * Hibernate - is a Java ORM and persistence
 * framework that allows you to map POJOS
 * to relational database tables.
 * 
 * It uses configuration XML files or 
 * annotations for mapping.
 * 
 */

@Entity
@Table(name = "CHARACTERS")
public class Character {

	@Id
	@Column(name = "character_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int characterId;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "motive", nullable = false)
	private String motive;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "chars")
	private List<Movie> movies;
	/*
	 * A fetching strategy is the strategy Hibernate will use for retrieving
	 * associated objects if the application needs them. LAZY and EAGER loading
	 */

	/*
	 * JPA - Java Persistence API provides a POJO persistence model for
	 * object-relational mapping. Hibernate implements the JPA API for its
	 * annotation functionality.
	 */

	public Character() {
	}

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Character [characterId=" + characterId + ", name=" + name + ", gender=" + gender + ", motive=" + motive
				+ ", movies=" + movies + "]";
	}

	public Character(int characterId, String name, String gender, String motive, List<Movie> movies) {
		super();
		this.characterId = characterId;
		this.name = name;
		this.gender = gender;
		this.motive = motive;
		this.movies = movies;
	}

	public Character(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
		choseDefaultMotive(gender);
	}

	public Character(String name, String gender, List<Movie> movies) {
		super();
		this.name = name;
		this.gender = gender;
		choseDefaultMotive(gender);
		this.movies = movies;
	}

	private void choseDefaultMotive(String gender) {
		if (gender.equals("female")) {
			this.motive = "She was a good cop...once...but " + "that was" + "when she had"
					+ "something to lose. This summer..." + this.name + " is...The Lady-Killer";
		} else {
			this.motive = "A violent criminal with a conscience... this fall..." + "get ready for...The 48 hour shower";
		}
	}

	public Character(String name, String gender, String motive, List<Movie> movies) {
		super();
		this.name = name;
		this.gender = gender;
		this.motive = motive;
		this.movies = movies;
	}

}
