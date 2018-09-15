package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobtitlemaster")
public class Job {

	@Id
	@Column(name = "jobcode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobCode;
	
	@Column(name = "jobtitle")
	private String jobTitle;

	/**
	 * @return the jobCode
	 */
	public Integer getJobCode() {
		return jobCode;
	}

	/**
	 * @param jobCode
	 *            the jobCode to set
	 */
	public void setJobCode(Integer jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "Job [jobCode=" + jobCode + ", jobTitle=" + jobTitle + "]";
	}

}
