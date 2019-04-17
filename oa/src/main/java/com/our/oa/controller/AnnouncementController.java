package com.our.oa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.our.oa.dto.AnnouncementDTO;
import com.our.oa.dto.GridDataDTO;
import com.our.oa.service.AnnouncementService;

@RestController
@RequestMapping(value="/announcement")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView modelAndView) {		
		modelAndView.setViewName("sys/announcementlist");
		return modelAndView;
	}
	
	@PostMapping(value="/list")
	public GridDataDTO<AnnouncementDTO> listData(HttpServletRequest req) {		
		List<AnnouncementDTO> list= new ArrayList<>();
		list.add(new AnnouncementDTO(1, "test", "description", new Date()));
		return new GridDataDTO<>(1, 1, 1, list);
	}
	
	
	@GetMapping(value= {"","/"})
	public ModelAndView add(ModelAndView modelAndView) {
		AnnouncementDTO dto = new AnnouncementDTO();
		modelAndView.addObject("announcementForm", dto);
		modelAndView.setViewName("sys/announcement");
		return modelAndView;
	}
	
	@GetMapping(value= "/{id}")
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
		modelAndView.setViewName("sys/announcement");
		return modelAndView;
	}
	
	@PostMapping(value="/")
	public String save(@Valid AnnouncementDTO announcementForm, 
			BindingResult bindingResult) {

		System.out.println("hello");
        if (bindingResult.hasErrors()) {
            return "sys/announcement";
        }
        
        announcementService.insert(announcementForm);
        
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
	
}
