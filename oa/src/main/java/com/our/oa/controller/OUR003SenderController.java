package com.our.oa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.entity.Sender;
import com.our.oa.service.OUR003SenderService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value = "/OUR003")
public class OUR003SenderController {
	private static final Logger logger = LoggerFactory.getLogger(OUR002SendMailRecordController.class);

	@Autowired
	private OUR003SenderService service;
	
	@GetMapping(value = "/senderList")
	public ModelAndView senderList(ModelAndView modelAndView) {
		modelAndView.setViewName("email/senderList");
		return modelAndView;
	}
	
	@PostMapping(value="/senderList")
	public GridDTO<Sender> getSenderList() {
		logger.info("POST: senderList start!");
		
		Page<Sender> queryList = service.getSenderAll();
		GridDTO<Sender> result = PageInfoToGridDTOUtils.getGridDataResult(queryList);
		
		logger.info("POST: senderList end!");
		return result;
	}
	
	@GetMapping(value = "/addSender")
	public ModelAndView addSender(ModelAndView modelAndView) {
		modelAndView.setViewName("email/senderAdd");
		Sender form = new Sender();
		modelAndView.addObject("form", form);
		return modelAndView;
	}
	
	@PostMapping(value = "/addSender")
	public ModelAndView addSender(Sender sender) {
		logger.info("POST: addSender start!");
		
		service.insertSender(sender);
		
		logger.info("POST: addSender end!");
		return new ModelAndView("/email/senderList");
	}
	
	@PostMapping(value = "/deleteSender" )
	public ModelAndView delete(String rows) {
		service.deleteSender(rows);
		return new ModelAndView("redirect:/customer/list");
	}
	
	@PostMapping(value="/senderNameList")
	public List<Sender> getAllSenderName() {
		logger.info("POST: senderNameList start!");
		
		List<Sender> queryList = service.getSenderAll();
		
		logger.info("POST: senderNameList end!");
		return queryList;
	}
}
