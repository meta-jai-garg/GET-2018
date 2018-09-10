package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobDAO {

	/**
	 * method to find {@link Job}
	 * 
	 * @param JobId
	 *            of {@link Job}
	 * @return {@link Job}
	 */
	Job getJobById(Integer id);

	/**
	 * method to retrieve all {@link Job}
	 * 
	 * @return list of {@link Job}
	 */
	List<Job> getAllJobs();

	/**
	 * method to delete an {@link Job}
	 * 
	 * @param Job
	 *            is object of {@link Job}
	 * @return true on successful deletion of Job
	 */
	boolean deleteJob(Job Job);

	/**
	 * method to update an {@link Job}
	 * 
	 * @param Job
	 *            is object of {@link Job}
	 * @return
	 */
	boolean updateJob(Job Job);

	/**
	 * method to create an {@link Job}
	 * 
	 * @param Job
	 *            is object of {@link Job}
	 * @return true on successful insertion of {@link Job}
	 */
	boolean createJob(Job Job);

}