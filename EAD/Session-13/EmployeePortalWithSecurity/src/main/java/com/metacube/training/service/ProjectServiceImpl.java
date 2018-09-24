package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public Project getProjectById(Integer id) {
		return projectRepo.findById(id).get();
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepo.findAll();
	}

	@Override
	public boolean deleteProject(Integer id) {
		projectRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateProject(Project project) {
		projectRepo.save(project);
		return true;
	}

	@Override
	public boolean createProject(Project project) {
		projectRepo.save(project);
		return true;
	}

	@Override
	public Project getProjectByName(String input) {
		return projectRepo.findProjectByDescription(input);
	}

}