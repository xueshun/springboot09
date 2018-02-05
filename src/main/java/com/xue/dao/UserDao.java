package com.xue.dao;

import com.xue.bean.RoncooUser;


public interface UserDao{
	
	//插入操作
	int insert(RoncooUser roncooUser);
	//删除操作
	int deleteById(int id);
	//更新操作
	int updateById(RoncooUser roncooUser);
	//查询操作
	RoncooUser selectById(int id);
}

