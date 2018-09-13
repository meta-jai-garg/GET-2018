package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobDetails;

public interface JobDetailService {
	/**
	 * Used to retrieve a jobDetail given its id. Null
	 * if no such jobDetail found.
	 * @param id  Id of jobDetail
	 * @return    JobDetail with given id
	 */
	public JobDetails getById(Integer id);

	/**
	 * Used to retrieve all jobDetails from the database.
	 * @return    List of all jobDetails
	 */
	public List<JobDetails> getAll();
	
	/**
	 * Used to add jobDetail to the database.
	 * @return  Auto generated id of the jobDetail inserted, 0 on failure
	 */
	public Integer create(JobDetails jobDetail);
	
	/**
	 * Used to update jobDetail in the database.
	 * @param   jobDetail to be updated, identified by the id
	 * @return  True if jobDetail updated, false otherwise.
	 */
	public boolean update(JobDetails jobDetail);
	
	/**
	 * Used to delete jobDetail from the database.
	 * @param   id of jobDetail to be deleted
	 * @return  True if jobDetail deleted, false otherwise.
	 */
	public boolean delete(Integer id);

	JobDetails getByEmployeeId(Integer empCode);
}