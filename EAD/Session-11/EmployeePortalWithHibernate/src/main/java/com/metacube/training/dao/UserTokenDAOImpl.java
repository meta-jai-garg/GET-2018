package com.metacube.training.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.UserToken;

@Repository
@Transactional
@SuppressWarnings("deprecation")
public class UserTokenDAOImpl implements UserTokenDAO {

	private Session session;
	@Autowired
	private EntityManager entityManager;

	@Override
	public boolean deleteUserToken(UserToken userToken) {
		createSession();
		UserToken token = (UserToken) session.createCriteria(UserToken.class)
				.add(Restrictions.eq("emailId", userToken.getEmailId())).uniqueResult();
		session.delete(token);
		return true;
	}

	@Override
	public boolean createUserToken(UserToken userToken) {
		createSession();
		session.save(userToken);
		return true;
	}

	@Override
	public UserToken getUserTokenByEmail(String emailId) {
		createSession();
		UserToken token = (UserToken) session.createCriteria(UserToken.class).add(Restrictions.eq("emailId", emailId))
				.uniqueResult();
		return token;
	}

	@Override
	public UserToken getUserTokenByUserToken(String userToken) {
		createSession();
		UserToken token = (UserToken) session.createCriteria(UserToken.class)
				.add(Restrictions.eq("resetToken", userToken)).uniqueResult();
		return token;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}
}
