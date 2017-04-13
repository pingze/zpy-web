package com.zpy.repository;

import com.zpy.entity.User;

public interface UserDao {

	void save(User user);
	
	User getUserById(Integer id);
}
