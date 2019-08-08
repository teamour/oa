package com.our.oa.serviceimpl;

import java.io.File;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;


@Service
@Component
public class EmailSendServiceImpl {
	 	@Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String senderMailAddress;

	    @Autowired
	    private TemplateEngine templateEngine;

	    public void sendSimpleMail(Map<String, Object> valueMap) {

	        System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
	        MimeMessage mimeMessage = null;
	        try {
	            mimeMessage = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true ,"UTF-8");
	            // 设置发件人邮箱
	            helper.setFrom(senderMailAddress);
	            // 设置收件人邮箱
	            helper.setTo((String[])valueMap.get("to"));
	            // 设置邮件标题
	            helper.setSubject(valueMap.get("title").toString());

	            // 添加正文（使用thymeleaf模板）
	            helper.setText(valueMap.get("content").toString());

	            // 添加附件
	            if (valueMap.get("filePathList") != null) {
	                String[] filePathList = (String[]) valueMap.get("filePathList");
	                for(String filePath: filePathList) {
	                    FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
	                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
	                    //阶段string去掉uuid
	                    fileName = fileName.substring(34);
	                    try {
	                    	fileName = MimeUtility.encodeWord(fileName);
						} catch (Exception e) {
							// TODO: handle exception
						}
	                    helper.addAttachment(fileName, fileSystemResource);
	                }
	            }

	            // 发送邮件
	            javaMailSender.send(mimeMessage);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }

}
