package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Integer>{
	List<EmployeeSkills> findEmployeeSkillsByEmpCode(Integer empCode);
	List<EmployeeSkills> findEmployeeSkillsBySkillCode(Integer skillCode);
}
