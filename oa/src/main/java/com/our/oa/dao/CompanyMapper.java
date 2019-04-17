package com.our.oa.dao;

import java.util.List;

import com.our.oa.entity.Company;

public interface CompanyMapper{
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    Company selectByPrimaryKey(Integer companyId);

    List<Company> selectAll();

    int updateByPrimaryKey(Company record);
}
