package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailsRepository;

@Service
public class JobDetailServiceImpl implements JobDetailService {
	
	@Autowired
	private JobDetailsRepository jobDetailRepo;

	@Override
	public JobDetails getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobDetails getByEmployeeId(Integer empCode) {
		return jobDetailRepo.findJobDetailsByEmpCode(empCode);
	}

	@Override
	public Integer create(JobDetails jobDetail) {
		jobDetailRepo.save(jobDetail);
		return 1;
	}

	@Override
	public boolean update(JobDetails jobDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
