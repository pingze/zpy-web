package com.zpy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zpy.dao.UserDao;
import com.zpy.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

}
