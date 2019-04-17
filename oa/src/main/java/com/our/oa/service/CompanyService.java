package com.our.oa.service;


import java.util.List;

import com.our.oa.dto.CompanyDTO;

public interface CompanyService {

	CompanyDTO getByPrimaryKey(Integer companyId);
	
	int insert(CompanyDTO companyDTO);
	
	List<CompanyDTO> getAll();
	
	int updateByPrimaryKey(CompanyDTO companyDTO);
	
	int deleteByPrimaryKey(Integer companyId);
}
