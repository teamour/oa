package com.our.oa.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(OUR002SendMailRecordController.class);

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
		logger.info("POST: sendmailrecord start!");
		
		Page<OUR002SendMailRecordInfoResponseDTO> queryList = service.getQueryList(requersDTO);
		GridDTO<OUR002SendMailRecordInfoResponseDTO> result = PageInfoToGridDTOUtils.getGridDataResult(queryList);
		
		logger.info("POST: sendmailrecord end!");
		return result;
	}
	
	@GetMapping(value = "/detailed/{id}")
	public ModelAndView getMaildetailed(@PathVariable(name = "id", required = false) 
										Integer id, ModelAndView modelAndView) {
		logger.info("GET: mailrecord detail info start!");
		logger.info("selects id:" + id);
		
		Page<OUR002MailRecordDetailResponseDTO> queryList = service.getMailRecordDetail(id);
		modelAndView.setViewName("email/mailrecorddetail");
		modelAndView.addObject("list", queryList);
		
		logger.info("GET: mailrecord detail info end!");
		return modelAndView;
	}
	
	@PostMapping(value = "/delete" )
	public ModelAndView deleteSendRecord(String rows) {
		logger.info("delete send mail record start!");
		service.deleteSendMailRecord(rows);
		logger.info("delete send mail record end!");
		return new ModelAndView("email/sendmailrecord");
	}
}
