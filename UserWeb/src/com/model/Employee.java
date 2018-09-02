package com.model;

import java.sql.Date;

public class Employee {
	private String firstName, lastName, mobile, email, password, organization;
	private Date dob;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getOrganization() {
		return organization;
	}

	public Date getDob() {
		return dob;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", mobile=" + mobile + ", email=" + email + ", password="
				+ password + ", organization=" + organization + ", dob=" + dob
				+ ", age=" + age + "]";
	}
}