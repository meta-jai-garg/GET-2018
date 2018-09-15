package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.Skill;

@Repository
@Transactional
@SuppressWarnings({ "deprecation", "unchecked" })
public class SkillDAOImpl implements SkillDAO {

	private Session session;
	@Autowired
	private EntityManager entityManager;

	@Override
	public Skill getSkillById(Integer skillId) {
		createSession();

		Skill skill = (Skill) session.createCriteria(Skill.class).add(Restrictions.eq("skillId", skillId))
				.uniqueResult();
		return skill;
	}

	@Override
	public Skill getSkillByName(String skillName) {
		createSession();
		Skill skill = (Skill) session.createCriteria(Skill.class).add(Restrictions.eq("skillName", skillName))
				.uniqueResult();
		return skill;
	}

	@Override
	public List<Skill> getSkillByNameForEmployee(Integer empCode) {
		createSession();
		List<EmployeeSkills> skillCodes = session.createCriteria(EmployeeSkills.class)
				.add(Restrictions.eq("empCode", empCode)).list();
		List<Integer> skillCode = new ArrayList<>();
		skillCode.add(0);
		for (EmployeeSkills employeeSkill : skillCodes)
			skillCode.add(employeeSkill.getSkillCode());

		List<Skill> skillNames = session.createCriteria(Skill.class)
				.add(Restrictions.not(Restrictions.in("skillId", skillCode))).list();
		return skillNames;
	}

	@Override
	public List<Skill> getAllSkills() {
		createSession();
		Criteria criteria = session.createCriteria(Skill.class);
		return criteria.list();
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		createSession();
		Skill deleteSkill = (Skill) session.createCriteria(Skill.class)
				.add(Restrictions.eq("skillId", skill.getSkillId())).uniqueResult();
		session.delete(deleteSkill);
		return true;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		createSession();
		Skill updateSkill = (Skill) session.createCriteria(Skill.class)
				.add(Restrictions.eq("skillId", skill.getSkillId())).uniqueResult();
		updateSkill.setSkillName(skill.getSkillName());
		session.update(updateSkill);
		return true;
	}

	@Override
	public boolean createSkill(Skill skill) {
		createSession();
		session.save(skill);
		return true;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}

}