package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.UserTokenDAO;
import com.metacube.training.model.UserToken;

@Service
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired
	UserTokenDAO userTokenDao;

	@Override
	public boolean deleteUserToken(UserToken userToken) {
		return userTokenDao.deleteUserToken(userToken);
	}

	@Override
	public boolean createUserToken(UserToken userToken) {
		return userTokenDao.createUserToken(userToken);
	}

	@Override
	public UserToken getUserTokenByEmail(String emailId) {
		return userTokenDao.getUserTokenByEmail(emailId);
	}

	@Override
	public UserToken getUserTokenByUserToken(String userToken) {
		return userTokenDao.getUserTokenByUserToken(userToken);
	}
}