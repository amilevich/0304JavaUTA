package com.projecttwo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Appointment")
@Component
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;

	@Column(name = "time", nullable = false)
	private double time;

	@Column(name = "dom", nullable = false)
	private int dom;

	@Column(name = "type", nullable = false)
	private String type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Patient user;

	public Appointment() {
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getDom() {
		return dom;
	}

	public void setDom(int dom) {
		this.dom = dom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getUser() {
		return user;
	}

	public void setUser(Patient user) {
		this.user = user;
	}

	public Appointment(int appointmentId, double time, int dom, String type, Doctor doctor, Patient user) {
		super();
		this.appointmentId = appointmentId;
		this.time = time;
		this.dom = dom;
		this.type = type;
		this.doctor = doctor;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", time=" + time + ", dom=" + dom + ", type=" + type
				+ ", doctor=" + doctor + ", user=" + user + "]";
	}

	public Appointment(double time, int dom, String type, Doctor doctor, Patient user) {
		super();
		this.time = time;
		this.dom = dom;
		this.type = type;
		this.doctor = doctor;
		this.user = user;
	}

}
