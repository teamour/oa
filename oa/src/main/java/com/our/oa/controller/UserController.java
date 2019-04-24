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
	
	@GetMapping("/login")
	public String login(String email,String userPwd) {
		System.out.println(email);
		System.out.println(userPwd);
		User user =new User();
		user.setEmail(email);
		user.setUserPwd(userPwd);
		Integer rows = userService.selectByEmail(user);
			System.out.println(rows);
			if (rows==0) {
				System.out.println("账号或密码错误");
			}
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
