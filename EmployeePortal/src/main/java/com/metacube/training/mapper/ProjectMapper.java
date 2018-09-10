package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Project;

public class ProjectMapper implements RowMapper<Project> {
	public Project mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Project project = new Project();
		project.setId(resultSet.getInt("projectId"));
		project.setDescription(resultSet.getString("description"));
		project.setStartDate(resultSet.getDate("startDate"));
		project.setEndDate(resultSet.getDate("endDate"));
		return project;
	}
}
