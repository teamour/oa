package com.our.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.form.UserDTO;
import com.our.oa.dto.list.UserListDTO;
import com.our.oa.dto.list.UserListQueryDTO;
import com.our.oa.entity.User;
import com.our.oa.service.DictionaryService;
import com.our.oa.service.UserService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

/*
 * 系统用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView,User user) {
	 	
		modelAndView.setViewName("login");
        return modelAndView;
    }
	@PostMapping("/login")
	public String loginData(User user) {
		
		
		
		return "index";
	}
	@GetMapping(value = "/add")
	public ModelAndView add(ModelAndView modelAndView) {
		UserDTO form = new UserDTO();
		modelAndView.setViewName("user/userAdd");
		modelAndView.addObject("form", form);
		return modelAndView;
	}

	@PostMapping(value = "/add")
	public ModelAndView add(@Valid UserDTO form, BindingResult bindingResult, 
			ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {
			for (int i = 0; i < bindingResult.getErrorCount(); i++) {
				System.out.println(bindingResult.getAllErrors().get(i).getDefaultMessage());
			}
			return new ModelAndView("redirect:/user/add");
		}
		String massage = userService.save(form);
		System.out.println(massage);
		return new ModelAndView("redirect:/user/list");
	}
	@GetMapping("/list")
	public ModelAndView listDataByEmployeeId(
			ModelAndView modelAndView) {
		modelAndView.setViewName("user/userList");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDTO<UserListDTO> listData(HttpServletRequest req,
			UserListQueryDTO listQueryDTO) {	
	    Page<UserListDTO> queryList = userService.getQueryList(listQueryDTO);
	    return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
}
