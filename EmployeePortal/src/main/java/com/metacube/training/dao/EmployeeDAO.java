package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {
	/**
	 * method to find employee
	 * @param employeeId of {@link Employee}
	 * @return
	 */
	Employee getEmployeeById(Integer employeeId);

	/**
	 * method to retrieve all employees
	 * @return list of {@link Employee}
	 */
	List<Employee> getAllEmployees();

	/**
	 * method to delete an employee
	 * @param employee is object of {@link Employee}
	 * @return true on successful deletion of employee
	 */
	boolean deleteEmployee(Employee employee);

	/**
	 * method to update an {@link Employee}
	 * @param employee is object of {@link Employee}
	 * @return
	 */
	boolean updateEmployee(Employee employee);

	/**
	 * method to create an {@link Employee}
	 * @param employee is object of {@link Employee}
	 * @return true on successful insertion of {@link Employee}
	 */
	boolean createEmployee(Employee employee);
}
