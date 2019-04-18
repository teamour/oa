package com.our.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;
import com.our.oa.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/show")
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("emp/emp-manage");
		return modelAndView;
	}

	@PostMapping("/addInfo")
	public ModelAndView save(ModelAndView modelAndView, Employee employee, EmployeeSite employeeSite) {

		employeeService.insert(employee, employeeSite);
		modelAndView.setViewName("emp/saveok");
		return modelAndView;
	}
	
	
}
