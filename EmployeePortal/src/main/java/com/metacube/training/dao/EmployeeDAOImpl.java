package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	private final String SQL_FIND_EMPLOYEE_BY_ID = "select * from employee empCode=?";
	private final String SQL_FIND_EMPLOYEE_BY_NAME = "select * from jobtitlemaster where jobCode = ?";
	private final String SQL_FIND_EMPLOYEE_BY_PROJECT = "select * from jobtitlemaster where jobCode = ?";
	private final String SQL_FIND_EMPLOYEE_BY_SKILLS = "select * from jobtitlemaster where jobCode = ?";
	private final String SQL_FIND_EMPLOYEE_BY_EXPERIENCE = "select * from jobtitlemaster where jobCode = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from jobtitlemaster where jobCode = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update jobtitlemaster set jobTitle = ? where jobCode = ?";
	private final String SQL_INSERT_EMPLOYEE = "insert into jobtitlemaster(firstName, lastName, dob, gender, primaryContact, secondaryContact, emailId, skypeId, profilePicture, password, isActive) values(?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE_BY_ID, new Object[] { employeeId }, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getFirstName(), employee.getLastName(),
				employee.getDob(), employee.getGender(), employee.getPrimaryContact(), employee.getSecondaryContact(),
				employee.getEmailId(), employee.getSkypeId(), employee.getProfilePicture(), employee.getPassword(),
				employee.isActive()) > 0;
	}
}
