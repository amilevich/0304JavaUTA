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
@Table(name="Insurance")
@Component
public class Insurance {
	
	@Id
	@Column(name="insurance_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int insuranceId;
	
	@Column(name = "insurance")
	private String insurance;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="insurances")
	private List<Doctor> doctors;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", insurance=" + insurance + ", doctors=" + doctors + "]";
	}

	public Insurance(int insuranceId, String insurance, List<Doctor> doctors) {
		super();
		this.insuranceId = insuranceId;
		this.insurance = insurance;
		this.doctors = doctors;
	}

	public Insurance(String insurance, List<Doctor> doctors) {
		super();
		this.insurance = insurance;
		this.doctors = doctors;
	}
	
	public Insurance() {
		// TODO Auto-generated constructor stub
	}
	
	

}
