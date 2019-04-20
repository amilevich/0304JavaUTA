package com.projecttwo.model;

import java.util.List;

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

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Doctor")
@Component
public class Doctor {

	@Id
	@Column(name = "doctor_id", unique = true, nullable = false)
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
	private String ssN;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "medical_id")
	private String medicalId;

	@Column(name = "gender")
	private String gender;

	@Column(name = "affiliation")
	private String affiliation;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "street2")
	private String street2;

	@Column(name = "city2")
	private String city2;

	@Column(name = "state2")
	private String state2;

	@Column(name = "zipcode2")
	private String zipcode2;

	@Column(name = "experience")
	private int experience;

	@Column(name = "certification")
	private String certification;

	@Column(name = "education")
	private String education;
	
	@Column(name = "profilepic")
	private String profilepic;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialty_id")
	private List<Specialty> specialties;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "condition_id")
	private List<Condition> conditions;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id")
	private List<Language> languages;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "procedure_id")
	private List<Procedure> procedures;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "insurance_id")
	private List<Insurance> insurances;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private List<Appointment> appointments;

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

	public String getSsN() {
		return ssN;
	}

	public void setSsN(String ssN) {
		this.ssN = ssN;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public String getState2() {
		return state2;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public String getZipcode2() {
		return zipcode2;
	}

	public void setZipcode2(String zipcode2) {
		this.zipcode2 = zipcode2;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
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

	public String getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	public Doctor(int doctorId, String firstName, String lastName, String userName, String passWord, String ssN, String phone,
			String email, String medicalId, String gender, String affiliation, String street, String city, String state,
			String zipcode, String street2, String city2, String state2, String zipcode2, int experience,
			String certification, String education, List<Specialty> specialties, List<Condition> conditions,
			List<Language> languages, List<Procedure> procedures, List<Insurance> insurances,
			List<Appointment> appointments, String profilepic) {
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
		this.gender = gender;
		this.affiliation = affiliation;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.street2 = street2;
		this.city2 = city2;
		this.state2 = state2;
		this.zipcode2 = zipcode2;
		this.experience = experience;
		this.certification = certification;
		this.education = education;
		this.specialties = specialties;
		this.conditions = conditions;
		this.languages = languages;
		this.procedures = procedures;
		this.insurances = insurances;
		this.appointments = appointments;
		this.profilepic = profilepic;
	}

	public Doctor(String firstName, String lastName, String userName, String passWord, String ssN, String phone, String email,
			String medicalId, String gender, String affiliation, String street, String city, String state, String zipcode,
			String street2, String city2, String state2, String zipcode2, int experience, String certification,
			String education, List<Specialty> specialties, List<Condition> conditions, List<Language> languages,
			List<Procedure> procedures, List<Insurance> insurances, List<Appointment> appointments, String profilepic) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.ssN = ssN;
		this.phone = phone;
		this.email = email;
		this.medicalId = medicalId;
		this.gender = gender;
		this.affiliation = affiliation;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.street2 = street2;
		this.city2 = city2;
		this.state2 = state2;
		this.zipcode2 = zipcode2;
		this.experience = experience;
		this.certification = certification;
		this.education = education;
		this.specialties = specialties;
		this.conditions = conditions;
		this.languages = languages;
		this.procedures = procedures;
		this.insurances = insurances;
		this.appointments = appointments;
		this.profilepic = profilepic;
	}
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWord=" + passWord + ", ssN=" + ssN + ", phone=" + phone + ", email=" + email
				+ ", medicalId=" + medicalId + ", gender=" + gender + ", affiliation=" + affiliation + ", street="
				+ street + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", street2=" + street2
				+ ", city2=" + city2 + ", state2=" + state2 + ", zipcode2=" + zipcode2 + ", experience=" + experience
				+ ", certification=" + certification + ", education=" + education + ", profilepic=" + profilepic
				+"]";
	}

	public Doctor(String firstName, String lastName, String userName, String passWord, String medicalId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.medicalId = medicalId;
	}

	public Doctor(String firstName, String lastName, String userName, String passWord, String medicalId,
			String street, String city, String state, String zipcode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.medicalId = medicalId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
}