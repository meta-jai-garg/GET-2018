package com.model;

/**
 * Class to store employee details like id, name, age, email etc.
 * 
 * @author User22
 *
 */
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", age="
				+ age + "]";
	}
}
