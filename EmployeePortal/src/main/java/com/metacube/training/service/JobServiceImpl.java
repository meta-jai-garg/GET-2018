package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.Job;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobDAO jobDao;

	@Override
	public Job getJobById(Integer jobId) {
		return jobDao.getJobById(jobId);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}

	@Override
	public boolean deleteJob(Integer id) {
		Job job = jobDao.getJobById(id);
		return jobDao.deleteJob(job);
	}

	@Override
	public boolean updateJob(Job job) {
		return jobDao.updateJob(job);
	}

	@Override
	public boolean createJob(Job job) {
		return jobDao.createJob(job);
	}

}