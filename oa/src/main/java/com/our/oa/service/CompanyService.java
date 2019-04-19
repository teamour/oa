package com.our.oa.service;

import com.our.oa.dto.form.CompanyDTO;
import com.our.oa.dto.list.CompanyListDTO;
import com.our.oa.dto.list.CompanyListQueryDTO;

public interface CompanyService extends ListQueryService<CompanyListDTO,CompanyListQueryDTO>{

	CompanyDTO getByPrimaryKey(Integer companyId);
	
	int insert(CompanyDTO companyDTO);
	
	int updateByPrimaryKey(CompanyDTO companyDTO);
	
	int deleteByPrimaryKey(Integer companyId);
}
