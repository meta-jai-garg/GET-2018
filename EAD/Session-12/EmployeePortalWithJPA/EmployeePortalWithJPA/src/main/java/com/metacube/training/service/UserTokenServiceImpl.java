package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.UserToken;
import com.metacube.training.repository.UserTokenRepository;

@Service
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired
	private UserTokenRepository userTokenRepo;

	@Override
	public boolean deleteUserToken(UserToken userToken) {
		userTokenRepo.delete(userToken);
		return true;
	}

	@Override
	public boolean createUserToken(UserToken userToken) {
		userTokenRepo.save(userToken);
		return true;
	}

	@Override
	public UserToken getUserTokenByEmail(String emailId) {
		return userTokenRepo.findUserTokenByEmailId(emailId);
	}

	@Override
	public UserToken getUserTokenByUserToken(String resetToken) {
		return userTokenRepo.findUserTokenByResetToken(resetToken);
	}
}