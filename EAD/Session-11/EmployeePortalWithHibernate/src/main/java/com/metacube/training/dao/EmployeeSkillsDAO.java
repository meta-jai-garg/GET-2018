package com.metacube.training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkills;

@Transactional
public interface EmployeeSkillsDAO {
	/**
	 * method to retrieve all {@link EmployeeSkills}
	 * 
	 * @return list of {@link EmployeeSkills}
	 */
	List<EmployeeSkills> getEmployeeSkills(Integer skillCode);

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