package com.our.oa.controller; 



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.entity.DictionaryDetail;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeSite;
import com.our.oa.service.DictionaryService;
import com.our.oa.service.EmployeeService;
import com.our.oa.service.EmployeeSiteService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeSiteService employeeSiteService;
	@Autowired
	private DictionaryService dicService;
	@GetMapping("/list")
	public ModelAndView listDataByEmployeeId(
			ModelAndView modelAndView) {
		modelAndView.setViewName("emp/employeeList");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDTO<EmployeeListDTO> listData(HttpServletRequest req,
			EmployeeListQueryDTO listQueryDTO) {	
	    Page<EmployeeListDTO> queryList = employeeService.getQueryList(listQueryDTO);
	    //System.out.println(listQueryDTO.getEmployeeId());
	    return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	@GetMapping(value= {"","/"})
	public ModelAndView add(ModelAndView modelAndView) {
		//EmployeeDTO dto = new EmployeeDTO();
		//modelAndView.addObject("employeeForm", dto);
		modelAndView.setViewName("emp/employeeAdd");
		return modelAndView;
	}
	@PostMapping(value="/")
	public ModelAndView save(@Valid EmployeeDTO emplyoee,@Valid EmployeeSiteDTO emplyoeeSite,
			BindingResult bindingResult,ModelAndView modelAndView) {
        	 
		employeeService.insert(emplyoee,emplyoeeSite);
        return new ModelAndView("redirect:list");
	}
	//根据ID查询员工
	@GetMapping(value= "/{id}")
	public ModelAndView view(@PathVariable(name="id",required=false)Integer id, 
			ModelAndView modelAndView) {
			System.out.println(id);
			EmployeeDTO dto = new EmployeeDTO();
			Employee employee = employeeService.getByPrimaryKey(id);
			ModelMapper modelMapper = new ModelMapper();
			dto = modelMapper.map(employee, EmployeeDTO.class);
			modelAndView.addObject("employee", dto);
			
			EmployeeSiteDTO dto1 = new EmployeeSiteDTO();
			EmployeeSite employeeSite = employeeService.getByEmployeeId(id);
			dto1 = modelMapper.map(employeeSite, EmployeeSiteDTO.class);
			modelAndView.addObject("employeeSite", dto1);
			modelAndView.setViewName("emp/employeeEdit");
			return modelAndView;
	}
	// 删除
	@RequestMapping(value = "/deleteByIds" )
	public String delete(Integer... ids) {
		// 获取 页面上选中的id（可以多个） 进行删除炒作
		
		//employeeService.deleteBydIds(Ids);
		for (Integer id : ids) {
			employeeService.deleteBydIds(id);
			System.out.println(id);
		}
		System.out.println(ids);
		// 删除成功后重新进入列表页
		return "delete ok";
	}
	
	@PostMapping(value="/update/{id}")
	public ModelAndView Update(@Valid EmployeeDTO emplyoee,@Valid EmployeeSiteDTO emplyoeeSite,
			BindingResult bindingResult,ModelAndView modelAndView,
			@PathVariable(name="id",required=false)Integer id) {
			if (id!=null|id!=0) {
				emplyoee.setEmployeeId(id);
				employeeService.update(emplyoee);
				emplyoeeSite.setEmployeeId(id);
				employeeSiteService.update(emplyoeeSite);
			}
			System.out.println(emplyoeeSite.getEmployeeId());
        // 保存成功后返回列表页
			modelAndView.setViewName("redirect:/emp/list");
        return modelAndView;
	}
	//根据ID查询员工
	@GetMapping(value= "/detailed/{id}")
	public ModelAndView employeeDetailed(@PathVariable(name="id",required=false)Integer id, 
				ModelAndView modelAndView) {
				System.out.println(id);
				EmployeeDTO dto = new EmployeeDTO();
				Employee employee = employeeService.getByPrimaryKey(id);
				ModelMapper modelMapper = new ModelMapper();
				dto = modelMapper.map(employee, EmployeeDTO.class);
				dto.setSkillScoreStr(dicService.getDetailName(16, (int)employee.getSkillScore()-1));
				dto.setJapaneseLevel(dicService.getDetailName(17, (int)employee.getJapaneseLevel()-1));
				dto.setSkillLevel(dicService.getDetailName(18, (int)employee.getSkillLevel()-1));
				
				modelAndView.addObject("employee", dto);
				
				
				
				EmployeeSiteDTO dto1 = new EmployeeSiteDTO();
				EmployeeSite employeeSite = employeeService.getByEmployeeId(id);
				dto1 = modelMapper.map(employeeSite, EmployeeSiteDTO.class);
				modelAndView.addObject("employeeSite", dto1);
				modelAndView.setViewName("emp/employeeDetailed");
				return modelAndView;
	}
	@PostMapping(value = "/dicNames/{id}")
	public List<DictionaryDetail> getDicNames(@PathVariable(name = "id", required = false) Integer id) {
		return dicService.getDetailNames(id);
	}
}
