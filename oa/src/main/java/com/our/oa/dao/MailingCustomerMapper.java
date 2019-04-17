package com.our.oa.dao;

import com.our.oa.entity.MailingCustomer;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface MailingCustomerMapper {
    int insert(MailingCustomer record);

    List<MailingCustomer> selectAll();
}