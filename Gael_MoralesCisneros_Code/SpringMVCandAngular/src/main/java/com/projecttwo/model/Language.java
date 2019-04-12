package com.projecttwo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Language")
@Component
public class Language {
	
	@Id
	@Column(name="language_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int languageId;
	
	@Column(name="language")
	private String language;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="languages")
	private List<Doctor> doctors;
	
	public Language() {
	}

	public Language(int languageId, String language, List<Doctor> doctors) {
		super();
		this.languageId = languageId;
		this.language = language;
		this.doctors = doctors;
	}

	public Language(String language, List<Doctor> doctors) {
		super();
		this.language = language;
		this.doctors = doctors;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", language=" + language + ", doctors=" + doctors + "]";
	}
	
	
}


