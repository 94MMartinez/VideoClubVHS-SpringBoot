package com.switchman.app.dao;

import com.switchman.app.models.User;

public interface UserDao {
	
	void register(User user);

	User getUsersByCredentials(User user);

}
