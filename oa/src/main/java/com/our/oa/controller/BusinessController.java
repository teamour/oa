package com.our.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.SalesRecordDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.service.BusinessService;
import com.our.oa.service.EmployeeService;
import com.our.oa.service.EmployeeSiteService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;
    @Autowired
	private EmployeeService employeeService;
    @Autowired
	private EmployeeSiteService employeeSiteService;
	@GetMapping("/list")
	public ModelAndView listDataByEmployeeId(
			ModelAndView modelAndView) {
		modelAndView.setViewName("business/businessList");
		return modelAndView;
	}
	@PostMapping(value="/list")
	public GridDTO<EmployeeListDTO> listData(HttpServletRequest req,
			EmployeeListQueryDTO listQueryDTO) {
		
		
		List<Integer> ids = employeeSiteService.getIds();
		Page<EmployeeListDTO> queryList =null;
			listQueryDTO.setEmployeeIds(ids);
			System.out.println(listQueryDTO.getEmployeeIds());
			queryList= employeeService.getQueryList(listQueryDTO);
		
	    //System.out.println(listQueryDTO.getEmployeeId());
	    return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}

    @GetMapping(value = "/")
    public ModelAndView toAddPage(ModelAndView modelAndView){
        modelAndView.setViewName("business/businessAdd");
        return modelAndView;
    }
    @PostMapping(value="/")
	public ModelAndView save(SalesRecordDTO salesRecord) {
    	businessService.save(salesRecord);
        return new ModelAndView("redirect:list");
	}
     

}