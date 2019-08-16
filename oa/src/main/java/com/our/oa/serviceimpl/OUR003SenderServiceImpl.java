package com.our.oa.serviceimpl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.controller.OUR002SendMailRecordController;
import com.our.oa.dao.SenderMapper;
import com.our.oa.entity.Sender;
import com.our.oa.service.OUR003SenderService;
import com.our.oa.utils.CodeInterfaceUtils;

@Service
public class OUR003SenderServiceImpl implements OUR003SenderService{
	private static final Logger logger = LoggerFactory.getLogger(OUR002SendMailRecordController.class);

	@Autowired
	private SenderMapper mapper;
	
	@Override
	public Page<Sender> getSenderAll() {
		return mapper.selectAll();
	}

	@Override
	public boolean insertSender(Sender sender) {
		try {
			mapper.insert(sender);
			return true;
		} catch (Exception e) {
			logger.error("insertSender happen Exception!" + e);
			return false;
		}
	}

	@Override
	public boolean deleteSender(String senderId) {
		try {
			List<Integer> senderIdList = CodeInterfaceUtils.getInstance().getListid(senderId);
			for (Integer integer : senderIdList) {
				mapper.deleteBySenderId(integer);
			}
			return true;
		} catch (Exception e) {
			logger.error("deleteSender happen Exception!" + e);
			return false;
		}
		
	}

	@Override
	public List<Sender> getSenderAllList() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}
