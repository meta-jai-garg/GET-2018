package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpCode(resultSet.getInt("empCode"));
		employee.setFirstName(resultSet.getString("firstName"));
		employee.setLastName(resultSet.getString("lastName"));
		employee.setGender(resultSet.getString("gender"));
		employee.setActive(resultSet.getInt("isActive"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setEmailId(resultSet.getString("emailId"));
		employee.setPassword(resultSet.getString("password"));
		employee.setPrimaryContact(resultSet.getString("primaryContact"));
		employee.setSecondaryContact(resultSet.getString("secondaryContact"));
		employee.setProfilePicture(resultSet.getString("profilePicture"));
		employee.setSkypeId(resultSet.getString("skypeId"));
		return employee;
	}

}
