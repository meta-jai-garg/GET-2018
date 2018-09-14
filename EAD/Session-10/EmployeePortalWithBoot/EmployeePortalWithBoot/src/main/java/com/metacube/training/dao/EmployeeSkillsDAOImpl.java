package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.EmployeeSkillsMapper;
import com.metacube.training.model.EmployeeSkills;

@Repository
public class EmployeeSkillsDAOImpl implements EmployeeSkillsDAO {

	private JdbcTemplate jdbcTemplate;

	public EmployeeSkillsDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_SKILL_BY_EMPLOYEE = "select *from employeeSkills where empCode=?";
	private final String SQL_FIND_EMPLOYEE_BY_SKILL = "select *from employeeSkills where skillCode=?";
	private final String SQL_CREATE_EMPLOYEE_SKILL = "insert into employeeSkills(empCode, skillCode)values(?,?)";

	@Override
	public List<EmployeeSkills> getEmployeeSkills(Integer skillCode) {
		return jdbcTemplate.query(SQL_FIND_EMPLOYEE_BY_SKILL,
				new Object[] { skillCode }, new EmployeeSkillsMapper());
	}
	
	@Override
	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		return jdbcTemplate.query(SQL_FIND_SKILL_BY_EMPLOYEE,
				new Object[] { empCode }, new EmployeeSkillsMapper());
	}

	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		return jdbcTemplate.update(SQL_CREATE_EMPLOYEE_SKILL,
				employeeSkills.getEmpCode(), employeeSkills.getSkillCode()) > 0;
	}

}
