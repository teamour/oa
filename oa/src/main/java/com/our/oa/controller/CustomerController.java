package com.our.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.list.CustomerListDTO;
import com.our.oa.dto.list.CustomerListQueryDTO;
import com.our.oa.service.CustomerService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@GetMapping(value = "/list")
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("customer/customerList");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDTO<CustomerListDTO> listData(HttpServletRequest req,
			CustomerListQueryDTO listQueryDTO) {
		
		PageInfo<CustomerListDTO> queryList = service.getQueryList(listQueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	
	@GetMapping(value = "/add")
	public ModelAndView add(ModelAndView modelAndView) {
		CustomerDTO form = new CustomerDTO();
		modelAndView.setViewName("customer/customerAdd");
		modelAndView.addObject("form", form);
		return modelAndView;
	}

	@PostMapping(value = "/add")
	public ModelAndView add(@Valid CustomerDTO form, BindingResult bindingResult, 
			ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {
			for (int i = 0; i < bindingResult.getErrorCount(); i++) {
				System.out.println(bindingResult.getAllErrors().get(i).getDefaultMessage());
			}
			return new ModelAndView("redirect:/customer/add");
		}
		service.insert(form);
		return new ModelAndView("redirect:/customer/list");
	}
	
	@GetMapping(value = "/edit/{id}")
	public ModelAndView editor(@PathVariable(name = "id", required = false) Integer id, 
			ModelAndView modelAndView) {
		
		CustomerDTO dto = service.getByPrimaryKey(id);
		modelAndView.setViewName("customer/customerEdit");
		modelAndView.addObject("form", dto);
		return modelAndView;
	}

	@PostMapping(value = "/edit")
	public ModelAndView editor(@Valid CustomerDTO form, BindingResult bindingResult, 
			ModelAndView modelAndView) {
		
		if (bindingResult.hasErrors()) {
			for (int i = 0; i < bindingResult.getErrorCount(); i++) {
				System.out.println(bindingResult.getAllErrors().get(i).getDefaultMessage());
			}
			return new ModelAndView("redirect:/customer/edit");
		}
		service.updateByPrimaryKey(form);
		return new ModelAndView("redirect:/customer/list");
	}
	
	@GetMapping(value = "/detailed/{id}")
	public ModelAndView detailed(@PathVariable(name = "id", required = false) Integer id, 
			ModelAndView modelAndView) {

		CustomerDTO dto = service.getByPrimaryKey(id);
		modelAndView.setViewName("customer/customerDetailed");
		modelAndView.addObject("form", dto);
		return modelAndView;
	}
	
	@PostMapping(value = "/delete" )
	public ModelAndView delete(Integer... rows) {
		for (Integer id : rows) {
			service.deleteByPrimaryKey(id);
		}
		
		return new ModelAndView("redirect:/customer/list");
	}
}
