package com.our.oa.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.our.oa.dao.MailingCustomerMapper;
import com.our.oa.dao.MailingMapper;
import com.our.oa.dto.list.OUR002MailRecordDetailResponseDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoRequestDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoResponseDTO;
import com.our.oa.service.OUR002SendMailRecordService;

@Service
public class OUR002SendMailRecordServiceImpl implements OUR002SendMailRecordService{
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
}
