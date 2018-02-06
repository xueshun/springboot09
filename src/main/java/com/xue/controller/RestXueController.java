package com.xue.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.xue.bean.RoncooUserLog;
import com.xue.cache.RoncooUserLogCache;

@RestController
@RequestMapping(value="/test",method = RequestMethod.POST)
public class RestXueController {
	
	@Autowired
	private RoncooUserLogCache userLogCache;
	
	@RequestMapping(value="/update")
	public RoncooUserLog update(@RequestBody JsonNode jsonNode) {
		System.out.println("jsonNode = " + jsonNode);
		RoncooUserLog bean = userLogCache.selectById(jsonNode.get("id").asInt(1));
		if(bean == null){
			bean = new RoncooUserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		userLogCache.updateById(bean);
		return bean;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public RoncooUserLog update2(@PathVariable(value = "id") Integer id) {
		RoncooUserLog bean = userLogCache.selectById(id);
		if(bean == null){
			bean = new RoncooUserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		userLogCache.updateById(bean);
		return bean;
	}
	
}
