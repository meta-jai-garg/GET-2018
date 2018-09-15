package com.metacube.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class ProjectDAOImpl implements ProjectDAO {

	private Session session;

	@Autowired
	private EntityManager entityManager;

	public Project getProjectById(Integer id) {
		createSession();
		Project project = (Project) session.createCriteria(Project.class).add(Restrictions.eq("id", id))
				.uniqueResult();
		return project;
	}

	public List<Project> getAllProjects() {
		createSession();
		Criteria criteria = session.createCriteria(Project.class);
		return criteria.list();
	}

	public boolean deleteProject(Project project) {
		createSession();
		Project deleteProject = (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("id", project.getId())).uniqueResult();
		session.delete(deleteProject);
		return true;
	}

	public boolean updateProject(Project project) {
		createSession();
		Project updateProject = (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("id", project.getId())).uniqueResult();
		updateProject.setDescription(project.getDescription());
		updateProject.setEndDate(project.getEndDate());
		updateProject.setStartDate(project.getStartDate());
		session.update(updateProject);
		return true;
	}

	public boolean createProject(Project project) {
		createSession();
		session.save(project);
		return true;
	}

	@Override
	public Project getProjectByName(String input) {
		createSession();
		Project project = (Project) session.createCriteria(Project.class).add(Restrictions.eq("description", input))
				.uniqueResult();
		return project;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}
}