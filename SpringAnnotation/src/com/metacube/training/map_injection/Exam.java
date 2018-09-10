package com.metacube.training.map_injection;

import java.util.Map;

public class Exam {

	Map<String, Double> averageMarksOfSubjects;

	/**
	 * @return the averageMarksOfSubjects
	 */
	public Map<String, Double> getAverageMarksOfSubjects() {
		return averageMarksOfSubjects;
	}

	/**
	 * @param averageMarksOfSubjects
	 *            the averageMarksOfSubjects to set
	 */
	public void setAverageMarksOfSubjects(Map<String, Double> averageMarksOfSubjects) {
		this.averageMarksOfSubjects = averageMarksOfSubjects;
	}

}
