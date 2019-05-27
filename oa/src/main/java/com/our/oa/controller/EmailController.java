package com.our.oa.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.form.EmailDTO;
import com.our.oa.entity.Customer;
import com.our.oa.service.CustomerService;
import com.our.oa.serviceimpl.EmailSendServiceImpl;

@RestController
@RequestMapping(value = "/email")
public class EmailController {
	@Autowired
	private CustomerService cusromerservice;
	
	@Autowired
	private EmailSendServiceImpl emailTool;

	@GetMapping(value = { "/sendemail" })
	public ModelAndView documentIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("email/sendemail");
		return modelAndView;
	}

	@PostMapping(value = "/sendemail")
	public ModelAndView save(@Valid EmailDTO emailForm, @RequestParam("emailfile") MultipartFile[] files,
			BindingResult bindingResult, HttpServletRequest request, ModelAndView modelAndView) throws IOException {

		Map<String, Object> valueMap = new HashMap<>();
		String customerId = request.getParameter("customer");
		int companyTypeIndex = -1;
		switch (customerId) {
		case "JPCustomer":
			System.out.println("选择日企");
			companyTypeIndex = 0;
			break;
		case "CHCustomer":
			System.out.println("选择国企");
			companyTypeIndex = 1;
			break;
		case "ALLCustomer":
			System.out.println("选择全部");
		default:
			break;
		}
		
		if (StringUtils.isNotBlank(files[0].getOriginalFilename())) {
			String[] filePath = new String[files.length];
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				try {
					// 绝对地址
					String pathRoot = String.valueOf(request.getSession().getServletContext().getRealPath("/"));
					UUID uuid = UUID.randomUUID();
					String strUUID = uuid.toString().replaceAll("-", "");
					String accessorypath = pathRoot + "resource\\mailaccessory";
					String newpath = accessorypath + "\\" + strUUID + "_" + file.getOriginalFilename();
					File newfile = new File(accessorypath, strUUID + "_" + file.getOriginalFilename());
					if (!newfile.getParentFile().exists()) {
						newfile.getParentFile().mkdirs();
					}
					file.transferTo(newfile);
					System.out.println(newpath);
					filePath[i] = newpath;
					valueMap.put("filePathList", filePath);
				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();

				}
			}

		}
		
		//CustomerDTO customerDTO = cusromerservice.getByCustomerType(companyTypeIndex);
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = cusromerservice.getByCustomerType(companyTypeIndex);
		System.out.println("size="+customerList.size());
		for (int i = 0; i < customerList.size(); i++) {
			String emailString = customerList.get(i).getProposal1Email();
			String handlerString = customerList.get(i).getProposal1Handler();
			String customerNameString = customerList.get(i).getCustomerName();
			String contentString = "["+customerNameString+"]"+ "\n"
					+handlerString+"様"+"\n"
					+emailForm.getEmailcontext();
			
			valueMap.put("to", new String[] { emailString});
			valueMap.put("title", emailForm.getEmailtitle());
			valueMap.put("content", contentString);
			emailTool.sendSimpleMail(valueMap);
			System.out.println("email="+emailString);
		}
		

		modelAndView.setViewName("redirect:sendemail");
		return modelAndView;
	}

}
