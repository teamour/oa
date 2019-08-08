package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoResponseDTO;
import com.our.oa.dto.list.OUR002SendMailRecordInfoResponseDTO;
import com.our.oa.entity.Mailing;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface MailingMapper {
	int insert(Mailing record);
	
    int deleteByPrimaryKey(Integer mailingId);

    Mailing selectByPrimaryKey(Integer mailingId);

    List<Mailing> selectAll();

    int updateByPrimaryKey(Mailing record);
    
    Mailing selectMaxMailingId();
    
    Page<OUR002SendMailRecordInfoResponseDTO> selectSendMailRecordOUR002();
}