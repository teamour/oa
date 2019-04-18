package com.our.oa.controller;

import java.util.List;

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

import com.our.oa.dto.CompanyDTO;
import com.our.oa.dto.GridDataDTO;
import com.our.oa.service.CompanyService;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@GetMapping(value = "/list")
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("company/companylist");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDataDTO<CompanyDTO> list(HttpServletRequest req) {
		List<CompanyDTO> list= companyService.getAll();
		return new GridDataDTO<>(1, 1, 1, list);
	}
	
	@GetMapping(value = "/add")
	public ModelAndView add(ModelAndView modelAndView) {
		CompanyDTO companyForm = new CompanyDTO();
		modelAndView.setViewName("company/companyAdd");
		modelAndView.addObject("companyForm", companyForm);
		return modelAndView;
	}
	
	@PostMapping(value = "/add")
	public ModelAndView add(@Valid CompanyDTO companyForm, BindingResult bindingResult, 
			ModelAndView modelAndView ) {
		
        if (bindingResult.hasErrors()) {
        	modelAndView.setViewName("company/companyAdd");
            return modelAndView;
        }
        
        companyService.insert(companyForm);
        
        modelAndView.setViewName("company/companyList");
		modelAndView.addObject("companyForm", companyForm);
        
		return modelAndView;
	}
	
	@GetMapping(value= "/editor/{id}")
	public ModelAndView editor(@PathVariable(name="id",required=false)Integer id, 
			ModelAndView modelAndView) {
		
		CompanyDTO dto = companyService.getByPrimaryKey(id);
		modelAndView.setViewName("company/companyEditor");
		modelAndView.addObject("companyForm", dto);
		return modelAndView;
	}
	
	@PostMapping(value = "/editor")
	public ModelAndView editor(@Valid CompanyDTO companyForm, BindingResult bindingResult, 
			ModelAndView modelAndView ) {
		
		System.out.println("cid: " + companyForm.getCompanyId());
		
        if (bindingResult.hasErrors()) {
        	modelAndView.setViewName("company/companyEditor");
            return modelAndView;
        }
        
        companyService.updateByPrimaryKey(companyForm);
        
        modelAndView.setViewName("company/companyList");
		modelAndView.addObject("companyForm", companyForm);
        
		return modelAndView;
	}
	
	@GetMapping(value = "/detailed/{id}")
	public ModelAndView detailed(@PathVariable(name="id",required=false)Integer id, 
			ModelAndView modelAndView) {
		
		CompanyDTO dto = companyService.getByPrimaryKey(id);
		modelAndView.setViewName("company/companyDetailed");
		modelAndView.addObject("companyForm", dto);
		return modelAndView;
	}
}