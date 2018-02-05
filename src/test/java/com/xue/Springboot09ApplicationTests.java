package com.xue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xue.bean.RoncooUser;
import com.xue.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09ApplicationTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void insert() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName("测试");
		roncooUser.setCreateTime(new Date());
		int result = userDao.insert(roncooUser);
		System.out.println(result);
	}
	
	@Test
	public void delete() {
		int result = userDao.deleteById(1);
		System.out.println(result);
	}
	
	@Test
	public void update() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(2);
		roncooUser.setName("测试 2");
		roncooUser.setCreateTime(new Date());
		int result = userDao.updateById(roncooUser);
		System.out.println(result);
	}
	
	@Test
	public void select() {
		RoncooUser result = userDao.selectById(2);
		System.out.println(result);
	}

}
