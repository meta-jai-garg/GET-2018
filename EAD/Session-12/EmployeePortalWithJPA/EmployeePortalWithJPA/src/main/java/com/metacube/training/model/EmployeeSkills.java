package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeskills")
public class EmployeeSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skillid")
	private Integer skillId;
	@Column(name = "empcode")
	private Integer empCode;
	@Column(name = "skillcode")
	private Integer skillCode;

	/**
	 * @return the skillId
	 */
	public Integer getSkillId() {
		return skillId;
	}

	/**
	 * @param skillId
	 *            the skillId to set
	 */
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

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
	 * @return the skillCode
	 */
	public Integer getSkillCode() {
		return skillCode;
	}

	/**
	 * @param skillCode
	 *            the skillCode to set
	 */
	public void setSkillCode(Integer skillCode) {
		this.skillCode = skillCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeSkills [skillId=" + skillId + ", empCode=" + empCode + ", skillCode=" + skillCode + "]";
	}

}
