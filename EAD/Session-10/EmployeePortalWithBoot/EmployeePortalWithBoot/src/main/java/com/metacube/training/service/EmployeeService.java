package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {
	/**
	 * Method to find {@link Employee} by id
	 * 
	 * @param EmployeeId
	 *            id of {@link Employee}
	 * @return {@link Employee} object
	 */
	Employee getEmployeeById(Integer employeeId);

	/**
	 * Method to retrieve all {@link Employee}
	 * 
	 * @return all {@link Employee}
	 */
	List<Employee> getAllEmployees();

	/**
	 * Method to delete a {@link Employee}
	 * 
	 * @param id
	 *            of {@link Employee}
	 * @return true on successful deletion
	 */
	boolean deleteEmployee(Integer id);

	/**
	 * Method to update a {@link Employee}
	 * 
	 * @param Employee
	 *            is object of {@link Employee}
	 * @return true on successful update
	 */
	boolean updateEmployee(Employee employee);

	/**
	 * Method to create a {@link Employee}
	 * 
	 * @param Employee
	 *            is object of {@link Employee}
	 * @return id on successful insertion
	 */
	Integer createEmployee(Employee employee);

	/**
	 * Method to create a {@link Employee}
	 * 
	 * @param list of object of {@link Employee}
	 */
	List<Employee> getEmployeeByName(String input);

	List<Employee> getEmployeeByProject(Integer projectId);

	List<Employee> getEmployeeByTotalExperience(Integer totalExp);

	Employee getEmployeeByEmail(String emailId);

	boolean resetPassword(Employee employee);

	List<Employee> getAllEmployeesForAdmin();

	/**
	 * method to enable employee
	 * @param id of {@link Employee}
	 * @return true on successful enable
	 */
	boolean enableEmployee(Integer id);
}
