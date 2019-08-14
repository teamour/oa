package com.our.oa.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.our.oa.controller.OUR002SendMailRecordController;
import com.our.oa.dao.MailingCustomerMapper;
import com.our.oa.dao.MailingMapper;
import com.our.oa.dto.list.OUR002MailRecordDetailResponseDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoRequestDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoResponseDTO;
import com.our.oa.service.OUR002SendMailRecordService;

@Service
public class OUR002SendMailRecordServiceImpl implements OUR002SendMailRecordService{
	private static final Logger logger = LoggerFactory.getLogger(OUR002SendMailRecordController.class);
	@Autowired
	private MailingMapper mailingMapper;
	@Autowired
	private MailingCustomerMapper mailingcustomerMapper;
	@Override
	public Page<OUR002SendMailRecordInfoResponseDTO> getGridList(OUR002SendMailRecordInfoRequestDTO g) {
		Page<OUR002SendMailRecordInfoResponseDTO> mailing = mailingMapper.selectSendMailRecordOUR002();
		return mailing;
	}
	
	@Override
	public Page<OUR002MailRecordDetailResponseDTO> getMailRecordDetail(Integer mailingId) {
		Page<OUR002MailRecordDetailResponseDTO> mailingcustomerList = mailingcustomerMapper.selectByMailingId(mailingId);
		return mailingcustomerList;
	}
	
	@Transactional
	@Override
	public boolean deleteSendMailRecord(String mailingIds) {
		try {
			List<Integer> mainingIdList = getListCustomerid(mailingIds);
			for (Integer integer : mainingIdList) {
				deleteEverySendMailRecord(integer);
			}
			return true;
		} catch (Exception e) {
			logger.error("delete send mail record happen Exception!");
			throw new RuntimeException("deleteEverySendMailRecord happen Exception！");
		}
		
	}
	
	private boolean deleteEverySendMailRecord(Integer mailingId) throws Exception {
		logger.info("delete every send mail record mailingId:" + mailingId);
		
		int delMailingCustomerRes = mailingcustomerMapper.deleteByMailingId(mailingId);
		logger.info("delete t_mailing_customer table result Code: " + delMailingCustomerRes);
		
		int delMainingRes = mailingMapper.deleteByPrimaryKey(mailingId);
		logger.info("delete t_mailing table result Code: " + delMainingRes);
		return true;
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
}
