package com.our.oa.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.list.OUR002MailRecordDetailResponseDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoRequestDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoResponseDTO;
import com.our.oa.service.OUR002SendMailRecordService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value = "/OUR002")
public class OUR002SendMailRecordController {
	@Autowired
	private OUR002SendMailRecordService service;
	
	@GetMapping(value = "/sendmailrecord")
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("email/sendmailrecord");
		return modelAndView;
	}
	
	@PostMapping(value="/sendmailrecord")
	public GridDTO<OUR002SendMailRecordInfoResponseDTO> getSendMailRecord(HttpServletRequest req,
			OUR002SendMailRecordInfoRequestDTO requersDTO) {
		
		Page<OUR002SendMailRecordInfoResponseDTO> queryList = service.getQueryList(requersDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	
	@GetMapping(value = "/detailed/{id}")
	public ModelAndView getMaildetailed(@PathVariable(name = "id", required = false) 
										Integer id, ModelAndView modelAndView) {
		System.out.println("www");
		Page<OUR002MailRecordDetailResponseDTO> queryList = service.getMailRecordDetail(id);
		modelAndView.setViewName("email/mailrecorddetail");
		modelAndView.addObject("list", queryList);
		return modelAndView;
	}

}
