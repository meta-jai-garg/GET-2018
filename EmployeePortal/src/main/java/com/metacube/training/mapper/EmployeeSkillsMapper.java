/**
 * 
 */
package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeSkills;

/**
 * @author danny
 *
 */
public class EmployeeSkillsMapper implements RowMapper<EmployeeSkills> {

	@Override
	public EmployeeSkills mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		EmployeeSkills employeeSkills = new EmployeeSkills();
		employeeSkills.setEmpCode(resultSet.getInt("empCode"));
		employeeSkills.setSkillCode(resultSet.getInt("skillCode"));
		employeeSkills.setSkillId(resultSet.getInt("skillId"));
		return employeeSkills;
	}
}
