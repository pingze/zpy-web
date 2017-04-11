package com.zpy.dao;

import org.springframework.stereotype.Component;

import com.zpy.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println("a user saved!");
	}

}
