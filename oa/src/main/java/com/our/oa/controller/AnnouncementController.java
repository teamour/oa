package com.our.oa.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.AnnouncementDTO;
import com.our.oa.dto.list.AnnouncementListDTO;
import com.our.oa.dto.list.AnnouncementListQueryDTO;
import com.our.oa.service.AnnouncementService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value="/announcement")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;
	
	//显示列表页
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView modelAndView) {		
		modelAndView.setViewName("sys/announcementlist");
		return modelAndView;
	}
	
	//查询列表数据
	@PostMapping(value="/list")
	public GridDTO<AnnouncementListDTO> listData(HttpServletRequest req,
			AnnouncementListQueryDTO listQueryDTO) {	

	    Page<AnnouncementListDTO> queryList = announcementService.getQueryList(listQueryDTO);
	    
	    return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	
	// 添加页面
	@GetMapping(value= {"","/"})
	public ModelAndView add(ModelAndView modelAndView) {
		AnnouncementDTO dto = new AnnouncementDTO();
		modelAndView.addObject("announcementForm", dto);
		modelAndView.setViewName("sys/announcementadd");
		return modelAndView;
	}
	
	// 查看页面
	@GetMapping(value= "/view/{id}")
	public ModelAndView view(@PathVariable(name="id",required=false)Integer id, ModelAndView modelAndView) {
		AnnouncementDTO dto = new AnnouncementDTO();
		if(null != id && id > 0) {
			// 模拟查找数据
			dto = AnnouncementDTO.builder().announcementId(1).title("test").description("description").createTime(new Date()).build();
			/*Announcement announcement = announcementService.getByPrimaryKey(id);
			ModelMapper modelMapper = new ModelMapper();
			dto = modelMapper.map(announcement, AnnouncementDTO.class);*/
		}		
		modelAndView.addObject("announcementForm", dto);
		modelAndView.setViewName("sys/announcementview");
		return modelAndView;
	}
	
	// 修改页面
	@GetMapping(value= "/{id}")
	public ModelAndView update(@PathVariable(name="id",required=false)Integer id, ModelAndView modelAndView) {
		AnnouncementDTO dto = new AnnouncementDTO();
		if(null != id && id > 0) {
			// 模拟查找数据
			dto = AnnouncementDTO.builder().announcementId(1).title("test").description("description").createTime(new Date()).build();
			/*Announcement announcement = announcementService.getByPrimaryKey(id);
			ModelMapper modelMapper = new ModelMapper();
			dto = modelMapper.map(announcement, AnnouncementDTO.class);*/
		}		
		modelAndView.addObject("announcementForm", dto);
		modelAndView.setViewName("sys/announcementupdate");
		return modelAndView;
	}
	
	// 添加的保存
	@PostMapping(value="/")
	public String save(@Valid AnnouncementDTO announcementForm, 
			BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "sys/announcementadd";
        }
        
        announcementService.insert(announcementForm);        
        // 保存成功后返回列表页
        return "sys/announcementlist";
	}
	
	// 修改
	@PutMapping(value="/")
	public String update(@Valid AnnouncementDTO announcementForm, 
			BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "sys/announcementupdate";
        }
        
        announcementService.update(announcementForm);        
        // 保存成功后返回列表页
        return "sys/announcementlist";
	}
	
	// 删除
	@RequestMapping(value = "/" ,method = RequestMethod.DELETE)
	public String delete(HttpServletRequest req) {
		// 获取 页面上选中的id（可以多个） 进行删除炒作
		// 删除成功后重新进入列表页
		return "sys/announcementlist";
	}
	//公告
	@GetMapping(value = "/announcement")
	public ModelAndView announcement(ModelAndView modelAndView) {
		AnnouncementDTO dto = new AnnouncementDTO();
		announcementService.getByPrimaryKey(1);
		modelAndView.addObject("announcementForm", dto);
		modelAndView.setViewName("sys/anno");
		return modelAndView;
	}
}
