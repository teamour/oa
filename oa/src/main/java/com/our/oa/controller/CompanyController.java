package com.our.oa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.CompanyDTO;
import com.our.oa.dto.list.CompanyListDTO;
import com.our.oa.dto.list.CompanyListQueryDTO;
import com.our.oa.service.CompanyService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
	@Autowired
	private CompanyService service;

	@GetMapping(value = "/list")
	public ModelAndView list(ModelAndView modelAndView) {
		
		modelAndView.setViewName("company/companylist");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDTO<CompanyListDTO> listData(
			CompanyListQueryDTO listQueryDTO) {
		
		Page<CompanyListDTO> queryList = service.getQueryList(listQueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
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
			ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("company/companyAdd");
			modelAndView.addObject("companyForm", companyForm);
			return modelAndView;
		}

		service.insert(companyForm);

		modelAndView.setViewName("company/companyList");
		modelAndView.addObject("companyForm", companyForm);

		return modelAndView;
	}

	@GetMapping(value = "/editor/{id}")
	public ModelAndView editor(@PathVariable(name = "id", required = false) Integer id, 
			ModelAndView modelAndView) {

		CompanyDTO dto = service.getByPrimaryKey(id);
		modelAndView.setViewName("company/companyEditor");
		modelAndView.addObject("companyForm", dto);
		return modelAndView;
	}

	@PostMapping(value = "/editor")
	public ModelAndView editor(@Valid CompanyDTO companyForm, BindingResult bindingResult, 
			ModelAndView modelAndView) {
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("company/companyEditor");
			return modelAndView;
		}

		service.updateByPrimaryKey(companyForm);

		modelAndView.setViewName("company/companyList");
		modelAndView.addObject("companyForm", companyForm);

		return modelAndView;
	}

	@GetMapping(value = "/detailed/{id}")
	public ModelAndView detailed(@PathVariable(name = "id", required = false) Integer id, 
			ModelAndView modelAndView) {

		CompanyDTO dto = service.getByPrimaryKey(id);
		modelAndView.setViewName("company/companyDetailed");
		modelAndView.addObject("companyForm", dto);
		return modelAndView;
	}
	
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id", required = false) Integer id, 
			ModelAndView modelAndView) {

		CompanyDTO dto = service.getByPrimaryKey(id);
		modelAndView.setViewName("company/companyDelete");
		modelAndView.addObject("companyForm", dto);
		return modelAndView;
	}
	
	@PostMapping(value = "/delete")
	public ModelAndView delete(@Valid CompanyDTO companyForm, BindingResult bindingResult, 
			ModelAndView modelAndView) {
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
		}

		service.deleteByPrimaryKey(companyForm.getCompanyId());

		modelAndView.setViewName("company/companyList");
		modelAndView.addObject("companyForm", companyForm);

		return modelAndView;
	}
}