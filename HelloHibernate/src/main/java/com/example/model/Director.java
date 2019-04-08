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
@Table(name="Directors")
public class Director {

	@Id
	@Column(name="dur_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int durId;
	
	@Column(name="dir_name")
	private String dirName;
	
	@OneToMany(mappedBy="direc", fetch=FetchType.LAZY)
	private List<Movie> movList;
	
	public Director() {
		// TODO Auto-generated constructor stub
	}

	public int getDurId() {
		return durId;
	}

	public void setDurId(int durId) {
		this.durId = durId;
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
		return "Director [durId=" + durId + ", dirName=" + dirName + ", movList=" + movList + "]";
	}

	public Director(int durId, String dirName, List<Movie> movList) {
		super();
		this.durId = durId;
		this.dirName = dirName;
		this.movList = movList;
	}

	public Director(String dirName) {
		super();
		this.dirName = dirName;
	}
	 
	
}
