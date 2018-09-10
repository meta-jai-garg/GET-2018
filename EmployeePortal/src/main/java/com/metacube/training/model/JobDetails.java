package com.metacube.training.model;

import java.sql.Date;

public class JobDetails {
	private Integer empCode, jobDetailId;
	private Date dateOfJoining;
	private Integer totalExp, jobCode, reportingManager, teamLead, currProjId;

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
	 * @return the jobDetailId
	 */
	public Integer getJobDetailId() {
		return jobDetailId;
	}

	/**
	 * @param jobDetailId
	 *            the jobDetailId to set
	 */
	public void setJobDetailId(Integer jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining
	 *            the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the totalExp
	 */
	public Integer getTotalExp() {
		return totalExp;
	}

	/**
	 * @param totalExp
	 *            the totalExp to set
	 */
	public void setTotalExp(Integer totalExp) {
		this.totalExp = totalExp;
	}

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
	 * @return the reportingManager
	 */
	public Integer getReportingManager() {
		return reportingManager;
	}

	/**
	 * @param reportingManager
	 *            the reportingManager to set
	 */
	public void setReportingManager(Integer reportingManager) {
		this.reportingManager = reportingManager;
	}

	/**
	 * @return the teamLead
	 */
	public Integer getTeamLead() {
		return teamLead;
	}

	/**
	 * @param teamLead
	 *            the teamLead to set
	 */
	public void setTeamLead(Integer teamLead) {
		this.teamLead = teamLead;
	}

	/**
	 * @return the currProjId
	 */
	public Integer getCurrProjId() {
		return currProjId;
	}

	/**
	 * @param currProjId
	 *            the currProjId to set
	 */
	public void setCurrProjId(Integer currProjId) {
		this.currProjId = currProjId;
	}

	@Override
	public String toString() {
		return "JobDetails [empCode=" + empCode + ", jobDetailId=" + jobDetailId + ", dateOfJoining=" + dateOfJoining
				+ ", totalExp=" + totalExp + ", jobCode=" + jobCode + ", reportingManager=" + reportingManager
				+ ", teamLead=" + teamLead + ", currProjId=" + currProjId + "]";
	}
}