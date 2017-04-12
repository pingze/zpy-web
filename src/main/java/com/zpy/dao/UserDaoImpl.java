package com.zpy.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zpy.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void save(User user) {
		String sql = "insert into user(name) values (?)";
		int rows = 0;
		try {
			rows = jdbcTemplate.update(sql, user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("a user saved!-------" + rows);
	}

}
