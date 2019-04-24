package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.list.CompanyListDTO;
import com.our.oa.dto.list.CompanyListQueryDTO;
import com.our.oa.entity.Company;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    Company selectByPrimaryKey(Integer companyId);
    
    Page<CompanyListDTO> selectQueryList(CompanyListQueryDTO queryDTO);

    int updateByPrimaryKey(Company record);
}