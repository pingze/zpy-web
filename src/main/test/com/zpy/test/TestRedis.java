package com.zpy.test;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class TestRedis {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplateCluster;
	
	@Test
	public void test() {
		try {
			ValueOperations<String, Object> valueOptions = redisTemplate.opsForValue();
			Object value = valueOptions.get("hello");
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		ValueOperations<String ,Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("key_world", "zhangsan");
		System.out.println(valueOperations.get("key_world"));
		valueOperations.set("key_hello", "lisi", 30, TimeUnit.SECONDS);
		System.out.println(valueOperations.get("key_hello"));
	}
	
	@Test
	public void test3() {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		listOperations.leftPush("list_key_1", "wangermazi");
		//listOperations.leftPush("list_key_2", "zhaoliu");
		//System.out.println(listOperations.leftPop("list_key_2"));
		System.out.println(listOperations.rightPop("list_key_1"));
	}
	
	@Test
	public void testCluster() {
		try {
			ValueOperations<String, Object> valueOperations = redisTemplateCluster.opsForValue();
			valueOperations.set("cluster_key_1", "Java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
