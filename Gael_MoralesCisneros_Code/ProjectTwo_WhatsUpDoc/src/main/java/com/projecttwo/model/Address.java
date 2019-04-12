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

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipcode")
	private int zipcode;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "docaddress")
	private List<Doctor> doctors;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "useraddress")
	private List<Patient> users;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Patient> getUsers() {
		return users;
	}

	public void setUsers(List<Patient> users) {
		this.users = users;
	}

	public Address(int addressId, String street, String city, String state, int zipcode, List<Doctor> doctors,
			List<Patient> users) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.doctors = doctors;
		this.users = users;
	}
	
	public Address() {
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + ", doctors=" + doctors + ", users=" + users + "]";
	}

	public Address(String street, String city, String state, int zipcode, List<Doctor> doctors, List<Patient> users) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.doctors = doctors;
		this.users = users;
	}

	
	
}
