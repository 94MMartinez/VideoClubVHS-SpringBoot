package com.switchman.app.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.dao.UserDao;
import com.switchman.app.models.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;


	
	@RequestMapping(value = "api/users", method = RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
 		String hash = argon2.hash(1,1024,1,user.getPassword());
		user.setPassword(hash);

		userDao.register(user);
	}
}
