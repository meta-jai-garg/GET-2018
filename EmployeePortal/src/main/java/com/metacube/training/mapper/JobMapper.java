/**
 * 
 */
package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Job;

/**
 * @author danny
 *
 */
public class JobMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Job job = new Job();
		job.setJobCode(resultSet.getInt("jobCode"));
		job.setJobTitle(resultSet.getString("jobTitle"));
		return job;
	}

}
