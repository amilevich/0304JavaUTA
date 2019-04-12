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
@Table(name="Condition")
@Component
public class Condition {
	
	@Id
	@Column(name="condition_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int conditionId;
	
	@Column(name="condition")
	private String condition;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="conditions")
	private List<Doctor> doctors;

	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Condition [conditionId=" + conditionId + ", condition=" + condition + ", doctors=" + doctors + "]";
	}

	public Condition(int conditionId, String condition, List<Doctor> doctors) {
		super();
		this.conditionId = conditionId;
		this.condition = condition;
		this.doctors = doctors;
	}

	public Condition(String condition, List<Doctor> doctors) {
		super();
		this.condition = condition;
		this.doctors = doctors;
	}
	
	public Condition() {
		// TODO Auto-generated constructor stub
	}
	
	
}
