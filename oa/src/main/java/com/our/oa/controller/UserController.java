package com.our.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView loginView(
			ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView login(
			ModelAndView modelAndView ,User user ) {
		userService.selectByEmail(user);
		modelAndView.setViewName("redirect:");
		return modelAndView;
	}
	@GetMapping("/register")
	public ModelAndView registerView(
			ModelAndView modelAndView) {
		 modelAndView.setViewName("register");
		return modelAndView;
	}
	@PostMapping("/register")
	public ModelAndView register(
	 	 ModelAndView modelAndView ,User user ) {
		try {
			//1.先对数据进行校验
			//2.校验成功后对用户进行添加
			userService.save(user);
			//3.注册成功后跳转到登陆界面
		} catch (Exception e) {
		}
		modelAndView.setViewName("redirect:login");
		return modelAndView;
	}
	@GetMapping("/valid")
	public ModelAndView checkUser(
			ModelAndView modelAndView) {
		 modelAndView.setViewName("valid");
		return modelAndView;
	}
	//对注册信息进行校验
	@PostMapping("/valid/{type}/{param}")
	public String checkUser(@PathVariable String param,
			@PathVariable Integer type,ModelAndView modelAndView){
		//查询后台数据 返回结果信息 true 信息已存在
		boolean flag = userService.valid(param,type);
		if (!flag) {
			return "可以使用";
		}
		return "已有人占用";
	}
	
	/*@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		//获取cookie数据
		Cookie[] cookies  = request.getCookies();
		for (Cookie cookie : cookies) {
			if("JT_TICKET".equals(cookie.getName())){
				String ticket = cookie.getValue();
				jedisCluster.del(ticket);
				break; //跳出循环
			}
		}
		//清空Cooke数据
		Cookie cookie = new Cookie("JT_TICKET", "");
		cookie.setPath("/");
		cookie.setMaxAge(0);//立即删除
		response.addCookie(cookie);
	
		//重定向到系统首页
		return "redirect:/index.html";
	}*/
}
