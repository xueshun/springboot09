package com.xue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xue.component.RoncooRedisComponent;

public class RedisConnTest extends Springboot091ApplicationTests {
	
	@Autowired
	private RoncooRedisComponent roncooRedisComponent;
	
	@Test
	public void set() {
		roncooRedisComponent.set("roncoo", "hello world");
	}

	@Test
	public void get() {
		System.out.println(roncooRedisComponent.get("roncoo"));
	}
	
	@Test
	public void del() {
		roncooRedisComponent.del("roncoo");
	}
	
}
