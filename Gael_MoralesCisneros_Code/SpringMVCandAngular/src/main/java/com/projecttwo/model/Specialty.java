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
@Table(name="Specialty")
@Component
public class Specialty {
	
	@Id
	@Column(name="specialty_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int specialtyId;
	
	@Column(name="specialty")
	private String specialty;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="specialties")
	private List<Doctor> doctors;

	public int getSpecialtyId() {
		return specialtyId;
	}

	public void setSpecialtyId(int specialtyId) {
		this.specialtyId = specialtyId;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Specialty(int specialtyId, String specialty, List<Doctor> doctors) {
		super();
		this.specialtyId = specialtyId;
		this.specialty = specialty;
		this.doctors = doctors;
	}
	
	public Specialty() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Specialty [specialtyId=" + specialtyId + ", specialty=" + specialty + ", doctors=" + doctors + "]";
	}

	public Specialty(String specialty, List<Doctor> doctors) {
		super();
		this.specialty = specialty;
		this.doctors = doctors;
	}
	
	
	
	
	

}
