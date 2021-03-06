package com.our.oa.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.our.oa.dao.CompanyMapper;
import com.our.oa.dto.form.CompanyDTO;
import com.our.oa.dto.list.CompanyListDTO;
import com.our.oa.dto.list.CompanyListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper mapper;
	
	@Override
	public CompanyDTO getByPrimaryKey(Integer companyId) {
		ModelMapper modelMapper = new ModelMapper();
		Company company = mapper.selectByPrimaryKey(companyId);
		CompanyDTO record = modelMapper.map(company, CompanyDTO.class);
		return record;
	}

	@Override
	public int insert(CompanyDTO companyDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Company record = modelMapper.map(companyDTO, Company.class);
		return mapper.insert(record);
	}
	
	@Override
	public int updateByPrimaryKey(CompanyDTO companyDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Company record = modelMapper.map(companyDTO, Company.class);
		mapper.updateByPrimaryKey(record);
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer companyId) {
		System.out.println("enter deleteByPrimaryKey");
		mapper.deleteByPrimaryKey(companyId);
		return 0;
	}

	@Override
	public Page<CompanyListDTO> getGridList(CompanyListQueryDTO g) {
		 Page<CompanyListDTO> queryResult = mapper.selectQueryList(g);
		 if(!queryResult.isEmpty()) {
			 return queryResult;
		 }	 
		 return new Page<>();
	}
}
