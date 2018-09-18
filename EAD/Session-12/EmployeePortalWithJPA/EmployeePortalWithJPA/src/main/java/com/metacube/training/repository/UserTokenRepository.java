package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.UserToken;

public interface UserTokenRepository extends JpaRepository<UserToken, Integer> {
	UserToken findUserTokenByEmailId(String emailId);
	UserToken findUserTokenByResetToken(String resetToken);
}