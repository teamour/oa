package com.our.oa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
 * 系统用户相关
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

	@GetMapping("/login")
	public ModelAndView login(ModelAndView modelAndView) {
		// 登录操作.
		
		modelAndView.setViewName("home");
		// 成功之后进入home页面
		return modelAndView;
	}
	
	@PostMapping("/logout")
	public String logout() {
		
		// 退出后到index登录页面
		return "index";
	}
	
}
