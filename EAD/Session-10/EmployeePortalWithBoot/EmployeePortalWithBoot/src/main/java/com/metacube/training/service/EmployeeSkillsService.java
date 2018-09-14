package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillsService {
	/**
	 * method to retrieve all {@link EmployeeSkills}
	 * 
	 * @return list of {@link EmployeeSkills}
	 */
	List<EmployeeSkills> getEmployeeSkills(Integer empCode);

	/**
	 * method to create an {@link EmployeeSkills}
	 * 
	 * @param EmployeeSkills
	 *            is object of {@link EmployeeSkills}
	 * @return true on successful insertion of {@link EmployeeSkills}
	 */
	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);
}
