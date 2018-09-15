package com.metacube.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkills;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class EmployeeSkillsDAOImpl implements EmployeeSkillsDAO {

	private Session session;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EmployeeSkills> getEmployeeSkills(Integer skillCode) {
		createSession();
		Criteria criteria = session.createCriteria(EmployeeSkills.class).add(Restrictions.eq("skillCode", skillCode));
		return criteria.list();
	}

	@Override
	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		createSession();
		Criteria criteria = session.createCriteria(EmployeeSkills.class).add(Restrictions.eq("empCode", empCode));
		return criteria.list();
	}

	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		createSession();
		session.save(employeeSkills);
		return true;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}
}