package com.our.oa.dao;

import com.our.oa.dto.list.CustomerListQueryDTO;
import com.our.oa.entity.Customer;

import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    List<Customer> selectAll();
    
    List<Customer> selectQueryList(CustomerListQueryDTO DTO);

    int updateByPrimaryKey(Customer record);
}