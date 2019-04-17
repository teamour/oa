package com.our.oa.dao;

import com.our.oa.entity.EmployeeStudy;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface EmployeeStudyMapper {
    int deleteByPrimaryKey(Integer employeeStudyId);

    int insert(EmployeeStudy record);

    EmployeeStudy selectByPrimaryKey(Integer employeeStudyId);

    List<EmployeeStudy> selectAll();

    int updateByPrimaryKey(EmployeeStudy record);
}