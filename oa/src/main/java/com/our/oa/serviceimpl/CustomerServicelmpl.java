package com.our.oa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.CustomerMapper;
import com.our.oa.dto.form.CustomerDTO;
import com.our.oa.dto.list.CompanyListDTO;
import com.our.oa.dto.list.CustomerListDTO;
import com.our.oa.dto.list.CustomerListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Customer;
import com.our.oa.service.CustomerService;
import com.our.oa.utils.ModelMapperUtils;

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
	public List<CustomerListDTO> getGridList(CustomerListQueryDTO g) {
		 List<Customer> queryResult = mapper.selectQueryList(g);
		 if(!queryResult.isEmpty()) {
			return ModelMapperUtils.mapCollection(queryResult, CustomerListDTO.class);			 
		 }
		 return new ArrayList<CustomerListDTO>();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return 0;
	}
}
