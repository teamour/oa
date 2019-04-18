package com.our.oa.dao;

import com.our.oa.dto.list.CompanyListQueryDTO;
import com.our.oa.entity.Company;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    Company selectByPrimaryKey(Integer companyId);
    
    List<Company> selectQueryList(CompanyListQueryDTO queryDTO);

    int updateByPrimaryKey(Company record);
}