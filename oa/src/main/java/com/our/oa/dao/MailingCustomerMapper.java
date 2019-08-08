package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.list.OUR002MailRecordDetailResponseDTO;
import com.our.oa.entity.MailingCustomer;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface MailingCustomerMapper {
    int insert(MailingCustomer record);

    List<MailingCustomer> selectAll();
    
    Page<OUR002MailRecordDetailResponseDTO> selectByMailingId(Integer mailing_id);
}