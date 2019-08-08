package com.our.oa.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
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
	private JavaMailSender javaMailSender;
	private CustomerService cusromerservice;
	private MailingCustomerMapper mailingCustomerMapper;
	private MailingMapper mailingMapper;
	
	

	private Map<String, Object> sendParam;
		
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		try {
			List<Integer> customerIdList = (List<Integer>)sendParam.get("customeridList");
			//根据sendMailType判断是发送给营业还是提案担当
			int sendMailType = (Integer)sendParam.get("sendMailType");
			
			for (Integer integer : customerIdList) {
				CustomerDTO customerDTO =  cusromerservice.getByPrimaryKey(integer);
				String CustomerName = customerDTO.getCustomerName();
				if (sendMailType == 1) {
					String sendSalesStaff = customerDTO.getSalesStaff();
					String mailContest = getMailTest(CustomerName,sendSalesStaff);
					String mailAddress = customerDTO.getSalesEmail();
					if (!mailContest.isEmpty() && !mailAddress.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest,mailAddress);
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(CustomerName);
						insMailCus.add(mailAddress);
						insMailCus.add(sendSalesStaff);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
				} else {
					//发送提案邮箱1
					String sendProposal1Handler = customerDTO.getProposal1Handler();
					String mailContest1 = getMailTest(CustomerName,sendProposal1Handler);
					String mailAddress1 = customerDTO.getProposal1Email();
					if (!mailContest1.isEmpty() && !mailAddress1.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest1,mailAddress1);
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(CustomerName);
						insMailCus.add(mailAddress1);
						insMailCus.add(sendProposal1Handler);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
					//发送提案邮箱2
					String sendProposal2Handler = customerDTO.getProposal2Handler();
					String mailContest2 = getMailTest(CustomerName,sendProposal2Handler);
					String mailAddress2 = customerDTO.getProposal1Email();
					if (!mailContest2.isEmpty() && !mailAddress2.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest2,mailAddress2);
						//调用数据层，插入到已发送邮件的表
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(CustomerName);
						insMailCus.add(mailAddress2);
						insMailCus.add(sendProposal2Handler);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
					//发送提案邮箱3
					String sendProposal3Handler = customerDTO.getProposal3Handler();
					String mailContest3 = getMailTest(CustomerName,sendProposal3Handler);
					String mailAddress3 = customerDTO.getProposal1Email();
					if (!mailContest3.isEmpty() && !mailAddress3.isEmpty()) {
						boolean sendResult = sendSimpleMail(mailContest3,mailAddress3);
						//调用数据层，插入到已发送邮件的表
						List<String> insMailCus = new ArrayList<>();
						insMailCus.add(CustomerName);
						insMailCus.add(mailAddress3);
						insMailCus.add(sendProposal3Handler);
						insertMailingCustomer(insMailCus,sendResult,integer);
					}
				}
					
			} 
			updateMainingSendStata(1);
		} catch (Exception e) {
			updateMainingSendStata(2);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean sendSimpleMail(String mailContest,String mailAddress) {

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
            return true;
        } catch (Exception e) {
            System.out.println("发送失败的邮箱地址：" + mailAddress);
            return false;
        }
    }
	
	private String getMailTest(String customerName,  String handlerName) {
		if (!customerName.isEmpty() && !handlerName.isEmpty()) {
			String contentString = "["+customerName+"]"+ "\n"
					+handlerName+"様"+"\n"
					+sendParam.get("emailcontext");
			return contentString;
		} else {
			return "";
		}
		
	}
	
	private Integer insertMailingCustomer(List<String> insMailCus, boolean sendResult,Integer customerId) {
		try {
			MailingCustomer mailingCustomer = new MailingCustomer();
			mailingCustomer.setMailingId((Integer)sendParam.get("mailingId"));
			mailingCustomer.setSendResult(sendResult);
			mailingCustomer.setSendTime(new Date());
			mailingCustomer.setCustomerId(customerId);
			mailingCustomer.setCustomerName(insMailCus.get(0));
			mailingCustomer.setSendMailAddress(insMailCus.get(1));
			mailingCustomer.setSendCustomerName(insMailCus.get(2));
			
			int insResult = mailingCustomerMapper.insert(mailingCustomer);
			return insResult;
		} catch (Exception e) {
			System.out.println("插入MailCustomer表失败！");
			return 0;
		}
	}
	
	private void updateMainingSendStata(Integer mailStats) {
		try {
			Mailing mailing = mailingMapper.selectByPrimaryKey((Integer)sendParam.get("mailingId"));
			Date date = new Date();
			mailing.setMailStats(mailStats);
			mailing.setEndTime(date);
			mailing.setUpdateTime(date);
			mailingMapper.updateByPrimaryKey(mailing);
		} catch (Exception e) {
			System.out.println("updateMainingSendStata Error！");
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
