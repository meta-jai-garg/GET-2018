package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeSkillsDAOImpl;
import com.metacube.training.model.EmployeeSkills;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

	@Autowired
	private EmployeeSkillsDAOImpl employeeSkillDao;

	@Override
	public List<EmployeeSkills> getEmployeeSkills(Integer empCode) {
		return employeeSkillDao.getEmployeeSkills(empCode);
	}

	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		return employeeSkillDao.createEmployeeSkills(employeeSkills);
	}
	
	@Override
	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		return employeeSkillDao.getSkillsOfEmployee(empCode);
	}

}
