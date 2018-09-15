package com.metacube.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobDetails;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class JobDetailDAOImpl implements JobDetailDAO {

	private Session session;
	@Autowired
	private EntityManager entityManager;

	@Override
	public JobDetails getById(Integer id) {
		createSession();
		JobDetails jobDetails = (JobDetails) session.createCriteria(JobDetails.class)
				.add(Restrictions.eq("jobDetailId", id)).uniqueResult();
		return jobDetails;
	}

	@Override
	public JobDetails getByEmployeeId(Integer empCode) {
		createSession();
		JobDetails jobDetails = (JobDetails) session.createCriteria(JobDetails.class)
				.add(Restrictions.eq("empCode", empCode)).uniqueResult();
		return jobDetails;
	}

	@Override
	public List<JobDetails> getAll() {
		createSession();
		Criteria criteria = session.createCriteria(JobDetails.class);
		return criteria.list();
	}

	@Override
	public Integer create(JobDetails jobDetail) {
		createSession();
		Integer i = (Integer) session.save(jobDetail);
		return i;
	}

	@Override
	public boolean update(JobDetails jobDetail) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}

}