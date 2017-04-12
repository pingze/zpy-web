package com.zpy.service;

import javax.annotation.Resource;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.zpy.dao.UserDao;
import com.zpy.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private ThreadPoolTaskExecutor taskExecutor;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void saveByTaskExecutor(User user) {
		try {
			taskExecutor.execute(() -> {
				userDao.save(user);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
