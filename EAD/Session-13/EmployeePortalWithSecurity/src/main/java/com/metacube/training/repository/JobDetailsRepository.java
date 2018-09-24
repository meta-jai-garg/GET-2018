package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.JobDetails;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer>{
	JobDetails findJobDetailsByEmpCode(Integer empCode);
}
