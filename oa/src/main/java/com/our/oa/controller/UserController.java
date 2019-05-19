package com.our.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.our.oa.dto.form.UserDTO;
import com.our.oa.entity.User;
import com.our.oa.service.UserService;

/*
 * 系统用户相关
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
    public String login(User user) {
	 	
        return "login";
    }
	@PostMapping("/login")
	public String loginData(User user) {
		
		
		
		return "index";
	}
	@GetMapping("/register")
    public String register(User user) {
	 	
        return "register";
    }
	@PostMapping("/register")
	public String registerData(UserDTO user) {
		
		userService.saveUser(user);
		
		return "redirect:/user/login";
	}
}
