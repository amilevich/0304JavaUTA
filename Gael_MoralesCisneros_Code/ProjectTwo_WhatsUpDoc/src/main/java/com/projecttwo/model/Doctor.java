package com.projecttwo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor {

	@Id
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String passWord;

	@Column(name = "ssn")
	private int ssN;

	@Column(name = "phone")
	private int phone;

	@Column(name = "email")
	private String email;

	@Column(name = "medical_id")
	private String medicalId;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private List<Address> docaddress;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialty_id")
	private List<Specialty> specialties;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "condition_id")
	private List<Condition> conditions;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "procedure_id")
	private List<Procedure> procedures;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "insurance_id")
	private List<Insurance> insurances;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="doctor")
	private List<Appointment> appointments;

	public Doctor(int doctorId, String firstName, String lastName, String userName, String passWord, int ssN,
			int phone, String email, String medicalId, List<Address> address, List<Specialty> specialties,
			List<Condition> conditions, List<Procedure> procedures, List<Insurance> insurances,
			List<Appointment> appointments) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.ssN = ssN;
		this.phone = phone;
		this.email = email;
		this.medicalId = medicalId;
		this.docaddress = address;
		this.specialties = specialties;
		this.conditions = conditions;
		this.procedures = procedures;
		this.insurances = insurances;
		this.appointments = appointments;
	}

	public Doctor(String firstName, String lastName, String userName, String passWord, int ssN, int phone, String email,
			String medicalId, List<Address> address, List<Specialty> specialties, List<Condition> conditions,
			List<Procedure> procedures, List<Insurance> insurances, List<Appointment> appointments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.ssN = ssN;
		this.phone = phone;
		this.email = email;
		this.medicalId = medicalId;
		this.docaddress = address;
		this.specialties = specialties;
		this.conditions = conditions;
		this.procedures = procedures;
		this.insurances = insurances;
		this.appointments = appointments;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getSsN() {
		return ssN;
	}

	public void setSsN(int ssN) {
		this.ssN = ssN;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(String medicalId) {
		this.medicalId = medicalId;
	}

	public List<Address> getAddress() {
		return docaddress;
	}

	public void setAddress(List<Address> address) {
		this.docaddress = address;
	}

	public List<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWord=" + passWord + ", ssN=" + ssN + ", phone=" + phone + ", email=" + email
				+ ", medicalId=" + medicalId + ", address=" + docaddress + ", specialties=" + specialties + ", conditions="
				+ conditions + ", procedures=" + procedures + ", insurances=" + insurances + ", appointments="
				+ appointments + "]";
	}
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

}
