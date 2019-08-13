package com.our.oa.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.MimeUtility;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.Page;
import com.our.oa.controller.OUR002SendMailRecordController;
import com.our.oa.dao.CustomerMapper;
import com.our.oa.dao.MailingCustomerMapper;
import com.our.oa.dao.MailingMapper;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoRequestDTO;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoResponseDTO;
import com.our.oa.entity.Mailing;
import com.our.oa.service.CustomerService;
import com.our.oa.service.OUR001MailOperationService;

@Service
public class OUR001MailOperationServiceImpl implements OUR001MailOperationService{
	private static final Logger logger = LoggerFactory.getLogger(OUR001MailOperationServiceImpl.class);
	@Autowired
	private CustomerMapper mapper;
	@Autowired
	private CustomerService cusromerservice;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private MailingCustomerMapper mailingCustomerMapper;
	@Autowired 
	private MailingMapper mailingMapper;
	@Value("${spring.mail.username}")
    private String senderMailAddress;
	
	@Override
	public List<OUR001SendMailCustomerInfoResponseDTO> getSendMailCustomerInfoOUR001(
			OUR001SendMailCustomerInfoRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sendMailToCustomerOUR001(Map<String, Object> requestDTO) {
		try {
			logger.info("send Mail To Customer Service start！");
			//get filesPass
			MultipartFile[] files = (MultipartFile[])requestDTO.get("emailfile");
			String pathRoot = (String)requestDTO.get("pathRoot");
			List<Map<String, Object>> filesPass = getFileNameAndParm(files,pathRoot);
			//get customeridList
			List<Integer> customeridList = getListCustomerid((String)requestDTO.get("customerids"));
			//装配线程内需要的数据
			logger.info("send mail Address:" + senderMailAddress);
			requestDTO.put("filesPass", filesPass);
			requestDTO.put("customeridList", customeridList);
			requestDTO.put("senderMailAddress", senderMailAddress);
			requestDTO.put("sendMailType", getIntegerSendMailType((String)requestDTO.get("sendMailType")));
			
			//1将本次任务插入任务表2获取到本次任务的任务id并存入requestDTO
			Integer mailingId = insertMailing(requestDTO);
			requestDTO.put("mailingId", mailingId);
			if (mailingId < 0) {
				return false;
			}
			//启用线程发送邮件
			OUR001SendMailThread sendMailThread = new OUR001SendMailThread();
			sendMailThread.setMapParam(requestDTO);
			sendMailThread.setCusromerservice(cusromerservice);
			sendMailThread.setJavaMailSender(javaMailSender);
			sendMailThread.setMailingCustomerMapper(mailingCustomerMapper);
			sendMailThread.setMailingMapper(mailingMapper);
			Thread thread = new Thread(sendMailThread);
			thread.setName("sendMailThred");
			thread.start();
			logger.info("send Mail To Customer Service end！");
			return true;
		} catch (Exception e) {
			logger.info("send Mail To Customer Service happen Exception！");
			return false;
		}
	}

	@Override
	public Page<OUR001SendMailCustomerInfoResponseDTO> getGridList(OUR001SendMailCustomerInfoRequestDTO requestDTO) {
		Integer companyType = getIntegerCompanyType(requestDTO.getCompanyType());
		Integer cooperationIntention = getIntegerCooperationIntention(requestDTO.getCooperationIntention());
		
		Page<OUR001SendMailCustomerInfoResponseDTO> queryResult = mapper.getSendMailCustomerInfoOUR001(companyType,cooperationIntention);
		return queryResult;
	}
	
	private int getIntegerCompanyType(String companyType) {
		if (companyType.equalsIgnoreCase("JPCustomer")) {
			return 0;
		} else if (companyType.equalsIgnoreCase("CHCustomer")) {
			return 1;
		} else {
			return 2;
		}
	}
	
	private Integer getIntegerCooperationIntention(String CooperationIntention) {
		if (CooperationIntention.equalsIgnoreCase("CooperationNothing")) {
			return 0;
		} else if (CooperationIntention.equalsIgnoreCase("CooperationLow")) {
			return 1;
		} else if (CooperationIntention.equalsIgnoreCase("CooperationMid")) {
			return 2;
		} else if (CooperationIntention.equalsIgnoreCase("CooperationHigh")) {
			return 3;
		} else if (CooperationIntention.equalsIgnoreCase("CooperationHaved")) {
			return 4;
		} else if (CooperationIntention.equalsIgnoreCase("Cooperationhaving")) {
			return 5;
		} else {
			return 6;
		}
	}
	
	private Integer getIntegerSendMailType(String sendMailType) {
		if (sendMailType.equalsIgnoreCase("salesStaff")) {
			return 1;
		} else {
			return 2;
		}
		
	}
	//获取可以直接发送的附件内容
	private List<Map<String, Object>> getFileNameAndParm(MultipartFile[] files, String pathRoot) throws IllegalStateException, IOException {
		if (StringUtils.isNotBlank(files[0].getOriginalFilename())) {
			logger.info("get files name and path start!");
			//存放附件
			List<Map<String, Object>> filePassList = new ArrayList<>();
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				Map<String, Object> failMap = new HashMap<>();
				
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
					
				FileSystemResource fileSystemResource = new FileSystemResource(new File(newpath));
                String fileName = newpath.substring(newpath.lastIndexOf(File.separator));
                //阶段string去掉uuid
                fileName = fileName.substring(34);
                    
                fileName = MimeUtility.encodeWord(fileName);
                failMap.put("fileName", fileName);
                failMap.put("fileSystemResource", fileSystemResource);
                filePassList.add(failMap);
				
			}
			logger.info("get files name and path end!");
			return filePassList;
		}
		logger.info("havent files name and path!");
		return null;
		
	}
	
	@SuppressWarnings("unused")
	private List<Integer> getListCustomerid(String customerids) {
		logger.info("split customerid add to List start!");
		String[] cuStrings = customerids.split(",");
		List<Integer> customerList = new ArrayList<>();
		Pattern pattern = Pattern.compile("[0-9]*");
		for (String string : cuStrings) {
			Matcher isNum = pattern.matcher(string);
			
			if (!string.isEmpty() && isNum.matches()) {
				customerList.add(Integer.valueOf(string));
			}
		}
		logger.info("split customerid add to List end!");
		return customerList;
	}
	
	@SuppressWarnings("unchecked")
	private Integer insertMailing(Map<String, Object> requestDTO) {
		try {
			logger.info("insert into Mailing table start!");
			Mailing maxMailingId = mailingMapper.selectMaxMailingId();
			int maxMainingId = 1;
			if (maxMailingId.getMailingId() != null) {
				maxMainingId = maxMailingId.getMailingId() + 1;
			}
			Mailing mailing = new Mailing();
			Date date = new Date();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ssS");
			String nowdate = sdf.format(date);
			System.out.println(sdf.format(date));
			mailing.setMailingId(maxMainingId);
			mailing.setBeginTime(nowdate);
			//send mail stats is sending
			mailing.setMailStats(0);
			mailing.setMailingTempleteContent((String)requestDTO.get("emailtitle"));
			mailing.setMailNumber(((List<Integer>)requestDTO.get("customeridList")).size());
			mailing.setMailingAimSummary(senderMailAddress);
			
			mailingMapper.insert(mailing);
			
			logger.info("insert into Mailing table end!");
			return maxMainingId;
		} catch (Exception e) {
			logger.error("insert into Mailing table happened Exception!");
			return -999;
		}
		
	}
}
