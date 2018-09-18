package com.metacube.training.service;

import com.metacube.training.model.UserToken;

public interface UserTokenService {

	/**
	 * method to delete an {@link UserToken}
	 * 
	 * @param UserToken
	 *            is object of {@link UserToken}
	 * @return true on successful deletion of UserToken
	 */
	boolean deleteUserToken(UserToken userToken);

	/**
	 * method to create an {@link UserToken}
	 * 
	 * @param UserToken
	 *            is object of {@link UserToken}
	 * @return true on successful insertion of {@link UserToken}
	 */
	boolean createUserToken(UserToken userToken);

	/**
	 * Method to retrieve {@link UserToken} by email
	 * 
	 * @param emailId
	 * @return
	 */
	UserToken getUserTokenByEmail(String emailId);

	UserToken getUserTokenByUserToken(String userToken);

}
