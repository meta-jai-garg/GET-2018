package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	Project findProjectByDescription(String projectName);
}
