package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectService {

	/**
	 * Method to find {@link Project} by id
	 * 
	 * @param ProjectId
	 *            id of {@link Project}
	 * @return {@link Project} object
	 */
	Project getProjectById(Integer ProjectId);

	/**
	 * Method to retrieve all {@link Project}
	 * 
	 * @return all {@link Project}
	 */
	List<Project> getAllProjects();

	/**
	 * Method to delete a {@link Project}
	 * 
	 * @param id
	 *            of {@link Project}
	 * @return true on successful deletion
	 */
	boolean deleteProject(Integer id);

	/**
	 * Method to update a {@link Project}
	 * 
	 * @param Project
	 *            is object of {@link Project}
	 * @return true on successful update
	 */
	boolean updateProject(Project Project);

	/**
	 * Method to create a {@link Project}
	 * 
	 * @param Project
	 *            is object of {@link Project}
	 * @return true on successful update
	 */
	boolean createProject(Project Project);

}
