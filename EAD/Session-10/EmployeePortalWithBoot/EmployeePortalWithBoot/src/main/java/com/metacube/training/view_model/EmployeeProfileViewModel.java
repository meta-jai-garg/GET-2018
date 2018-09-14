package com.metacube.training.view_model;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.metacube.training.model.Skill;

public class EmployeeProfileViewModel {
	private Integer empCode;
	private String firstName;
	private String lastName;
	private Date dob;
	private String primaryContact;
	private String emailId;
	private String description;
	private Date endDate;
	private List<Skill> skills;
	private String reportingManager, teamLead;
	private String address, city, state, pincode;

	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "EmployeeProfileViewModel [empCode=" + empCode + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", primaryContact=" + primaryContact + ", emailId=" + emailId
				+ ", description=" + description + ", endDate=" + endDate
				+ ", skills=" + skills + ", reportingManager="
				+ reportingManager + ", teamLead=" + teamLead + ", address="
				+ address + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
}