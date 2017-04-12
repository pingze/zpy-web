package com.zpy.service;

import com.zpy.model.User;

public interface UserService {

	void saveByTaskExecutor(User user);
	
	void save(User user);
}
