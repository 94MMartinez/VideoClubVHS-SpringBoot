package com.switchman.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.switchman.app.models.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	
	@PersistenceContext
	EntityManager entityManager;
	

	
	@Override
	public void register(User user) {
		entityManager.merge(user);
	}
	
	

}
