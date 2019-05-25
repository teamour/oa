package com.our.oa.service;

import java.util.List;

import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.list.CustomerListDTO;
import com.our.oa.dto.list.CustomerListQueryDTO;
import com.our.oa.entity.Customer;

public interface CustomerService extends ListQueryService<CustomerListDTO,CustomerListQueryDTO>{
	CustomerDTO getByPrimaryKey(Integer id);
	
	List<Customer> getByCustomerType(Integer type);
	
	int insert(CustomerDTO DTO);
	
	int updateByPrimaryKey(CustomerDTO DTO);
	
	int deleteByPrimaryKey(Integer id);
}
