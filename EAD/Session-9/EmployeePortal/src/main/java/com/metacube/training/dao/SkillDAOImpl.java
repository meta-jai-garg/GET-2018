package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.SkillsMapper;
import com.metacube.training.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SkillDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_SKILL_BY_NAME = "select * from skillsmaster where skillName=?";
	private final String SQL_FIND_SKILL = "select * from skillsmaster where skillId = ?";
	private final String SQL_DELETE_SKILL = "delete from skillsmaster where skillId = ?";
	private final String SQL_UPDATE_SKILL = "update skillsmaster set skillName = ? where skillId = ?";
	private final String SQL_GET_ALL = "select * from skillsmaster";
	private final String SQL_INSERT_SKILL = "insert into skillsmaster(skillName) values(?)";
	private final String SQL_FIND_EMPLOYEE_SKILLS = "select *from skillsMaster where skillId NOT IN(select skillCode from employeeSkills where empCode=?)";

	@Override
	public Skill getSkillById(Integer skillId) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL,
				new Object[] { skillId }, new SkillsMapper());
	}

	@Override
	public Skill getSkillByName(String skillName) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL_BY_NAME,
				new Object[] { skillName }, new SkillsMapper());
	}
	
	@Override
	public List<Skill> getSkillByNameForEmployee(Integer empCode) {
		return jdbcTemplate.query(SQL_FIND_EMPLOYEE_SKILLS,
				new Object[] { empCode }, new SkillsMapper());
	}

	@Override
	public List<Skill> getAllSkills() {
		return jdbcTemplate.query(SQL_GET_ALL, new SkillsMapper());
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		return jdbcTemplate.update(SQL_DELETE_SKILL, skill.getSkillId()) > 0;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return jdbcTemplate.update(SQL_UPDATE_SKILL, skill.getSkillName(),
				skill.getSkillId()) > 0;
	}

	@Override
	public boolean createSkill(Skill skill) {
		return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getSkillName()) > 0;
	}

}