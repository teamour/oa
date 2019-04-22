package com.our.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.our.oa.entity.User;
import com.our.oa.service.UserService;

/*
 * 系统用户相关
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(User user) {
		// 登录操作(暂用查询数据库方法).
		Integer rows = userService.selectByEmail(user);
		try {
			System.out.println(user.getEmail());
			System.out.println(user.getUserPwd());
			System.out.println(rows);
			if (rows==0) {
				return "邮箱或者密码错误";
			}
		} catch (Exception e) {}
		
		// 成功之后进入home页面
		return "home";
	}
	@GetMapping("/home")
	public ModelAndView home(ModelAndView modelAndView) {
		// 登录操作(暂用查询数据库方法).
		modelAndView.setViewName("home");
		return modelAndView;
	}
	@PostMapping("/logout")
	public String logout() {
		
		// 退出后到index登录页面
		return "index";
	}
	
}
