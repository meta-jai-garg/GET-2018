package com.facade;

import java.util.List;

import com.dao.EmployeeDAO;
import com.enums.Status;
import com.model.Employee;

public class EmployeeFacade {
	private static EmployeeFacade employeeFacade = new EmployeeFacade();
	private EmployeeDAO dao = EmployeeDAO.getInstance();

	public static EmployeeFacade getInstance() {
		return employeeFacade;
	}

	public Status authenticateEmployee(String email, String password) {
		Employee emp = getEmployee(email);
		if (emp != null) {
			if (emp.getPassword().equals(password)) {
				return Status.OK;
			} else {
				return Status.ERROR;
			}
		} else {
			return Status.NOT_FOUND;
		}
	}

	public Status addEmployee(Employee employee) {
		int result = 0;
		if (employee != null) {
			result = dao.addEmployee(employee);
		}
		if (result == 1) {
			return Status.CREATED;
		} else if (result == -1) {
			return Status.DUPLICATE;
		} else {
			return Status.ERROR;
		}
	}

	public Employee getEmployee(String email) {
		return dao.getEmployee(email);
	}

	public List<Employee> getEmployee(String organization, String email) {
		return dao.getEmployee(organization, email);
	}
}