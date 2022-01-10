package com.switchman.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
		String query = "FROM User Where email = :email";
		List<User> list = entityManager.createQuery(query)
				.setParameter("email", user.getEmail())
				.getResultList();
		if(list.isEmpty()){
			return false;
		}
		String passwordHashed = list.get(0).getPassword();

		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		return argon2.verify(passwordHashed, user.getPassword());

		}
		
	}
	
	


