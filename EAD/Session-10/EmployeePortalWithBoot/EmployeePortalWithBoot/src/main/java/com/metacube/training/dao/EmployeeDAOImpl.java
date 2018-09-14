package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_ALL_FOR_EMPLOYEE = "SELECT *FROM employee";
	private final String SQL_GET_LAST_ID = "SELECT * FROM employee ORDER BY empCode DESC LIMIT 1";
	private final String SQL_GET_ALL = "SELECT *FROM employee where isActive=1";
	private final String SQL_FIND_EMPLOYEE_BY_EMAIL = "select * from employee where emailId = ?";
	private final String SQL_FIND_EMPLOYEE_BY_ID = "select * from employee where empCode = ?";
	private final String SQL_FIND_EMPLOYEE_BY_NAME = "select *from employee WHERE CONCAT(firstName,' ',lastName) LIKE ? AND isActive=1";
	private final String SQL_FIND_EMPLOYEE_BY_PROJECT = "select * from employee where empCode IN (select empCode from jobDetails where currProjId=?) AND isActive=1";
	// private final String SQL_FIND_EMPLOYEE_BY_SKILLS =
	// "select * from jobtitlemaster where jobCode = ?";
	private final String SQL_FIND_EMPLOYEE_BY_EXPERIENCE = "select * from employee where empCode IN (select empCode from jobDetails where totalExp >= ?) AND isActive=1;";
	private final String SQL_DISABLE_EMPLOYEE = "update employee set isActive=0 where empCode=?";
	private final String SQL_ENABLE_EMPLOYEE = "update employee set isActive=1 where empCode=?";
	private final String SQL_INSERT_EMPLOYEE = "insert into employee(firstName, lastName, dob, gender, priamryContact, emailId) values(?,?,?,?,?,?)";
	private final String SQL_UPDATE_EMPLOYEE = "update employee set priamryContact=?, secondaryContact=? where empCode=?";
	private final String SQL_RESET_PASSWORD = "UPDATE employee SET password=? WHERE empCode=?";

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE_BY_ID,
				new Object[] { employeeId }, new EmployeeMapper());
	}

	@Override
	public boolean resetPassword(Employee employee) {
		return jdbcTemplate.update(SQL_RESET_PASSWORD, employee.getPassword(),
				employee.getEmpCode()) > 0;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployeesForAdmin() {
		return jdbcTemplate.query(SQL_GET_ALL_FOR_EMPLOYEE,
				new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_DISABLE_EMPLOYEE, employee.getEmpCode()) > 0;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,
				employee.getPrimaryContact(), employee.getSecondaryContact(),
				employee.getEmpCode()) > 0;
	}

	@Override
	public Integer createEmployee(Employee employee) {
		jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getFirstName(),
				employee.getLastName(), employee.getDob(),
				employee.getGender(), employee.getPrimaryContact(),
				employee.getEmailId());
		Employee employeeForLastId = jdbcTemplate.queryForObject(
				SQL_GET_LAST_ID, new EmployeeMapper());
		Integer empCode = employeeForLastId.getEmpCode();
		return empCode;
	}

	@Override
	public List<Employee> getEmployeeByName(String input) {
		return jdbcTemplate.query(SQL_FIND_EMPLOYEE_BY_NAME, new Object[] { "%"
				+ input + "%" }, new EmployeeMapper());
	}

	@Override
	public List<Employee> getEmployeeByProject(Integer projectId) {
		return jdbcTemplate.query(SQL_FIND_EMPLOYEE_BY_PROJECT,
				new Object[] { projectId }, new EmployeeMapper());
	}

	@Override
	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		return jdbcTemplate.query(SQL_FIND_EMPLOYEE_BY_EXPERIENCE,
				new Object[] { totalExp }, new EmployeeMapper());
	}

	@Override
	public Employee getEmployeeByEmail(String emailId) {
		try {
			Employee employee = jdbcTemplate.queryForObject(
					SQL_FIND_EMPLOYEE_BY_EMAIL, new Object[] { emailId },
					new EmployeeMapper());
			return employee;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean enableEmployee(Integer id) {
		return jdbcTemplate.update(SQL_ENABLE_EMPLOYEE, id) > 0;
	}
}