package com.our.oa.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.our.oa.dto.list.CustomerListDTO;
import com.our.oa.dto.list.CustomerListQueryDTO;
import com.our.oa.dto.list.OUR001SendMailCustomerInfoResponseDTO;
import com.our.oa.entity.Customer;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    Customer selectByPrimaryKey(Integer customerId);
    
    List<Customer> selectByCustomerType(Integer companyType);

    Page<CustomerListDTO> selectQueryList(CustomerListQueryDTO DTO);

    int updateByPrimaryKey(Customer record);
    
    Page<OUR001SendMailCustomerInfoResponseDTO> getSendMailCustomerInfoOUR001(Integer compayType, Integer CooperationIntention);
}