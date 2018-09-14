package com.metacube.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.UserToken;

@Repository
public class UserTokenDAOImpl implements UserTokenDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserTokenDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_CREATE_TOKEN = "INSERT INTO userToken(emailId, resetToken) VALUES (?,?)";
	private final String SQL_DELETE_TOKEN = "DELETE FROM userToken WHERE emailId=?";
	private final String SQL_GET_TOKEN = "SELECT *FROM userToken where emailId=?";
	private final String SQL_GET_EMAIL = "SELECT *FROM userToken WHERE resetToken=?";

	@Override
	public boolean deleteUserToken(UserToken userToken) {
		return jdbcTemplate.update(SQL_DELETE_TOKEN, userToken.getEmailId()) > 0;
	}

	@Override
	public boolean createUserToken(UserToken userToken) {
		return jdbcTemplate.update(SQL_CREATE_TOKEN, userToken.getEmailId(),
				userToken.getResetToken()) > 0;
	}

	@Override
	public UserToken getUserTokenByEmail(String emailId) {
		try {
			UserToken userToken = jdbcTemplate.queryForObject(SQL_GET_TOKEN,
					new Object[] { emailId }, new UserTokenMapper());
			return userToken;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public UserToken getUserTokenByUserToken(String userToken) {
		try {
			UserToken token = jdbcTemplate.queryForObject(SQL_GET_EMAIL,
					new Object[]{userToken},new UserTokenMapper());
			return token;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * Mapper class to map {@link UserToken}
	 *
	 */
	private class UserTokenMapper implements RowMapper<UserToken> {

		@Override
		public UserToken mapRow(ResultSet resultSet, int rowNumber)
				throws SQLException {
			UserToken userToken = new UserToken();
			userToken.setEmailId(resultSet.getString("emailId"));
			userToken.setResetToken(resultSet.getString("resetToken"));
			return userToken;
		}
	}
}
