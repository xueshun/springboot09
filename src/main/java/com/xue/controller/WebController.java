package com.xue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/web")
public class WebController {
	
	/*@RequestMapping(value="index")
	public String index(ModelMap map) {
		map.put("title", "hello spring boot");
		return "index";
	}*/
	
	@RequestMapping(value = "/index")
	public String index(ModelMap map, HttpSession httpSession) {
		map.put("title", "第一个应用：sessionID=" + httpSession.getId());
		System.out.println("sessionID=" + httpSession.getId());
		return "index";
	}
	
	@RequestMapping(value="error")
	public String erro(ModelMap map) {
		throw new RuntimeException("测试异常");
	}
}
