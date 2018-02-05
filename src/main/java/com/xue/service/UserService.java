package com.xue.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xue.bean.RoncooUser;
import com.xue.bean.RoncooUserLog;
import com.xue.dao.RoncooUserLogDao;
import com.xue.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Transactional
	public String register(String name, String ip) {
		// 1.添加用户
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName(name);
		roncooUser.setCreateTime(new Date());
		userDao.insert(roncooUser);

		// 测试使用
		/*boolean flag = true;
		if (flag) {
			throw new RuntimeException();
		}*/

		// 2.添加注册日志
		RoncooUserLog roncooUserLog = new RoncooUserLog();
		roncooUserLog.setUserName(name);
		roncooUserLog.setUserIp(ip);
		roncooUserLog.setCreateTime(new Date());
		roncooUserLogDao.save(roncooUserLog);

		return "success";
	}

}