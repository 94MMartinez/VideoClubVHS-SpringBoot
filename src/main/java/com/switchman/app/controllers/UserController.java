package com.switchman.app.controllers;

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
		userDao.register(user);
	}
}
