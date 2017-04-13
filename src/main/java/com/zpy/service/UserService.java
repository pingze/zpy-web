package com.zpy.service;

import com.zpy.entity.User;

public interface UserService {

	void saveByTaskExecutor(User user);
	
	void save(User user);
	
	User getUserById(Integer id);
}
