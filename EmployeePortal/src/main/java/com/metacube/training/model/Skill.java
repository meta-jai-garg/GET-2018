package com.metacube.training.model;

public class Skill {
	private Integer skillId;
	private String skillName;

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
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName
	 *            the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

}
