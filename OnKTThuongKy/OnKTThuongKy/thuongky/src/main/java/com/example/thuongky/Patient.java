package com.example.thuongky;

import java.util.List;

public class Patient {
    private String _id;
    private String first_name;
    private String last_name;
    private String blood_type;
    private String gender;
    private Address address;
    private List<String> telephones;
    private List<Test> tests;
    private int year_of_birth;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	public int getYear_of_birth() {
		return year_of_birth;
	}
	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}
	public Patient(String _id, String first_name, String last_name, String blood_type, String gender, Address address,
			List<String> telephones, List<Test> tests, int year_of_birth) {
		super();
		this._id = _id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.blood_type = blood_type;
		this.gender = gender;
		this.address = address;
		this.telephones = telephones;
		this.tests = tests;
		this.year_of_birth = year_of_birth;
	}
	public Patient() {
		super();
	}
    
    

    // Constructors, getters, and setters
}