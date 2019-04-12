package com.projecttwo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.projecttwo.model.Address;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

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

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private int phone;

	@Column(name = "email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address useraddress;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Address getAddress() {
		return useraddress;
	}

	public void setAddress(Address address) {
		this.useraddress = address;
	}

	public Patient() {
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWord=" + passWord + ", ssN=" + ssN + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", address=" + useraddress + "]";
	}

	public Patient(int userId, String firstName, String lastName, String userName, String passWord, int ssN, String gender,
			int phone, String email, Address address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.ssN = ssN;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.useraddress = address;
	}

	public Patient(String firstName, String lastName, String userName, String passWord, int ssN, String gender, int phone,
			String email, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.ssN = ssN;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.useraddress = address;
	}

}
