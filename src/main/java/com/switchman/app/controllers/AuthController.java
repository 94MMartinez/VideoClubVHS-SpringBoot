package com.switchman.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.dao.UserDao;
import com.switchman.app.models.User;
import com.switchman.app.utils.JWTUtil;

@RestController
public class AuthController {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		
		User userlog = userDao.getUsersByCredentials(user);
		if(userlog != null){	
	        String tokenJwt = jwtUtil.create(String.valueOf(userlog.getId()), userlog.getEmail());
            return tokenJwt;
		}
		return "FAIL";
	
	
	}
}


