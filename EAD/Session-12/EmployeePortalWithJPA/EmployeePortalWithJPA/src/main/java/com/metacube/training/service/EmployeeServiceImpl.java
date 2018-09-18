package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return employeeRepo.findById(employeeId).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public boolean deleteEmployee(Integer empCode) {
		employeeRepo.disableEmployee(empCode);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

	@Override
	public Integer createEmployee(Employee employee) {
		return employeeRepo.save(employee).getEmpCode();
	}

	@Override
	public List<Employee> getEmployeeByName(String input) {
		return employeeRepo.findEmployeeByName("%"+input+"%");
	}

	@Override
	public List<Employee> getEmployeeByProject(Integer projectId) {
		return employeeRepo.findEmployeeByProject(projectId);
	}

	@Override
	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		return employeeRepo.findEmployeeByTotalExperience(totalExp);
	}

	@Override
	public Employee getEmployeeByEmail(String emailId) {
		return employeeRepo.findEmployeeByEmailId(emailId);
	}

	@Override
	public boolean resetPassword(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}
	
	@Override
	public List<Employee> getAllEmployeesForAdmin() {
		return employeeRepo.findAll();
	}

	@Override
	public boolean enableEmployee(Integer empCode) {
		employeeRepo.enableEmployee(empCode);
		return true;
	}
}