package com.zpy.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDao {

	public String getName(String name) {
		System.out.println("--------" + name);
		return name;
	}
}
