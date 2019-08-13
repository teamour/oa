package com.our.oa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoRequestDTO;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoResponseDTO;
import com.our.oa.service.OUR001MailOperationService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

@RestController
@RequestMapping(value = "/OUR001")
public class OUR001MailOperationController {
	private static final Logger logger = LoggerFactory.getLogger(OUR001MailOperationController.class);
	@Autowired
	private OUR001MailOperationService service;
	
	
	@GetMapping(value = "/list")
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("email/sendmailcustomer");
		return modelAndView;
	}
	@PostMapping(value="/list")
	public GridDTO<OUR001SendMailCustomerInfoResponseDTO> query(HttpServletRequest req,
			 OUR001SendMailCustomerInfoRequestDTO requestDTO) {
		logger.info("get sendmail customer info start!");
		
		Page<OUR001SendMailCustomerInfoResponseDTO> queryList=null;
		queryList = service.getQueryList(requestDTO);
		GridDTO<OUR001SendMailCustomerInfoResponseDTO> result = PageInfoToGridDTOUtils.getGridDataResult(queryList);
		
		logger.info("get sendmail customer info end!");
		return result;
	}

	@PostMapping(value = "/sendemail")
	public ModelAndView save(@RequestParam("sendMailType") String sendMailType, 
			@RequestParam("customerids") String customerids,
			@RequestParam("emailtitle") String emailtitle,
			@RequestParam("emailcontext") String emailcontext,HttpServletRequest request,
			@RequestParam("emailfile") MultipartFile[] files,
			ModelAndView modelAndView) throws IOException, FileUploadException {
		
		try {
			logger.info("send mail start!");
			Map<String,Object> data = new HashMap<>();
			String pathRoot = String.valueOf(request.getSession().getServletContext().getRealPath("/"));
			data.put("emailfile", files);
			data.put("pathRoot", pathRoot);
			data.put("sendMailType", sendMailType);
			data.put("customerids", customerids);
			data.put("emailtitle", emailtitle);
			data.put("emailcontext", emailcontext);
			boolean resule = service.sendMailToCustomerOUR001(data);
			if (resule) {
				modelAndView.setViewName("email/sendmailrecord");
				logger.info("send mail end!");
				return modelAndView;
			} else {
				logger.info("send mail happen error!");
				return null;
			}
		} catch (Exception e) {
			logger.info("send mail happen Exception!");
			return null;
		}
		
	}
}
