package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Directors")
public class Director {
	
	@Id
	@Column(name = "dir_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dirId;
	
	@Column(name = "dir_name")
	private String dirName;
	
	@OneToMany(mappedBy = "direc", fetch = FetchType.LAZY)
	private List<Movie> movList;
	
	public Director() {
	}

	public int getDirId() {
		return dirId;
	}

	public void setDirId(int dirId) {
		this.dirId = dirId;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public List<Movie> getMovList() {
		return movList;
	}

	public void setMovList(List<Movie> movList) {
		this.movList = movList;
	}

	@Override
	public String toString() {
		return "Director [dirId=" + dirId + ", dirName=" + dirName + ", movList=" + movList + "]";
	}

	public Director(int dirId, String dirName, List<Movie> movList) {
		super();
		this.dirId = dirId;
		this.dirName = dirName;
		this.movList = movList;
	}

	public Director(String dirName) {
		super();
		this.dirName = dirName;
	}

	public Director(int dirId, String dirName) {
		super();
		this.dirId = dirId;
		this.dirName = dirName;
	}
	
	
	
	

}
