package com.switchman.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.dao.UserDao;
import com.switchman.app.models.User;

@RestController
public class AuthController {
	
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		if(userDao.verifyAccount(user)){
			return "OK";
		}
		return "FAIL";
	
	
	}
}
