package com.our.oa.service;

import com.github.pagehelper.Page;
import com.our.oa.dto.list.OUR002MailRecordDetailResponseDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoRequestDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoResponseDTO;

public interface OUR002SendMailRecordService extends ListQueryService<OUR002SendMailRecordInfoResponseDTO, OUR002SendMailRecordInfoRequestDTO>{
	
	Page<OUR002MailRecordDetailResponseDTO> getMailRecordDetail(Integer mailingId); 
	
	boolean deleteSendMailRecord(String id);
}
