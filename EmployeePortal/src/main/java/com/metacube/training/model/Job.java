package com.metacube.training.model;

public class Job {
	private Integer jobCode;
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
