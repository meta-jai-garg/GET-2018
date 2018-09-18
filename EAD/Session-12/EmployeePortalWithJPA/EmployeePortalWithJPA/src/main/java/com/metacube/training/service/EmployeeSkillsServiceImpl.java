package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {
	
	@Autowired
	private EmployeeSkillsRepository empSkillRepo;

	@Override
	public List<EmployeeSkills> getEmployeeSkills(Integer skillCode) {
		return empSkillRepo.findEmployeeSkillsBySkillCode(skillCode);
	}

	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		empSkillRepo.save(employeeSkills);
		return true;
	}

	@Override
	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		return empSkillRepo.findEmployeeSkillsByEmpCode(empCode);
	}
}
