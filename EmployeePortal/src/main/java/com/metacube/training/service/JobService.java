package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService {

	/**
	 * Method to find {@link Job} by id
	 * 
	 * @param jobId
	 *            id of {@link Job}
	 * @return {@link Job} object
	 */
	Job getJobById(Integer jobId);

	/**
	 * Method to retrieve all {@link Job}
	 * 
	 * @return all {@link Job}
	 */
	List<Job> getAllJobs();

	/**
	 * Method to delete a {@link Job}
	 * 
	 * @param id
	 *            of {@link Job}
	 * @return true on successful deletion
	 */
	boolean deleteJob(Integer id);

	/**
	 * Method to update a {@link Job}
	 * 
	 * @param job
	 *            is object of {@link Job}
	 * @return true on successful update
	 */
	boolean updateJob(Job job);

	/**
	 * Method to create a {@link Job}
	 * 
	 * @param job
	 *            is object of {@link Job}
	 * @return true on successful update
	 */
	boolean createJob(Job job);

}