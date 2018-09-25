package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Job;
import com.metacube.training.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepo;

	@Override
	public Job getJobById(Integer jobId) {
		return jobRepo.findById(jobId).get();
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	@Override
	public boolean deleteJob(Integer id) {
		jobRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateJob(Job job) {
		jobRepo.save(job);
		return true;

	}

	@Override
	public boolean createJob(Job job) {
		jobRepo.save(job);
		return true;
	}

}