package com.our.oa.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.our.oa.dao.MailingCustomerMapper;
import com.our.oa.dao.MailingMapper;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.entity.Mailing;
import com.our.oa.entity.MailingCustomer;
import com.our.oa.service.CustomerService;

public class OUR001SendMailThread implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(OUR001SendMailThread.class);

	private JavaMailSender javaMailSender;
	private CustomerService cusromerservice;
	private MailingCustomerMapper mailingCustomerMapper;
	private MailingMapper mailingMapper;
	
	

	private Map<String, Object> sendParam;
		
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		try {
			logger.info("send mail thread start!");
			logger.info("send mail data: " + mailingMapper.toString());
			List<Integer> customerIdList = (List<Integer>)sendParam.get("customeridList");
			//根据sendMailType判断是发送给营业还是提案担当
			int sendMailType = (Integer)sendParam.get("sendMailType");
			
			for (Integer integer : customerIdList) {
				CustomerDTO customerDTO =  cusromerservice.getByPrimaryKey(integer);
				String customerName = customerDTO.getCustomerName();
				logger.info("sendMailType is: " + sendMailType + "  " + "CustomerName is: " + customerName);
				if (sendMailType == 1) {
					String sendSalesStaff = customerDTO.getSalesStaff();
					String mailContest = getMailTest(customerName,sendSalesStaff);
					String mailAddress = customerDTO.getSalesEmail();
					logger.info("Send mailAddress: " + mailAddress + "  " + "mailContest: " + mailContest);
					if (!mailContest.isEmpty() && !mailAddress.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest,mailAddress);
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(customerName);
						insMailCus.add(mailAddress);
						insMailCus.add(sendSalesStaff);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
				} else {
					//发送提案邮箱1
					String sendProposal1Handler = customerDTO.getProposal1Handler();
					String mailContest1 = getMailTest(customerName,sendProposal1Handler);
					String mailAddress1 = customerDTO.getProposal1Email();
					logger.info("Send mailAddress1: " + mailAddress1 + "  " + "mailContest1: " + mailContest1);
					if (!mailContest1.isEmpty() && !mailAddress1.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest1,mailAddress1);
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(customerName);
						insMailCus.add(mailAddress1);
						insMailCus.add(sendProposal1Handler);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
					//发送提案邮箱2
					String sendProposal2Handler = customerDTO.getProposal2Handler();
					String mailContest2 = getMailTest(customerName,sendProposal2Handler);
					String mailAddress2 = customerDTO.getProposal1Email();
					logger.info("Send mailAddress2: " + mailAddress2 + "  " + "mailContest2: " + mailContest2);
					if (!mailContest2.isEmpty() && !mailAddress2.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest2,mailAddress2);
						//调用数据层，插入到已发送邮件的表
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(customerName);
						insMailCus.add(mailAddress2);
						insMailCus.add(sendProposal2Handler);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
					//发送提案邮箱3
					String sendProposal3Handler = customerDTO.getProposal3Handler();
					String mailContest3 = getMailTest(customerName,sendProposal3Handler);
					String mailAddress3 = customerDTO.getProposal1Email();
					logger.info("Send mailAddress3: " + mailAddress3 + "  " + "mailContest3: " + mailContest3);
					if (!mailContest3.isEmpty() && !mailAddress3.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest3,mailAddress3);
						//调用数据层，插入到已发送邮件的表
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(customerName);
						insMailCus.add(mailAddress3);
						insMailCus.add(sendProposal3Handler);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
				}
					
			} 
			updateMainingSendStata(1);
			logger.info("send mail thread end!");
		} catch (Exception e) {
			updateMainingSendStata(2);
			logger.info("send mail thread happen Exception!");
		}
	}

	@SuppressWarnings("unchecked")
	public boolean sendSimpleMail(String mailContest,String mailAddress) {
		logger.info("send SimpleMail start!");
        System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true ,"UTF-8");
            // 设置发件人邮箱
            helper.setFrom(sendParam.get("senderMailAddress").toString());
            // 设置收件人邮箱
            helper.setTo(mailAddress);
            // 设置邮件标题
            helper.setSubject(sendParam.get("emailtitle").toString());
            // 添加正文（使用thymeleaf模板）
            helper.setText(mailContest);
            
            // 添加附件
            List<Map<String, Object>> failPass = (List<Map<String, Object>>)sendParam.get("filesPass");
            if (failPass != null) {
            	for (Map<String, Object> map : failPass) {
    				String fileName = (String)map.get("fileName");
    				FileSystemResource fileSystemResource = (FileSystemResource)map.get("fileSystemResource");
    				helper.addAttachment(fileName, fileSystemResource);
                }
			}
            // 发送邮件
            javaMailSender.send(mimeMessage);
            logger.info("send SimpleMail end!");
            return true;
        } catch (Exception e) {
        	logger.error("send failed mail Address: " + mailAddress);
        	logger.error(e.toString());
            return false;
        }
    }
	
	private String getMailTest(String customerName,  String handlerName) {
		if (!customerName.isEmpty() && !handlerName.isEmpty()) {
			String contentString = customerName + "\n"
					+handlerName+"　様"+"\n"
					+sendParam.get("emailcontext");
			return contentString;
		} else {
			return "";
		}
		
	}
	
	private Integer insertMailingCustomer(List<String> insMailCus, boolean sendResult,Integer customerId) {
		try {
			logger.info("insert into MailingCustomer table start!");
			MailingCustomer mailingCustomer = new MailingCustomer();
			mailingCustomer.setMailingId((Integer)sendParam.get("mailingId"));
			mailingCustomer.setSendResult(sendResult);
			mailingCustomer.setSendTime(new Date());
			mailingCustomer.setCustomerId(customerId);
			mailingCustomer.setCustomerName(insMailCus.get(0));
			mailingCustomer.setSendMailAddress(insMailCus.get(1));
			mailingCustomer.setSendCustomerName(insMailCus.get(2));
			
			int insResult = mailingCustomerMapper.insert(mailingCustomer);
			logger.info("insert into MailingCustomer table end!");
			return insResult;
		} catch (Exception e) {
			logger.error("insert into MailingCustomer table happen Exception!" + e);
			return 0;
		}
	}
	
	private void updateMainingSendStata(Integer mailStats) {
		try {
			logger.info("update mailing table sendStats start!");
			Mailing mailing = mailingMapper.selectByPrimaryKey((Integer)sendParam.get("mailingId"));
			Date date = new Date();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ssS");
			String nowdate = sdf.format(date);
			mailing.setMailStats(mailStats);
			mailing.setEndTime(nowdate);
			mailing.setUpdateTime(date);
			mailingMapper.updateByPrimaryKey(mailing);
			logger.info("update mailing table sendStats end!");
		} catch (Exception e) {
			logger.error("update mailing table sendStats happen Exception!");
			logger.error(e.toString());
		}
		
		
	}
	
	public void setMapParam(Map<String, Object> sendParam) {
		this.sendParam = sendParam;
	}
	public void setMailingMapper(MailingMapper mailingMapper) {
		this.mailingMapper = mailingMapper;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setCusromerservice(CustomerService cusromerservice) {
		this.cusromerservice = cusromerservice;
	}

	public void setMailingCustomerMapper(MailingCustomerMapper mailingCustomerMapper) {
		this.mailingCustomerMapper = mailingCustomerMapper;
	}
}
