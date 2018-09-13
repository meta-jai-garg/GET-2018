package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		Employee employee = employeeDao.getEmployeeById(id);
		return employeeDao.deleteEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		System.out.println(employee.toString());
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Integer createEmployee(Employee employee) {
		return employeeDao.createEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeByName(String input) {
		return employeeDao.getEmployeeByName(input);
	}

	@Override
	public List<Employee> getEmployeeByProject(Integer projectId) {
		return employeeDao.getEmployeeByProject(projectId);
	}

	@Override
	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		return employeeDao.getEmployeeByTotalExperience(totalExp);
	}

	@Override
	public Employee getEmployeeByEmail(String emailId) {
		return employeeDao.getEmployeeByEmail(emailId);
	}
}