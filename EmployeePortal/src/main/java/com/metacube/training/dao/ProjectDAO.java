package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectDAO {

	/**
	 * method to find {@link Project}
	 * 
	 * @param projectId
	 *            of {@link Project}
	 * @return {@link Project}
	 */
	Project getProjectById(Integer id);

	/**
	 * method to retrieve all {@link Project}
	 * 
	 * @return list of {@link Project}
	 */
	List<Project> getAllProjects();

	/**
	 * method to delete an {@link Project}
	 * 
	 * @param project
	 *            is object of {@link Project}
	 * @return true on successful deletion of Project
	 */
	boolean deleteProject(Project project);

	/**
	 * method to update an {@link Project}
	 * 
	 * @param project
	 *            is object of {@link Project}
	 * @return
	 */
	boolean updateProject(Project project);

	/**
	 * method to create an {@link Project}
	 * 
	 * @param project
	 *            is object of {@link Project}
	 * @return true on successful insertion of {@link Project}
	 */
	boolean createProject(Project project);
}
