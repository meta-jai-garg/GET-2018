package com.metacube.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;

@Repository
@Transactional
@SuppressWarnings({"unchecked","deprecation"})
public class JobDAOImpl implements JobDAO {

	private Session sessionFactory;

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Job getJobById(Integer jobId) {
		createSession();
		return sessionFactory.get(Job.class, jobId);
	}

	@Override
	public List<Job> getAllJobs() {
		createSession();
		Criteria cr = sessionFactory.createCriteria(Job.class);
		List<Job> jobList = cr.list();
		return jobList;
	}

	@Override
	public boolean deleteJob(Job job) {
		createSession();
		Job jobDelete = (Job) sessionFactory.createCriteria(Job.class).add(Restrictions.eq("jobCode", job.getJobCode()))
				.uniqueResult();
		sessionFactory.delete(jobDelete);
		return true;
	}

	@Override
	public boolean updateJob(Job job) {
		createSession();
		Job jobUpdate = (Job) sessionFactory.createCriteria(Job.class).add(Restrictions.eq("jobCode", job.getJobCode()))
				.uniqueResult();
		jobUpdate.setJobTitle(job.getJobTitle()); 
		sessionFactory.update(jobUpdate);
		return true;
	}

	@Override
	public boolean createJob(Job job) {
		createSession();
		sessionFactory.save(job);
		return true;
	}

	void createSession() {
		this.sessionFactory = entityManager.unwrap(Session.class);
	}
}