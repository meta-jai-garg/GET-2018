package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empcode")
	private Integer empCode;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "priamrycontact")
	private String primaryContact;
	@Column(name = "secondarycontact")
	private String secondaryContact=null;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "skypeid")
	private String skypeId=null;
	@Column(name = "profilepicture")
	private String profilePicture=null;
	@Column(name = "password")
	private String password="123456";
	@Column(name = "isactive")
	private Boolean isActive=true;

	/**
	 * @return the empCode
	 */
	public Integer getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode
	 *            the empCode to set
	 */
	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the primaryContact
	 */
	public String getPrimaryContact() {
		return primaryContact;
	}

	/**
	 * @param primaryContact
	 *            the primaryContact to set
	 */
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	/**
	 * @return the secondaryContact
	 */
	public String getSecondaryContact() {
		return secondaryContact;
	}

	/**
	 * @param secondaryContact
	 *            the secondaryContact to set
	 */
	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the skypeId
	 */
	public String getSkypeId() {
		return skypeId;
	}

	/**
	 * @param skypeId
	 *            the skypeId to set
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture
	 *            the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", primaryContact=" + primaryContact + ", secondaryContact=" + secondaryContact
				+ ", emailId=" + emailId + ", skypeId=" + skypeId + ", profilePicture=" + profilePicture + ", password="
				+ password + ", isActive=" + isActive + "]";
	}
}