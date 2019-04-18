package com.our.oa.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 系统用户相关
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

	@PostMapping("/login")
	public String login() {
		// 登录操作.
		
		// 成功之后进入home页面
		return "home";
	}
	
	@PostMapping("/logout")
	public String logout() {
		
		// 退出后到index登录页面
		return "index";
	}
	
}
