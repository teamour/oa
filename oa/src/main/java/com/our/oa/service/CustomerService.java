package com.our.oa.service;

import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.list.CustomerListDTO;
import com.our.oa.dto.list.CustomerListQueryDTO;

public interface CustomerService extends ListQueryService<CustomerListDTO,CustomerListQueryDTO>{
	CustomerDTO getByPrimaryKey(Integer id);
	
	int insert(CustomerDTO DTO);
	
	int updateByPrimaryKey(CustomerDTO DTO);
	
	int deleteByPrimaryKey(Integer id);
}
