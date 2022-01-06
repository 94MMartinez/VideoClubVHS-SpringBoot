package com.switchman.app.dao;

import java.util.List;

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



	@Override
	public boolean verifyAccount(User user) {
		String query = "FROM User Where email = :email AND password = :password";
		List<User> list = entityManager.createQuery(query)
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.getResultList();
		

			return !list.isEmpty();
		}
		
	}
	
	


