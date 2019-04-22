package com.our.oa.controller;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;
import com.our.oa.service.EmployeeService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/list")
	public ModelAndView listDataByEmployeeId(
			ModelAndView modelAndView) {
		modelAndView.setViewName("emp/employeelist");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDTO<EmployeeListDTO> listData(HttpServletRequest req,
			EmployeeListQueryDTO listQueryDTO) {	
	    PageInfo<EmployeeListDTO> queryList = employeeService.getQueryList(listQueryDTO);
	    return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	@GetMapping(value= {"","/"})
	public ModelAndView add(ModelAndView modelAndView) {
		//EmployeeDTO dto = new EmployeeDTO();
		//modelAndView.addObject("employeeForm", dto);
		modelAndView.setViewName("emp/employee");
		return modelAndView;
	}
	@PostMapping(value="/")
	public ModelAndView save(@Valid EmployeeDTO emplyoee,EmployeeSiteDTO emplyoeeSite,
			BindingResult bindingResult,ModelAndView modelAndView) {
        	 employeeService.insert(emplyoee,emplyoeeSite);
			
       
        // 保存成功后返回列表页
        modelAndView.setViewName("emp/employeelist");
        return modelAndView;
	}
	@GetMapping(value= "/{id}")
	public ModelAndView view(@PathVariable(name="id",required=false)Integer id, ModelAndView modelAndView) {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeSiteDTO dto1 = new EmployeeSiteDTO();
		if(null != id && id > 0) {
			// 模拟查找数据
			Employee employee = employeeService.getByPrimaryKey(id);
			EmployeeSite employeeSite = employeeService.getByEmployeeId(id);
			ModelMapper modelMapper = new ModelMapper();
			dto = modelMapper.map(employee, EmployeeDTO.class);
			dto1 = modelMapper.map(employeeSite, EmployeeSiteDTO.class);
			
		}
		
		
		  Boolean flag = dto.getDeleteFlag(); System.out.println(flag); 
		  if (!flag) {
		  modelAndView.setViewName("emp/deleted"); 
		  return modelAndView; }
		 
		 
		modelAndView.addObject("employee", dto);
		modelAndView.addObject("employeeSite", dto1);
		modelAndView.setViewName("emp/emp-manage");
		
		return modelAndView;
	}
	// 删除
	@RequestMapping(value = "/deleteByIds/{Ids}" )
	public String delete(@PathVariable Integer... Ids) {
		// 获取 页面上选中的id（可以多个） 进行删除炒作
		
		//employeeService.deleteBydIds(Ids);
		for (Integer id : Ids) {
			employeeService.deleteBydIds(id);
			System.out.println(id);
		}
		System.out.println(Ids);
		// 删除成功后重新进入列表页
		return "delete ok";
	}
	
	@PostMapping(value="/update/{id}")
	public ModelAndView Update(@Valid EmployeeDTO emplyoee,EmployeeSiteDTO emplyoeeSite,
			BindingResult bindingResult,ModelAndView modelAndView,
			@PathVariable(name="id",required=false)Integer id) {
			emplyoee.setEmployeeId(id);
			emplyoeeSite.setEmployeeId(id);
			employeeService.update(emplyoee,emplyoeeSite );
			System.out.println(emplyoeeSite.getEmployeeId());
        // 保存成功后返回列表页
        modelAndView.setViewName("emp/employeelist");
        return modelAndView;
	}
	
}
