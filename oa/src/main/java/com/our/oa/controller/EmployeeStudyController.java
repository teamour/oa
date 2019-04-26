package com.our.oa.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.AnnouncementDTO;
import com.our.oa.dto.form.EmployeeDTO;
import com.our.oa.dto.form.EmployeeSiteDTO;
import com.our.oa.dto.form.EmployeeStudyDTO;
import com.our.oa.dto.list.EmployeeListDTO;
import com.our.oa.dto.list.EmployeeListQueryDTO;
import com.our.oa.dto.list.EmployeeStudyListDTO;
import com.our.oa.dto.list.EmployeeStudyListQueryDTO;
import com.our.oa.entity.Employee;
import com.our.oa.entity.EmployeeStudy;
import com.our.oa.service.EmployeeService;
import com.our.oa.service.EmployeeStudyService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

import net.sf.json.JSONObject;


/**
 * Employee studey progress manager
 * @author Wangjiaqin
 *
 */
@RestController
@RequestMapping(value="/epst")
public class EmployeeStudyController {
	
	@Autowired
	private EmployeeService emplpyeeService;
	
	@Autowired
	private EmployeeStudyService employeeStudyService;
	
	@GetMapping(value = "/epstIndex")
	public ModelAndView epstIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("epst/epstIndex");
		return modelAndView;
	}
	@GetMapping(value= {"","/addepst"})
	public ModelAndView add(ModelAndView modelAndView) {
		modelAndView.setViewName("epst/addepst");
		return modelAndView;
	}
	@GetMapping(value= {"","/editepst"})
	public ModelAndView edit(ModelAndView modelAndView) {
		modelAndView.setViewName("epst/editepst");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/queryAllEmployee")
	public String query(HttpServletResponse resp) {
	
			List<Employee> list = emplpyeeService.getEmployeeForSyudy();
			JSONObject obj = new JSONObject();
			obj.put("code", 0);
	        obj.put("msg", "");
	        obj.put("count",1000);
	        obj.put("data",list);
	        return obj.toString();
			
	}
	@GetMapping(value="/")
	public GridDTO<EmployeeStudyListDTO> listDate(HttpServletRequest req,
			EmployeeStudyListQueryDTO listQueryDTO){
		System.out.println("进来了！！！");
		Page<EmployeeStudyListDTO> queryList = employeeStudyService.getQueryList(listQueryDTO);
	    return PageInfoToGridDTOUtils.getGridDataResult(queryList);
		
	}
	@GetMapping(value="/employeelist")
	public GridDTO<EmployeeListDTO> listDate1(HttpServletRequest req,
			EmployeeListQueryDTO listQueryDTO){
		System.out.println("进来了2！！！");
		Page<EmployeeListDTO> queryList = emplpyeeService.getQueryList(listQueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	
	@PostMapping(value="/addepst")
	public ModelAndView save(@Valid EmployeeStudyDTO employeeStudyForm, 
			BindingResult bindingResult,ModelAndView modelAndView) {
		
		
        if (bindingResult.hasErrors()) {
        	modelAndView.setViewName("epst/addepst");
        	System.out.println("error!");
        	
        	List<FieldError>  err=bindingResult.getFieldErrors();
            FieldError fe;
            String field;
            String errorMessage;
            for (int i = 0; i < err.size(); i++) {
                fe=err.get(i);
                field=fe.getField();//得到那个字段验证出错
                errorMessage=fe.getDefaultMessage();//得到错误消息
                System.out.println("错误字段消息："+field +" : "+errorMessage);
            }
            return modelAndView;
        }
        
        employeeStudyService.insert(employeeStudyForm);
        
        System.out.println(employeeStudyForm.getBeginDate());
        // 保存成功后返回列表页
        modelAndView.setViewName("redirect:epstIndex");
        System.out.println("secuss!");
        return modelAndView;
	}
	@GetMapping(value = "/editepst/{id}")
	public ModelAndView view(@PathVariable(name="id",required=false)Integer id, ModelAndView modelAndView) {
		EmployeeStudyDTO dto = new EmployeeStudyDTO();
		if (id != null) {
			
			EmployeeStudy employeeStudy = employeeStudyService.getByPrimaryKey(id);
			ModelMapper mapper = new ModelMapper();
			dto = mapper.map(employeeStudy, EmployeeStudyDTO.class);
			
		}
		modelAndView.addObject("employeeStudy",dto);
		modelAndView.setViewName("epst/editepst");
		return modelAndView;
	}
		
	@PostMapping(value="/editepst/{id}")
	public ModelAndView Update(@Valid EmployeeStudyDTO emplyoeeStudy,
			BindingResult bindingResult,ModelAndView modelAndView,
			@PathVariable(name="id",required=false)Integer id) {
				System.out.println("zzzzz!!");
			emplyoeeStudy.setEmployeeStudyId(id);
			employeeStudyService.update(emplyoeeStudy);
			if (bindingResult.hasErrors()) {
				System.out.println("error!");
	        	
	        	List<FieldError>  err=bindingResult.getFieldErrors();
	            FieldError fe;
	            String field;
	            String errorMessage;
	            for (int i = 0; i < err.size(); i++) {
	                fe=err.get(i);
	                field=fe.getField();//得到那个字段验证出错
	                errorMessage=fe.getDefaultMessage();//得到错误消息
	                System.out.println("错误字段消息："+field +" : "+errorMessage);
			}
			}
        // 保存成功后返回列表页
        modelAndView.setViewName("redirect:/epst/epstIndex");
        return modelAndView;
	}

	// 删除
		@RequestMapping(value = "/deleteByIds" )
		public String delete( Integer... ids) {
			// 获取 页面上选中的id（可以多个） 进行删除炒作
			
			//employeeService.deleteBydIds(Ids);
			for (Integer id : ids) {
				employeeStudyService.updateForDelete(id);
				System.out.println(id);
			}
			System.out.println(ids);
			// 删除成功后重新进入列表页
			return "delete ok";
		}
		
}
