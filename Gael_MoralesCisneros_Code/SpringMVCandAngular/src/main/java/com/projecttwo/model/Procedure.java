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
@Table(name="Procedure")
@Component
public class Procedure {
	
	@Id
	@Column(name="procedure_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int procedureId;
	
	@Column(name="procedure")
	private String procedure;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="procedures")
	private List<Doctor> doctors;

	public int getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(int procedureId) {
		this.procedureId = procedureId;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Procedure [procedureId=" + procedureId + ", procedure=" + procedure + ", doctors=" + doctors + "]";
	}

	public Procedure(int procedureId, String procedure, List<Doctor> doctors) {
		super();
		this.procedureId = procedureId;
		this.procedure = procedure;
		this.doctors = doctors;
	}
	
	public Procedure() {
		// TODO Auto-generated constructor stub
	}

	public Procedure(String procedure, List<Doctor> doctors) {
		super();
		this.procedure = procedure;
		this.doctors = doctors;
	}
	
	
	
	

}
