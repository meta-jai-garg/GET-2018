/**
 * 
 */
package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.JobDetails;

/**
 * @author danny
 *
 */
public class JobDetailsMapper implements RowMapper<JobDetails> {

	@Override
	public JobDetails mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setCurrProjId(resultSet.getInt("currProjId"));
		jobDetails.setDateOfJoining(resultSet.getDate("dateOfJoining"));
		jobDetails.setEmpCode(resultSet.getInt("empCode"));
		jobDetails.setJobCode(resultSet.getInt("jobCode"));
		jobDetails.setJobDetailId(resultSet.getInt("jobDetailId"));
		jobDetails.setReportingManager(resultSet.getInt("reportingManager"));
		jobDetails.setTeamLead(resultSet.getInt("teamLead"));
		jobDetails.setTotalExp(resultSet.getInt("totalExp"));
		return jobDetails;
	}

}
