package com.zpy.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDao {

	public String getName() {
		System.out.println("zhangsan");
		return "zhangsan";
	}
}
