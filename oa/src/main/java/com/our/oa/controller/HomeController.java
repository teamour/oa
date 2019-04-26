package com.our.oa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	
	@GetMapping()
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("/home");
		return modelAndView;
	}
}
