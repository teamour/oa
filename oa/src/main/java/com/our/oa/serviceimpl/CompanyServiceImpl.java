package com.our.oa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.CompanyMapper;
import com.our.oa.dto.CompanyDTO;
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
	public List<CompanyDTO> getAll() {
		ModelMapper modelMapper = new ModelMapper();
		List<Company> list = mapper.selectAll();
		List<CompanyDTO> dtolist = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			CompanyDTO record = modelMapper.map(list.get(i), CompanyDTO.class);
			dtolist.add(record);
		}

		return dtolist;
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
		mapper.deleteByPrimaryKey(companyId);
		return 0;
	}
}
