package com.our.oa.serviceimpl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.CustomerMapper;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.list.CustomerListDTO;
import com.our.oa.dto.list.CustomerListQueryDTO;
import com.our.oa.entity.Customer;
import com.our.oa.service.CustomerService;

@Service
public class CustomerServicelmpl implements CustomerService {

	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public CustomerDTO getByPrimaryKey(Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Customer customer = mapper.selectByPrimaryKey(id);
		CustomerDTO record = modelMapper.map(customer, CustomerDTO.class);
		return record;
	}

	@Override
	public Page<CustomerListDTO> getGridList(CustomerListQueryDTO g) {
		Page<CustomerListDTO> queryResult = mapper.selectQueryList(g);
		 if(!queryResult.isEmpty()) {
			 return queryResult;
		 }	 
		 return new Page<>();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		mapper.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public int insert(CustomerDTO DTO) {
		ModelMapper modelMapper = new ModelMapper();
		Customer record = modelMapper.map(DTO, Customer.class);
		return mapper.insert(record);
	}

	@Override
	public int updateByPrimaryKey(CustomerDTO DTO) {
		ModelMapper modelMapper = new ModelMapper();
		Customer record = modelMapper.map(DTO, Customer.class);
		mapper.updateByPrimaryKey(record);
		return 0;
	}

	@Override
	public List<Customer> getByCustomerType(Integer type) {
		ModelMapper modelMapper = new ModelMapper();
		List<Customer> customer = mapper.selectByCustomerType(type);
		//CustomerDTO record = modelMapper.map(customer, CustomerDTO.class);
		return customer;
	}
}
